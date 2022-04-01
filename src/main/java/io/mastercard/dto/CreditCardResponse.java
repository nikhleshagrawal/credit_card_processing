package io.mastercard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author <a href="mailto:nikhlesh.agrawal@gmail.com">Nikhlesh Agrawal</a>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardResponse {
  private String status;
  private String message;
}
