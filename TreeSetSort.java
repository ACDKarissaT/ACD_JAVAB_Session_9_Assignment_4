package assignment4;

import java.util.Comparator;
import java.util.TreeSet;

class Employee implements Comparable<Employee>{
	String name;
	String designation;
	double salary;
	public Employee (String name, String designation, double salary) {
		this.name = name;
		this.designation = designation;
		this.salary = salary;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o != null && o instanceof Employee) {
			Employee emp = (Employee) o;
			return (this.name.equals(emp.name) && this.designation.equals(emp.designation)
					&& this.salary == emp.salary);
		}
		return false;
	}
	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		if (o != null) {
			if (this.salary == o.salary) {
				if (this.name.equals(o.name)) {
					return this.designation.compareToIgnoreCase(o.designation);
				} else {
					return this.name.compareToIgnoreCase(o.name);
				}
			} else {
				return (this.salary < o.salary)? -1 : 1;
			}
		} 
		return 0;
	}
	
	@Override
	public String toString() {
		return "[" + name + ", " + designation + ", " + salary + "]";
	}
		
}

class SortByName implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		if (o1.name.equals(o2.name)) {
			if (o1.designation.equals(o2.designation)) {
				return Double.compare(o1.salary, o2.salary);
			} else {
				return o1.designation.compareToIgnoreCase(o2.designation);
			}
		} else {
			return o1.name.compareToIgnoreCase(o2.name);
		}
	}
	
}

public class TreeSetSort {
	public static void main(String[] args) {
		TreeSet<Employee> ts = new TreeSet<Employee>();
		TreeSet<Employee> byName = new TreeSet<Employee>(new SortByName());
		ts.add(new Employee("Joe", "CEO", 1000000));
		ts.add(new Employee("Joe", "Associate", 40000));
		ts.add(new Employee("Bob", "Manager", 60000));
		ts.add(new Employee("Kat", "Senior Developer", 100000));
		ts.add(new Employee("Tony", "Junior Developer", 50000));
		
		byName.add(new Employee("Joe", "CEO", 1000000));
		byName.add(new Employee("Joe", "Associate", 40000));
		byName.add(new Employee("Bob", "Manager", 60000));
		byName.add(new Employee("Kat", "Senior Developer", 100000));
		byName.add(new Employee("Tony", "Junior Developer", 50000));
		
		System.out.println("Natural sorted order by salary:");
		for (Employee employee : ts) {
			System.out.println(employee);
		}
		
		System.out.println();
		System.out.println("Sorted by name:");
		for (Employee employee : byName) {
			System.out.println(employee);
		}
		
		
	}
}
