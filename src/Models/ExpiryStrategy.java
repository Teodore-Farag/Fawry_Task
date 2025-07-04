package Models;

import java.time.LocalDate;

public interface ExpiryStrategy {
    boolean isExpired();
    LocalDate getExpiryDate();
}
