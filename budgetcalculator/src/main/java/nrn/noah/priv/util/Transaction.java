package nrn.noah.priv.util;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

import nrn.noah.priv.helper.PrettyPrinter;

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
    public String toString(){
        return "\u2503" + 
                PrettyPrinter.prettyUUID(TRANSACTION_ID) + "\u2503" +
                PrettyPrinter.prettyTransactionDate(TRANSACTION_DATE) + "\u2503" + 
                PrettyPrinter.prettyPayer(payer) + "\u2503" +
                PrettyPrinter.prettyTotalAmount(totalAmount) + 
                "\u2503";
    }

    public static String toStringHeadline(){
        return PrettyPrinter.prettyHeadline(new ArrayList<>(){{
            add("TRANSACTION_ID");
            add("TRANSACTION_DATE");
            add("PAYER");
            add("TOTAL_AMOUNT");
        }}, new int[]{36, 20, 22, 12});
    }
}