package io.mastercard.repository;

import io.mastercard.dto.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author <a href="mailto:nikhlesh.agrawal@gmail.com">Nikhlesh Agrawal</a>
 */
@Repository
public interface CardRepository extends JpaRepository<CreditCard, String> {
}
