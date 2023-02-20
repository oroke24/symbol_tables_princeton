/* 
 * Employee.java 
 * By: Jamie O'Roke
 *
 * Employee is holds the data that represents an employee at GRH
*/
import java.io.*;

public class Employee implements Comparable<Employee>{
	//stored members
	private int id;
	private String dob;
	private String hire_date;
	private String first;
	private String last;
	private String gender;

	//constructor
	Employee(String that_id, String that_dob, String that_hire_date, 
		 String that_first, String that_last, String that_gender){

		id = Integer.parseInt(that_id.trim());
		dob = that_dob.trim();
		hire_date = that_hire_date.trim();
		first = that_first.trim();
		last = that_last.trim();
		gender = that_gender.trim();
	}
	//equals compares current employee object to one that is passed in.
	//Known as a "member function" 
	public boolean equals(Employee that){
		if(id != that.id) return false;
		if(dob != that.dob) return false;
		if(hire_date != that.hire_date) return false;
		if(first != that.first) return false;
		if(last != that.last) return false;
		if(gender != that.gender) return false;
		return true;
	}
	public int get_id(){
		return id;
	}
	//overriding comparable to sort based on Employee.id
	@Override
	public int compareTo(Employee that){
		if(id > that.id) return 1;
		else if(id < that.id) return -1;
		else return 0;
	}
	//overriding the toString method to return the contents of an Employee
	@Override
	public String toString(){
		return "id: " + id + 
			", DOB: " + dob + 
			", First:" + first + 
			", Last:" + last + 
			", Gender:" + gender + 
			", Hire date:" + hire_date;
	}
}
