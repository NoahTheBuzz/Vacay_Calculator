package nrn.noah.priv.util;

import java.util.List;

public class Payment {
    private double amount;
    private Person payer;
    private List<LentInfo> lentDetails;

    // Constructor
    public Payment() {
    }

    // Include getters, and setters
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Person getPayer() {
        return payer;
    }

    public void setPayer(Person payer) {
        this.payer = payer;
    }

    public List<LentInfo> getLentDetails() {
        return lentDetails;
    }

    public void setLentDetails(List<LentInfo> lentDetails) {
        this.lentDetails = lentDetails;
    }


    // Inner class to represent to whom and how much was lent
    public static class LentInfo {
        private Person person;
        private double amount;

        // Constructor
        public LentInfo() {
        }

        // Getters, and Setters
        public Person getPerson() {
            return person;
        }

        public void setPerson(Person person) {
            this.person = person;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }
    }
}

