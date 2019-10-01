package metrodesign.domain;

import java.math.BigDecimal;

public class TravelCard {
    private long id ;
    private BigDecimal balance;
    private Traveller traveller;

    public TravelCard(long id, BigDecimal balance, Traveller traveller) {
        this.id = id;
        this.balance = balance;
        this.traveller =traveller;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Traveller getTraveller() {
        return traveller;
    }

    public void setTraveller(Traveller traveller) {
        this.traveller = traveller;
    }
}
