package nrn.noah.priv.util;

import java.util.Map;

public class Person {
    private String firstName;
    private String lastName;
    private double totalPaid;
    private double totalBorrowed;
    // Maps each person's name to the amount owed by this person
    private Map<String, Double> owesTo;

    // Constructors, getters, and setters
    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.totalPaid = 0.0;
        this.totalBorrowed = 0.0;
    }

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(double totalPaid) {
        this.totalPaid = totalPaid;
    }

    public double getTotalBorrowed() {
        return totalBorrowed;
    }

    public void setTotalBorrowed(double totalBorrowed) {
        this.totalBorrowed = totalBorrowed;
    }

    public Map<String, Double> getOwesTo() {
        return owesTo;
    }

    public void setOwesTo(Map<String, Double> owesTo) {
        this.owesTo = owesTo;
    }
}

