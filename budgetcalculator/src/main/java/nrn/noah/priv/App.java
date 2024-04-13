package nrn.noah.priv;

import java.util.Map;

import nrn.noah.priv.mgmt.JsonFileManager;
import nrn.noah.priv.util.Person;
import nrn.noah.priv.util.Transaction;
import nrn.noah.priv.util.Vacation;

public class App 
{
    public static void main( String[] args )
    {
        Person noah = new Person("Noah", "Sarcevic");
        Person john = new Person("Johnovian", "Doe");
        Person diana = new Person("Diana", "Smith");
        Person kelly = new Person("K", "Clarkson");
        Person insanelyLongName = new Person("Challangutonga", "Kamikulellokole");
        
        Vacation vacation = new Vacation("My Test Vacation");

        vacation.addParticipant(noah);
        vacation.addParticipant(john);
        vacation.addParticipant(diana);
        vacation.addParticipant(kelly);
        vacation.addParticipant(insanelyLongName);

        Map<Person, Double> dist1 = Map.of(noah, 50.0, john, 25.0, diana, 25.0);
        Transaction transaction = new Transaction(noah, 100.0, dist1);
        vacation.addTransaction(transaction);

        Transaction transaction2 = new Transaction(john, 100.0, dist1);
        Transaction transaction3 = new Transaction(diana, 100.0, dist1);
        Transaction transaction4 = new Transaction(diana, 1000.0, dist1);
        Transaction transaction5 = new Transaction(kelly, 100.0, dist1);
        Transaction transaction6 = new Transaction(noah, 696.9, dist1);
        Transaction transaction7 = new Transaction(kelly, 6969.0, dist1);
        Transaction transaction8 = new Transaction(insanelyLongName, -450.78, dist1);

        vacation.addTransaction(transaction2);
        vacation.addTransaction(transaction3);
        vacation.addTransaction(transaction8);
        vacation.addTransaction(transaction4);
        vacation.addTransaction(transaction5);
        vacation.addTransaction(transaction6);
        vacation.addTransaction(transaction7);


        // Transaction transaction9 = transaction8;
        // vacation.removeTransaction(transaction9);

        System.out.println(Transaction.toStringHeadline());
        for(Transaction t : vacation.getTransactions()) {
            System.out.println(t.toString());
        }

        String basePath = "/home/noah/Projects/Test_Center/";
        JsonFileManager jsonFileManager = JsonFileManager.getInstance();
        jsonFileManager.initialize("/home/noahthebuzz/Projects/Test_Center/");

        jsonFileManager.saveData(vacation, "vacations", vacation.VACATION_NAME() + ".json");
    }
}
