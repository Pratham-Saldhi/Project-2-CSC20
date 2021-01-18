/**
 * Pratham Saldhi CSc-20, Project-2 11/1/2020 Prof. Abida Mukkarram Creating a
 * BasketBallPlayer class that extends Player and contains all the methods and
 * fields for a basketball player.
 */
public class BasketBallPlayer extends Player{
	// Declaring private fields
	private int threePointer;
	private int turnover;
	private int assist;
	private int rebound;
	private int twoPointer;
	private String teamName;

	/*
	 * A constructor that take in all the fields 
	 * that are relevant with a basketball
	 * player and stores it for an object.
	 */
	public BasketBallPlayer(String name, double salary, int number, int three, int turnover, int assist, int rebound,
			int two, String teamName) {
		//Calling Player()
		super(name, salary, number);
		this.threePointer = three;
		this.turnover = turnover;
		this.assist = assist;
		this.rebound = rebound;
		this.twoPointer = two;
		this.teamName = teamName;
	}
	/*
	 * Creating a equals method 
	 * that returns true if the passed
	 * in object o is of the type BasketBallPlayer.
	 */
	public boolean equals(Object o) {
		if (o instanceof BasketBallPlayer) {
			BasketBallPlayer b = (BasketBallPlayer) o;
			return this.threePointer == b.threePointer && this.turnover == b.turnover && this.assist == b.assist && this.rebound == b.rebound && this.twoPointer == b.twoPointer && this.teamName.equals(b.teamName);
		} else {
			return false;
		}

	}

	/*
	 * Returns the total points made by the player.
	 * The getTotalPoints method can be used
	 * on the object of type BasketBallPlayer
	 */
	public int getTotalPoints() {
		return 3 * threePointer + 2 * twoPointer;
	}

	@Override
	// Creating a toString method
	public String toString() {
		return "BasketBallPlayer [threePointer=" + threePointer + ", turnover=" + turnover + ", assist=" + assist
				+ ", rebound=" + rebound + ", twoPointer=" + twoPointer + ", team=" + teamName + "]";
	}
	// Get three pointers
	public int getThreePointer() {
		return threePointer;
	}
	// Set threepointers
	public void setThreePointer(int threePointer) {
		this.threePointer = threePointer;
	}
	// Get turnovers
	public int getTurnover() {
		return turnover;
	}
	// Set turnovers 
	public void setTurnover(int turnover) {
		this.turnover = turnover;
	}
	// Get assists
	public int getAssist() {
		return assist;
	}
	// Set assists
	public void setAssist(int assist) {
		this.assist = assist;
	}
	// Get rebound
	public int getRebound() {
		return rebound;
	}
	// Set rebound
	public void setRebound(int rebound) {
		this.rebound = rebound;
	}
	// Get two pointers
	public int getTwoPointer() {
		return twoPointer;
	}
	// Set two pointers
	public void setTwoPointer(int twoPointer) {
		this.twoPointer = twoPointer;
	}
	// Get team name
	public String getTeamName() {
		return teamName;
	}
	// Set team name
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

}
