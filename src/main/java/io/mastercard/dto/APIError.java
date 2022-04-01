package io.mastercard.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * @author <a href="mailto:nikhlesh.agrawal@gmail.com">Nikhlesh Agrawal</a>
 */
@Data
public class APIError {
  private HttpStatus status;
  private List<String> errors;
  private LocalDateTime timeStamp;
  private String pathUri;
}
