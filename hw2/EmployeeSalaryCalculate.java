/**
 * The deadline of this assignment is 09/25/2020 23:59 PST.
 * Please feel free to contact Yafei and Yaqi for any questions.
 */

class Employee {
    String name;
    int age;
    Gender gender;
    double salary;// salary per month

    // Constructor. Please set all the data in constructor.
    public Employee(String name, int age, Gender gender, double salary) {
        //write your code here
	this.name = name;
	this.age = age;
	this.gender = gender;
	this.salary = salary;
    }

    // Getter for `name`. Return the current `name` data
    public String getName() {
        //write your code here
	return name;
    }

    // Setter for `name`. Set `name` data
    public void setName(String name) {
        //write your code here
	this.name = name;
    }
}

enum Gender {
    MALE, FEMALE;
}

public class EmployeeSalaryCalculate {
    // Assignment

    /**
     * Write a method to calculate the Social Security Tax of an employee and print it.
     * If the salary is less than or equal to 8900, the Social Security Tax is 6.2% of the salary.
     * If the salary is more than 8900, the Social Security Tax is 6.2% of 106,800.
     */
    public double socialSecurityTax(Employee employee) {
        //write your code here
	double tax;
	if (employee.salary <= 8900) {
	    tax = employee.salary * 0.062;
	} else {
	    tax = 106900 * 0.062;
	}
	System.out.println(employee.getName() + "'s tax is " + tax);
	return tax;
    }

    /**
     * Write a method to calculate an employee's contribution for insurance coverage and print it.
     * Amount of deduction is computed as follows:
     * If the employee is under 35, rate is 3% of salary; if the employee is between 35 and 50(inclusive), rate is 4% of salary;
     * If the employee is between 50 and 60(exclusive), rate is 5% of salary; If the employee is above 60, rate is 6% of salary.
     */
    public double insuranceCoverage(Employee employee) {
        //write your code here
	double insurance;
	if (employee.age < 35) {
	    insurance = 0.03 * employee.salary;
	} else if(employee.age <=50) {
	    insurance = 0.04 * employee.salary;
	} else if (employee.age <=60) {
	    insurance =0.05 * employee.salary;
	} else {
	    insurance =0.06 * employee.salary;
	}
        System.out.println(employee.getName() + "'s insurance is " + insurance);
	return insurance;
    }

    /**
     * Write a method to sort three employees' salary from low to high, and then print their name in order.
     * For example, Alice's salary is 1000, John's salary is 500, Jenny's salary is 1200, you should print:
     * John Alice Jenny
     */
    public void sortSalary(Employee e1, Employee e2, Employee e3) {
        //write your code here
	Employee temp1, temp2, temp3;
	if (e1.salary >= e2.salary) {
	    temp2 = e1;
	    temp1 = e2;
	} else {
	    temp1 = e1;
	    temp2 = e2;
	}

	if (temp2.salary >= e3.salary) {
	    temp3 = temp2;
	    if (temp1.salary >= e3.salary) {
		temp2 = temp1;
		temp1 = e3;
	    } else {
		temp2 = e3;
	    }
       	} else {
	    temp3 = e3;
	}

	System.out.println(temp1.name + " " + temp2.name + " " + temp3.name);
    }

    /**
     * Write a method to raise an employee's salary to three times of his/her original salary.
     * Eg: original salary was 1000/month. After using this method, the salary is 3000/month.
     * Do not change the input of this method.
     * Try to add a new method in Employee class: public void raiseSalary(double byPercent)
     */
    public void tripleSalary(Employee employee) {
        //write your code here
	employee.salary *= 3.0;
    }

    public void raiseSalary(Employee employee) {
        //write your code here                                                                                                                                           
	employee.salary *= 2.0;
    } 

    //Extra credit

    /**
     * I have written some code below. What I want is to swap two Employee objects.
     * One is Jenny and one is John. But after running it, I got the result below:
     * Before: a=Jenny
     * Before: b=John
     * After: a=Jenny
     * After: b=John
     * There is no change after swap()! Do you know the reason why my swap failed?
     * Write your understanding of the reason and explain it.
     */
    /*
     write your understanding here.
     In the scope of swap function, x and y are local copies of x and y in main function.
     So even they are swapped, it won't affect the result in main funciton.
    */
    public static void main(String[] args) {
        Employee a = new Employee("Jenny", 20, Gender.FEMALE, 2000);
        Employee b = new Employee("John", 30, Gender.MALE, 2500);
        System.out.println("Before: a=" + a.getName());
        System.out.println("Before: b=" + b.getName());
        swap(a, b);
        System.out.println("After: a=" + a.getName());
        System.out.println("After: b=" + b.getName());

	Employee c = new Employee("Vesa", 50, Gender.FEMALE, 4000);
	EmployeeSalaryCalculate calc = new EmployeeSalaryCalculate();
	double tax = calc.socialSecurityTax(c);
	double insurance = calc.insuranceCoverage(c);
	System.out.println("before " + c.getName() + "'s salary is " + c.salary);
	calc.tripleSalary(c);
	System.out.println("after triple " + c.getName() + "'s salary is " + c.salary);
	c.salary = 4000;
	calc.raiseSalary(c);
	System.out.println("after raise " +c.getName() + "'s salary is " + c.salary);

	calc.sortSalary(c,b,a);
	calc.sortSalary(c,a,b);
	calc.sortSalary(a,c,b);
    }

    public static void swap(Employee x, Employee y) {
        Employee temp = x;
        x = y;
        y = temp;
    }
}