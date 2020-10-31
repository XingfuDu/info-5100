import java.util.*;

public class Mreview implements Comparable<Mreview>
{
    // instance variables
    private String title;   // title of the movie
    private ArrayList<Integer> ratings; // list of ratings stored in a Store object

    // methods
    public Mreview() {
	title = "";
	ratings = new ArrayList<Integer>();
    }
    
    public Mreview(String ttl) {
	title = ttl;
	ratings = new ArrayList<Integer>();
    }

    public Mreview(String ttl, int firstRating) {
	title = ttl;
	ratings = new ArrayList<Integer>(firstRating);
    }

    public String getTitle() {
	return title;
    }

    public void addRating(int r) {
	if (ratings.size() == 0) {
	    ratings = new ArrayList<Integer>();
	} 
	ratings.add(r);
    }

    public double aveRating() {
	double ave = 0;
	for (int i : ratings) {
	    ave = ave + i;
	}
	ave = ave / ratings.size();
	return ave;
    }

    public int numRating() {
	return ratings.size();
    }

    @Override
    public int compareTo(Mreview obj) {
	return this.getTitle().compareTo(obj.getTitle());
    } 
    
    @Override
    public boolean equals(Object obj) {
	Mreview mr = (Mreview) obj;
	return this.getTitle().equals(mr.getTitle());
    }

    public String toString() {
	String text = title + ", average " + String.format("$%.2f", aveRating()) + " out of "
	    + numRating() + " ratings";
	return text;
    }

    public static void main(String[] args) {
	Mreview mr = new Mreview("Kill Bill");
	mr.addRating(3);
	mr.addRating(4);
	mr.addRating(3);
        System.out.println(mr);
        Mreview mr2 = new Mreview("Pulp fiction");
        mr2.addRating(3);
        mr2.addRating(4);
        mr2.addRating(3);
	System.out.println(mr.compareTo(mr2));
	System.out.println(mr.equals(mr2));

    }	
 }
