package nrn.noah.priv;

import java.util.Map;

import nrn.noah.priv.util.Person;
import nrn.noah.priv.util.Transaction;
import nrn.noah.priv.util.Vacation;

public class App 
{
    public static void main( String[] args )
    {
        Person noah = new Person("Noah", "Sarcevic");
        Person john = new Person("John", "Doe");
        Person diana = new Person("Diana", "Smith");
        
        Vacation vacation = new Vacation("My Vacation");

        vacation.addParticipant(noah);
        vacation.addParticipant(john);
        vacation.addParticipant(diana);

        Map<Person, Double> dist1 = Map.of(noah, 50.0, john, 25.0, diana, 25.0);
        Transaction transaction = new Transaction(noah, 100.0, dist1);
        vacation.addTransaction(transaction);
        System.out.println(Transaction.toStringHeader());
        for(Transaction t : vacation.getTransactions()) {
            System.out.println(t.toStringBody());
        }

        // Transaction transaction2 = transaction;
        // vacation.removeTransaction(transaction2);
        // System.out.println(vacation.getTransactions().toString());
    }
}
