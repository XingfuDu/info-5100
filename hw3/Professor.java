public class Professor {
    private String firstName;
    private String lastName;
    private int id;
    
    public static class Builder {
	private String firstName;
	private String lastName;
	private int id;
	
	public Builder(String firstName, String lastName) {
	    this.firstName = firstName;
            this.lastName = lastName;
       	}
	
	public Builder setId(int id) {
            this.id = id;
            return this;
        }
	
        public Professor build() {
            // call the private constructor in the outer class
            return new Professor(firstName, lastName, id);
        }
    }
	
    public Professor(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public String getFirstName() {
	return firstName;
    }
    public String getLastName() {
	return lastName;
    }

    public int getId() {
	return id;
    }

    public static void main(String[] args) {
        Professor p = new Professor.Builder("Emma", "Wang")
	    .setId(15443).build();
	System.out.println("Professor " + p.getFirstName() + " " + p.getLastName() + "'s id is " + p.getId()); 

    }
	
}