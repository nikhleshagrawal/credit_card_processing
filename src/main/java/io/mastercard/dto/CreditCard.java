package io.mastercard.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * @author <a href="mailto:nikhlesh.agrawal@gmail.com">Nikhlesh Agrawal</a>
 */
@Entity
@Data
@Table(name="credit_card")
public class CreditCard {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Long id;

  @NotNull(message = "must not be null")
  private String name;
  @NotNull(message = "must not be null")
  @Length(min=1, max = 19, message = "min 1 character and max 19 characters allowed")
  @Digits(message = "must be a number", integer = 19, fraction = 0)
  private String cardNumber;
  @NotNull(message = "must not be null")
  private Long cardLimit;

  private Double balance = 0.0;
}
