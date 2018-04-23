/**************************************************
* This class is the Employee class
* This class will consist of the Employee scheme info
*
* 
*
*  By Matthew Serna
*
***************************************************/

import java.util.*;

public class Employee {

	private String name;
	private int employeeID; //Unique ID that will correspond to employee using Hashmap
	private String department;
	private int wages;
	private List<Employee> subordinates; //Who does the employee report to

	//Constructor
	public Employee(String name, int employeeID, String department, int wages) {
		this.name = name;
		this.employeeID = employeeID;
		this.wages = wages;
		this.department = department;
		subordinates = new ArrayList<Employee>();
	}

	public boolean isActive (Employee employee) {
		if (employee.employeeID != null) {
			return true;
		} else {
			return false;
		}
	}

	public List<Employee> getSubordinates() {
		return subordinates;
	}

	public String toString() {
		return "Employee: ( Name: " + name +
				", Employee ID: " + employeeID +
				", Wages: " + wages +
				", Department: " + department + " )";
	}

}