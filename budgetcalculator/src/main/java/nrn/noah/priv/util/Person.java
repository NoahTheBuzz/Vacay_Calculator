package nrn.noah.priv.util;

import java.util.Map;
import java.util.UUID;

public class Person {

    private final UUID USER_ID;

    private final String FIRSTNAME;
    private final String LASTNAME;
    
    private double totalPaid;
    private double totalOwed;
    // Maps each person's name to the amount owed by this person
    private Map<Person, Double> owesTo;

    // Constructors, getters, and setters
    public Person(String firstName, String lastName) {
        this.USER_ID = UUID.randomUUID();
        this.FIRSTNAME = firstName;
        this.LASTNAME = lastName;
        this.totalPaid = 0.0;
        this.totalOwed = 0.0;
    }

    // Getters and Setters
    public UUID USER_ID() {
        return USER_ID;
    }

    public String FIRSTNAME() {
        return FIRSTNAME;
    }

    public String LASTNAME() {
        return LASTNAME;
    }

    public double getTotalPaid() {
        return totalPaid;
    }

    public void increaseTotalPaid(double amountPaid) {
        this.totalPaid += amountPaid;
    }

    public double getTotalOwed() {
        return totalOwed;
    }

    public void increaseTotalOwed(double amountBorrowed) {
        this.totalOwed += amountBorrowed;
    }

    public Map<Person, Double> getOwesTo() {
        return owesTo;
    }

    public double getAmountOwedTo(Person personOwingTo) {
        return owesTo.getOrDefault(personOwingTo, 0.0);
    }

    public void increaseAmountOwedTo(Person personOwingTo, double amountOwed) {
        double currentAmount = owesTo.getOrDefault(personOwingTo, 0.0);
        owesTo.put(personOwingTo, currentAmount + amountOwed);
    }

    // Functions
    public String toString() {
        return "(" + FIRSTNAME + " " + LASTNAME + ")";
    }
}

