package io.mastercard.exception;

/**
 * @author <a href="mailto:nikhlesh.agrawal@gmail.com">Nikhlesh Agrawal</a>
 */
public class CreditCardNotValidException extends RuntimeException{
  public CreditCardNotValidException(String s){
    super(s);
  }
}
