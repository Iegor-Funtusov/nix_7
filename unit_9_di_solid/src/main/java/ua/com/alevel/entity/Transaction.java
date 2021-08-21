package ua.com.alevel.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

public class Transaction {

    private Date date;
    private BigDecimal amount;
//    private Optional<BigDecimal> amount;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Optional<BigDecimal> getAmount() {
        return amount == null ? Optional.empty() : Optional.of(amount);
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
