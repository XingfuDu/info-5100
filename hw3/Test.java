public class Test {
    
    public static void main(String[] args) {
	Student[] students = new Student[10];
	students[0] = new Student("alice",1);
	students[1] = new Student("bob",2);
	students[2] = new Student("tom",3);
	students[3] = new Student("lucy",4);
	students[4] = new Student("vesa",5);
        students[5] = new Student("terry",6);
        students[6] = new Student("linsey",7);
        students[7] = new Student("frank",8);
        students[8] = new Student("choplin",9);
        students[9] = new Student("george",10);
	for(Student s: students) {  
	    System.out.println(s.getName() + "'s id is " + s.getId());
	}

	students[0].setName("lucas");
	students[0].setId(11);
	System.out.println("\n" + students[0].getName() + "'s id is " + students[0].getId());

	Course c = new Course("info5100");
	for(Student s: students) {
	    c.registerStudent(s);
	}
	System.out.println("\nStudents registered info5100 are: ");
	Student[] result = c.getStudents();
	for(Student s: result) {
	    System.out.println(s.getName() + "'s id is " + s.getId());
        }
	if(c.isFull()) {
	    System.out.println("\ninfo5100 is full");
	}
    }
}