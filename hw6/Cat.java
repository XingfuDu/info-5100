import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
public class Cat extends Pet implements Boardable {

    private String hairLength;
    private LocalDate startDate;
    private LocalDate endDate;
    
    public Cat(String name, String ownerName, String color, String hairLength) {
	super(name,ownerName,color);
	this.hairLength = hairLength;
    }
    
    public String getHairLength() {
	return hairLength;
    }
    
    @Override
    public String toString() {
	String text = "CAT: \n";
	text += super.toString();
	text += "\nHair: "+ hairLength + "\n";
	return text;
    }
    
    @Override 
    public void setBoardStart(int month, int day, int year) {
        startDate = LocalDate.of(year,month,day);
    }

    @Override 
    public void setBoardEnd(int month, int day, int year) {
	endDate = LocalDate.of(year,month,day);
    }

    @Override
    public boolean boarding(int month, int day, int year) {
	LocalDate currDate = LocalDate.of(year,month,day);
	if (currDate.compareTo(startDate) >= 0 && currDate.compareTo(endDate) <= 0) {
	    return true;
	}
	return false;
    }
}
    