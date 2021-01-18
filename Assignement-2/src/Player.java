/**
 * Pratham Saldhi
 * CSc-20, project-2
 * 11/1/2020
 * Prof. Abida Mukkarram
 * Creating a Player class that
 * contains some basic fields and methods
 * that any type of player would posses
 * irrespective of his sport.
 */
public class Player {
	// Declaring the fields as private
	private String name;
	private double salary;
	private int number;
	
	/*
	 * A constructor that takes in
	 * name, salary, and number
	 */
	public Player(String name,double salary,int number){
		this.name = name;
		this.salary = salary;
		this.number = number;
	}
	// Get name
	public String getName() {
		return name;
	}
	// Set name
	public void setName(String name) {
		this.name = name;
	}
	// Get salary
	public double getSalary() {
		return salary;
	}
	// Set salary
	public void setSalary(double salary) {
		this.salary = salary;
	}
	// Get number
	public int getNumber() {
		return number;
	}
	// Set number
	public void setNumber(int number) {
		this.number = number;
	}
	// Creating a toString method
	@Override
	public String toString() {
		return "Player [name=" + name + ", salary=" + salary + ", number=" + number + "]";
	}
	/*
	 * Creating a equals method 
	 * that returns true if the passed
	 * in object o is of the type Player.
	 */
	public boolean equals(Object o) {
		if(o instanceof Player) {
			Player other = (Player) o;
			return true;
		}else {
			return false;
		}
	
	}
}
