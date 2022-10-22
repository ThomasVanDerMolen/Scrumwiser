import java.time.LocalDate;


/*
 * credit to https://www.javatpoint.com/java-get-current-date
 */
public class point {
    private double pointValue;
    private LocalDate date;
    public point(double inputPoints){
        pointValue = inputPoints;
        date = java.time.LocalDate.now();
        System.out.println(date);
    }
    public double getValue(){
        return pointValue;
    }
    public String getDateString(){
        return String.valueOf(date);
    }
}
