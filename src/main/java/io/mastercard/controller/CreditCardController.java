package io.mastercard.controller;

import io.mastercard.dto.CreditCard;
import io.mastercard.dto.CreditCardResponse;
import io.mastercard.service.CardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:nikhlesh.agrawal@gmail.com">Nikhlesh Agrawal</a>
 */
@AllArgsConstructor
@RestController
@RequestMapping("/v1")
@CrossOrigin
public class CreditCardController {

  private CardService cardService;

  @Operation(summary = "This is to add credit card")
  @ApiResponses(
      value = {
          @ApiResponse(
              responseCode = "201",
              description = "Add card",
              content = {@Content(mediaType = "application/json")}),
          @ApiResponse(responseCode = "404", description = "Not Available", content = @Content)
      })
  @PostMapping("/creditCards")
  public ResponseEntity<CreditCardResponse> addCreditCard(@Valid @RequestBody CreditCard card){
      CreditCard creditCard = cardService.addCard(card);
      CreditCardResponse creditCardResponse = new CreditCardResponse("success", creditCard.toString() + " added");
      return ResponseEntity.status(HttpStatus.CREATED).body(creditCardResponse);
  }

  @Operation(summary = "This is to fetch All the credit cards")
  @ApiResponses(
      value = {
          @ApiResponse(
              responseCode = "200",
              description = "Fetched all the cards",
              content = {@Content(mediaType = "application/json")}),
          @ApiResponse(responseCode = "404", description = "Not Available", content = @Content)
      })
  @GetMapping("/creditCards")
  public List<CreditCard> getCreditCards(){
    return cardService.getCards();
  }

}
