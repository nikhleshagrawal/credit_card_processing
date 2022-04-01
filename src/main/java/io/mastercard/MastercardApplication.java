package io.mastercard;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class MastercardApplication {

  public static void main(String[] args) {
    SpringApplication.run(MastercardApplication.class, args);
  }

}
