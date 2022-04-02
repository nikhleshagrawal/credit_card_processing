package io.mastercard.service;

import io.mastercard.dto.CreditCard;
import io.mastercard.dto.CreditCardResponse;
import io.mastercard.exception.CreditCardNotValidException;
import io.mastercard.repository.CardRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:nikhlesh.agrawal@gmail.com">Nikhlesh Agrawal</a>
 */
@AllArgsConstructor
@Service
public class CardService {
  private final CardRepository repository;
  private final CreditCardValidation cardValidation;

  public CreditCard addCard(CreditCard card){
    if(!cardValidation.validateCard(card.getCardNumber())){
      throw new CreditCardNotValidException("Credit card not valid");
    }
    return repository.save(card);
  }

  public List<CreditCard> getCards(){
    return repository.findAll();
  }
}
