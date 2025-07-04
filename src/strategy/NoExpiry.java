package strategy;

import java.time.LocalDate;

public class NoExpiry implements ExpiryStrategy {

    @Override
    public boolean isExpired() {
        return false;
    }

    @Override
    public LocalDate getExpiryDate() {
        return null;
    }
}

