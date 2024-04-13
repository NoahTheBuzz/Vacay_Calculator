package nrn.noah.priv.helper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import nrn.noah.priv.util.Person;

/*
 * PrettyPrinter class
 * 
 * This class is used to pretty print the different objects
 */
public class PrettyPrinter {

    private static final String base = "  ";

    /*
     * Pretty print a UUID
     * 
     * @param uuid The UUID to be printed
     * @return A string with the UUID
     */
    public static String prettyUUID(UUID uuid){
        return base + uuid.toString() + base;
    }

    public static String prettyHeadline(List<String> headlines, int[] widths){
        StringBuilder result = new StringBuilder("\u2503");

        for(int n = 0; n < 2; n++){
            if(n == 0){
                for(int i = 0; i < headlines.size(); i++){
                    result.append(base);
                    int length = headlines.get(i).length();
                    int totalspaces = widths[i] - length;
                    int spaces = totalspaces / 2;

                    for(int j = 0; j < spaces; j++){
                        result.append(" ");
                    }

                    result.append(headlines.get(i));

                    for(int j = 0; j < (totalspaces - spaces); j++){
                        result.append(" ");
                    }

                    result.append(base + "\u2503");
                }
            }else{
                // Print the line below the headling starting and ending with \u2503 underlining the headline with \u2501 and separating the columns with \u254b
                result.append("\n\u2523");
                for(int i = 0; i < headlines.size(); i++){
                    for(int j = 0; j < widths[i]+4; j++){
                        result.append("\u2501");
                    }
                    if(i == headlines.size()-1){
                        result.append("\u252b");
                    }else{
                        result.append("\u254b");
                    }
                }
            }
        }

        return result.toString();
    }

    /*
     * Pretty print a transaction date
     * 
     * @param date The date to be printed
     * @return A string with the date and time
     * 
     * The date is printed in the format "YYYY-MM-DD"
     * The time is printed in the format "HH:MM:SS"
     */
    public static String prettyTransactionDate(LocalDateTime date){
        String result = base;

        // DATE
        // YEAR
        if(date.getYear() < 1000){
            result += " " + date.getYear() + "-";
        }else{
            result += date.getYear() + "-";
        }

        // MONTH
        if(date.getMonthValue() < 10){
            result += "0" + date.getMonthValue() + "-";
        }else{
            result += date.getMonthValue() + "-";
        }

        // DAY
        if(date.getDayOfMonth() < 10){
            result += "0" + date.getDayOfMonth();
        }else{
            result += date.getDayOfMonth();
        }

        result += base;

        // TIME
        // HOUR
        if(date.getHour() < 10){
            result += "0" + date.getHour() + ":";
        }else{
            result += date.getHour() + ":";
        }

        // MINUTE
        if(date.getMinute() < 10){
            result += "0" + date.getMinute() + ":";
        }else{
            result += date.getMinute() + ":";
        }

        // SECOND
        if(date.getSecond() < 10){
            result += "0" + date.getSecond();
        }else{
            result += date.getSecond();
        }

        result += base;

        return result;
    }

    /*
     * Pretty print a payer
     * 
     * @param payer The payer to be printed
     * @return A string with the payer's first and last name
     */
    public static String prettyPayer(Person payer){
        String result = base;

        // FIRST NAME
        int length = payer.FIRSTNAME().length();

        if(length == 1){
            result += payer.FIRSTNAME() + ".        ";
        }else if(length > 10){
            result += payer.FIRSTNAME().substring(0, 7) + "...";
        }else{
            result += payer.FIRSTNAME();
            for(int i = 0; i < 10-length; i++){
                result += " ";
            }
        }

        result += base;

        // LAST NAME
        length = payer.LASTNAME().length();

        if(length == 1){
            result += payer.LASTNAME() + ".        ";
        }else if(length > 10){
            result += payer.LASTNAME().substring(0, 7) + "...";
        }else{
            result += payer.LASTNAME();
            for(int i = 0; i < 10-length; i++){
                result += " ";
            }
        }

        result += base;

        return result;
    }

    /*
     * Pretty print the total amount
     * 
     * @param amount The amount to be printed
     * @return A string with the amount
     * 
     * The amount is printed with 2 digits after the komma
     * The amount is right-aligned
     * The amount is in "€"
     */
    public static String prettyTotalAmount(double amount){
        String result = base + " ";

        // Print amount with 2 digits after the komma
        String amountString = String.format("%.2f", amount);

        if(amount < -9999){
            result += amountString;
        }else if (amount < -999){
            result += " " + amountString;
        }else if (amount < -99){
            result += "  " + amountString;
        }else if (amount < -9){
            result += "   " + amountString;
        }else if (amount < 0){
            result += "    " + amountString;
        }else if (amount < 10){
            result += "     " + amountString;
        }else if (amount < 100){
            result += "    " + amountString;
        }else if (amount < 1000){
            result += "   " + amountString;
        }else if (amount < 10000){
            result += "  " + amountString;
        }else{
            result += " " + amountString;
        }

        return result + "€" + base + " ";
    }
}