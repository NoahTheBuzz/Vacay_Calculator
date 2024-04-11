package nrn.noah.priv.util;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Vacation {
    private final UUID VACATION_ID;
    private final String VACATION_NAME;
    private final LocalDateTime VACATION_DATE;
    
    private List<Person> participants;
    private List<Transaction> transactions;

    public Vacation(String name) {
        this.VACATION_ID = UUID.randomUUID();
        this.VACATION_NAME = name;
        this.VACATION_DATE = LocalDateTime.now();

        this.participants = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    // Getters and Setters
    public UUID VACATION_ID() {
        return VACATION_ID;
    }

    public String VACATION_NAME() {
        return VACATION_NAME;
    }

    public Month getMonth() {
        return VACATION_DATE.getMonth();
    }

    public int getYear() {
        return VACATION_DATE.getYear();
    }

    public List<Person> getParticipants() {
        return participants;
    }

    public void addParticipant(Person bonus) {
        this.participants.add(bonus);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public void removeTransaction(Transaction transaction) {
        this.transactions.remove(transaction);
    }

    // Functions
    public String toString() {
        return "Vacation{" +
                "VACATION_ID=" + VACATION_ID +
                ", VACATION_NAME='" + VACATION_NAME + '\'' +
                ", VACATION_DATE=" + VACATION_DATE +
                ", participants=" + participants +
                ", transactions=" + transactions +
                '}';
    }
}

