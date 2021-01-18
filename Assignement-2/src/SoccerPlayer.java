/**
 * Pratham Saldhi
 * CSc-20, Project-2
 * 11/1/2020
 * Prof. Abida Mukkarram
 * Creating a SoccerPlayer class that
 * extends Player and contains all the
 * methods and fields for a soccer player.
 */
public class SoccerPlayer extends Player {
	// Declaring private fields
	private int goals;
	private int fouls;
	private int redCard;
	private int yellowCard;
	private int offside;
	private int assist;
	private String teamName;
	/*
	 * A constructor that take in all the fields
	 * that are relevant with a soccer player
	 * and stores it for an object.
	 */
	public SoccerPlayer(String name, double salary, int number, int goals, int fouls, int red, int yellow, int offside,
			int assist, String team) {
		//calling Player()
		super(name, salary, number);
		this.goals = goals;
		this.fouls = fouls;
		this.redCard = red;
		this.yellowCard = yellow;
		this.offside = offside;
		this.assist = assist;
		this.teamName = team;
	}
	// Get goals
	public int getGoals() {
		return goals;
	}
	// Set goals
	public void setGoals(int goals) {
		this.goals = goals;
	}
	// Get fouls
	public int getFouls() {
		return fouls;
	}
	// Set fouls
	public void setFouls(int fouls) {
		this.fouls = fouls;
	}
	// Get red cards
	public int getRedCard() {
		return redCard;
	}
	// Set red cards
	public void setRedCard(int redCard) {
		this.redCard = redCard;
	}
	// Get yellow cards
	public int getYellowCard() {
		return yellowCard;
	}
	// Set yellow cards
	public void setYellowCard(int yellowCard) {
		this.yellowCard = yellowCard;
	}
	// Get offside
	public int getOffside() {
		return offside;
	}
	// Set offside
	public void setOffside(int offside) {
		this.offside = offside;
	}
	// Get assists
	public int getAssist() {
		return assist;
	}
	// Set assists
	public void setAssist(int assist) {
		this.assist = assist;
	}
	// Get team name
	public String getTeamName() {
		return teamName;
	}
	// Set team name
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	@Override
	// A toString method
	public String toString() {
		return "SoccerPlayer [goals=" + goals + ", fouls=" + fouls + ", redCard=" + redCard + ", yellowCard="
				+ yellowCard + ", offside=" + offside + ", assist=" + assist + ", teamName=" + teamName + "]";
	}
	/*
	 * Creating a equals method 
	 * that returns true if the passed
	 * in object o is of the type SoccerPlayer.
	 */
	public boolean equals(Object o) {
		if (o instanceof SoccerPlayer) {
			SoccerPlayer s = (SoccerPlayer) o;
			return this.goals == s.goals && this.fouls == s.fouls && this.redCard == s.redCard && this.yellowCard == s.yellowCard && this.offside == s.offside && this.assist == s.assist && this.teamName.equals(s.teamName);
		} else {
			return false;
		}

	}

	/*
	 * if the player has more than three fouls or two yellow card then
	 * the player cannot play and this method should return false
	 */
	public boolean pullOutPlayer() {
		if (fouls > 3 || yellowCard >= 2) {
			return false;
		} else {
			return true;
		}
	}
}
