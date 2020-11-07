public class Course {
    
    private String name;
    private int numberOfStudent;
    private Student[] students;
    final private int maxStudent = 10;
    
    Course(String name) {
	this.name = name;
	students = new Student[maxStudent];
	numberOfStudent = 0;
    }
    
    public void registerStudent(Student stu) {
	//if (isFull()) {
	//    throw new Exception("Student is full");
	//}
	students[numberOfStudent] = stu;
	numberOfStudent++;
    }

    public Student[] getStudents() {
	return students;
    }
    
    public boolean isFull() {
	return numberOfStudent == maxStudent;
    }

}
    
    