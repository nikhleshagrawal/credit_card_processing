package io.mastercard.service;

import org.springframework.stereotype.Component;

/**
 * @author <a href="mailto:nikhlesh.agrawal@gmail.com">Nikhlesh Agrawal</a>
 */
@Component
public class CreditCardValidationImpl implements CreditCardValidation{
  @Override
  public boolean validateCard(String ccNumber){
    int [] a =  {ccNumber.length() % 2 == 0 ? 1 : 2};
    return ccNumber.chars()
        .map(num-> num - '0')
        .map(num->num*(a[0]=(a[0]==1?2:1)))
        .map(num -> num >9 ? num-9:num )
        .sum() % 10 == 0;

  }
}
