package nrn.noah.priv.util;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

public class Transaction {

    private final UUID TRANSACTION_ID;
    private final LocalDateTime TRANSACTION_DATE;

    private Person payer;
    private double totalAmount;
    private Map<Person, Double> distribution;

    // Constructor
    public Transaction(Person payer, double amount, Map<Person, Double> distribution) {
        TRANSACTION_ID = UUID.randomUUID();
        TRANSACTION_DATE = LocalDateTime.now();

        this.payer = payer;
        this.totalAmount = amount;
        this.distribution = distribution;
    }

    // Include getters, and setters
    public UUID TRANSACTION_ID() {
        return TRANSACTION_ID;
    }

    public LocalDateTime TRANSACTION_DATE() {
        return TRANSACTION_DATE;
    }

    public Person getPayer() {
        return payer;
    }

    public void setPayer(Person payer) {
        this.payer = payer;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double amount) {
        this.totalAmount = amount;
    }

    public Map<Person, Double> getDistribution() {
        return distribution;
    }

    public void setDistribution(Map<Person, Double> distribution) {
        this.distribution = distribution;
    }

    // Functions
    public String toString() {
        return "Transaction{" +
                "\n  >   TRANSACTION_ID = " + TRANSACTION_ID +
                "\n  > TRANSACTION_DATE = " + TRANSACTION_DATE +
                "\n  >            payer = " + payer.FIRSTNAME() + ", " + payer.LASTNAME() +
                "\n  >      totalAmount = " + totalAmount +
                "\n  >     distribution = " + distribution +
                "\n}";
    }

    public static String toStringHeader(){
        return "           TRANSACTION_ID           |       TRANSACTION_DATE       |        PAYER       |TOTAL_AMOUNT|" + 
               "\n____________________________________|______________________________|____________________|____________|";
    }

    public String toStringBody(){
        return TRANSACTION_ID + "|" + TRANSACTION_DATE.getYear() + "-" + TRANSACTION_DATE.getMonthValue() + "-" + TRANSACTION_DATE.getDayOfMonth() + " " + TRANSACTION_DATE.getHour() + ":" + TRANSACTION_DATE.getMinute() + ":" + TRANSACTION_DATE.getSecond() + "|" + payer.FIRSTNAME() + " " + payer.LASTNAME() + "|" + totalAmount + "|";
    }
}