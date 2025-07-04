package strategy;

import java.time.LocalDate;

public class Expiry implements ExpiryStrategy{
    private LocalDate expiryDate;

    public Expiry(LocalDate expiryDate){
        this.expiryDate=expiryDate;
    }
    @Override
    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }

    @Override
    public LocalDate getExpiryDate() {
        return expiryDate;
    }
}
