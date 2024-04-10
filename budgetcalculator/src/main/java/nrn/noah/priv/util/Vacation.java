package nrn.noah.priv.util;

import java.util.ArrayList;
import java.util.List;
import nrn.noah.priv.helper.Month;

public class Vacation {
    private String name;
    private Month month; // Format: "MM-yyyy"
    private int year;
    private List<Person> attendees;
    private List<Payment> paymentHistory;

    public Vacation() {
        this.attendees = new ArrayList<>();
        this.paymentHistory = new ArrayList<>();
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Person> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<Person> attendees) {
        this.attendees = attendees;
    }

    public List<Payment> getPaymentHistory() {
        return paymentHistory;
    }

    public void setPaymentHistory(List<Payment> paymentHistory) {
        this.paymentHistory = paymentHistory;
    }
}

