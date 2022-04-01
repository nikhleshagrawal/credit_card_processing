package io.mastercard.service;

import io.mastercard.dto.CreditCard;
import io.mastercard.dto.CreditCardResponse;
import io.mastercard.exception.CreditCardNotValidException;
import io.mastercard.repository.CardRepository;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * @author <a href="mailto:nikhlesh.agrawal@gmail.com">Nikhlesh Agrawal</a>
 */
class CardServiceTest {

  private CardRepository repository;
  private CardService cardService;

  @BeforeEach
  void setUp(){
    repository = mock(CardRepository.class);
    cardService = new CardService(repository);
  }

  @Test
  @DisplayName("Card not valid")
  void addCardCardNumberNotValid() {
    CreditCard card = new CreditCard();
    card.setName("Test");
    card.setCardLimit(1000L);
    card.setCardNumber("4024007109022143");
    assertThrows(CreditCardNotValidException.class, () -> cardService.addCard(card));
  }

  @Test
  @DisplayName("Card valid")
  void addCardCardNumberValid() {
    CreditCard card = new CreditCard();
    card.setName("Test");
    card.setCardLimit(1000L);
    card.setCardNumber("4556737586899855");
    when(repository.save(any(CreditCard.class))).thenReturn(card);
    CreditCardResponse creditCardResponse = cardService.addCard(card);
    CreditCardResponse expectedResponse = new CreditCardResponse("success", card.toString() + " added");
    assertEquals(expectedResponse, creditCardResponse);
  }

  @Test
  @DisplayName("No cards found in the system")
  void getNoCards() {
    when(repository.findAll()).thenReturn(Collections.emptyList());
    List<CreditCard> cards = cardService.getCards();
    assertTrue(cards.isEmpty());
  }

  @Test
  @DisplayName("Cards found in the system")
  void getCards() {
    when(repository.findAll()).thenReturn(Arrays.asList(new CreditCard(), new CreditCard()));
    List<CreditCard> cards = cardService.getCards();
    assertTrue(cards.size() == 2);
  }
}
