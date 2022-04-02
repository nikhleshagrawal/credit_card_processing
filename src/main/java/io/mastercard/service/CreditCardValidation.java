package io.mastercard.service;

import org.springframework.stereotype.Component;

/**
 * @author <a href="mailto:nikhlesh.agrawal@gmail.com">Nikhlesh Agrawal</a>
 */
@Component
public interface CreditCardValidation {
  public boolean validateCard(String ccNumber);
}
