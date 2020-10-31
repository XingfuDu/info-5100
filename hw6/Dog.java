import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
public class Dog extends Pet implements Boardable {

    private String size;
    private LocalDate startDate;
    private LocalDate endDate;
    
    public Dog(String name, String ownerName, String color, String size) {
	super(name,ownerName,color);
	this.size = size;
    }
    
    public String getSize() {
    	return this.size;
    }
    
    @Override
	public String toString() {
	String text = "DOG: \n";
	text += super.toString();
	text += "\nSize: "+ getSize() + "\n";
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
    