/**
 * Pratham Saldhi
 * CSc-20, Project-2
 * 11/1/2020
 * Prof. Abida Mukkarram
 * Creating a BasketBallTeam class that reads the
 * data from a file and constructs an object of 
 * type BasketBallPlayer and adds it into the list.
 * It contains methods like add, getTeam,selectTheBest,
 * selectMostRebounds, equals etc.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BasketBallTeam {
	// Private field
private ArrayList<BasketBallPlayer> team = new ArrayList<BasketBallPlayer>();
	
	/*
	 * Reads the info for the players from a file and 
	 * creates an object of SoccerPlayer and then stores 
	 * it in the  arrayList called team.
	 * @throws FileNotFoundException 
	 */
	public BasketBallTeam(File f) throws FileNotFoundException {
		Scanner input = new Scanner(f);
		while (input.hasNextLine()) {
			String line = input.nextLine();
			Scanner in = new Scanner(line);
			// Taking first two strings in name
			String name = in.next();
			name += " "+in.next();
			// Salary
			double salary = in.nextDouble();
			// Number
			int number = in.nextInt();
			// 3 pointer
			int three = in.nextInt();
			// Turnover
			int turnOver = in.nextInt();
			// assist
			int assist = in.nextInt();
			// rebound
			int rebound = in.nextInt();
			// 2 pointer
			int two = in.nextInt();
			// team name
			String teamName = in.next();
			BasketBallPlayer teamMate2 = new BasketBallPlayer(name, salary, number,three,turnOver,assist,rebound,two,teamName);
			team.add(teamMate2);

		}
	}
	//Add object
	public void add(BasketBallPlayer s) {
		team.add(s);
	}
	//Add object at given position
	public void add(Object o , int pos) {
		if(o instanceof SoccerPlayer) {
			BasketBallPlayer other = (BasketBallPlayer)o;
			team.add(pos, other);
			}
	}
	//Returns the object team of ArrayList type
	public ArrayList<BasketBallPlayer> getTeam() {
		return team;
	}
	/*
	 * Return the player with the most number of points
	 */
	public String selectTheBest() {
		int max = team.get(0).getTotalPoints();
		String name = team.get(0).getName();
		for(int i = 1 ; i < team.size();i++) {
			if(max < team.get(i).getTotalPoints()) {
				max = team.get(i).getTotalPoints();
				name = team.get(i).getName();
			}
		}
		return name;
	}
	
	
	/*
	 * Returns the player with the most fouls or turnOvers
	 */
	public String selectMostTurnOver() {
		int maxTurnOver = team.get(0).getTurnover();
		String playerOut = team.get(0).getName();
		for (int i = 1; i < team.size(); i++) {
			if (maxTurnOver < team.get(i).getTurnover()) {
				maxTurnOver = team.get(i).getTurnover();
				playerOut = team.get(i).getName();
			}
		}
		return playerOut;
	}
	
	/*
	 * Returns a string representing all the players 
	 * in the team. A for loop is needed
	 */
	public String toString() {
		String teamMembers =  team.get(0).getName();
		for (int i = 1; i < team.size(); i++) {
			teamMembers += team.get(i).getName() + ", ";
		}
		return "[ " + teamMembers + " ]";
	}
	/*
	 * Returns true if the team this is the same
	 * as the team other. Need a loop to compare 
	 * all the players. 
	 */
	public boolean equals(Object o) {
		if (o instanceof BasketBallTeam) {
			boolean isEqual = false;
			int counter = 0;
			BasketBallTeam other = (BasketBallTeam) o;
			if (other.getTeam().size() == team.size()) {
				for (int i = 0; i < team.size(); i++) {
					if (team.get(i).getName().equalsIgnoreCase(other.getTeam().get(i).getName())) {
						counter++;
					}
				}
				if (counter == team.size()) {
					isEqual = true;
				}
			}
			return isEqual;
		} else {
			return false;
		}
	}
	//Removes the object(Player) from the list
	public void remove(Object o) {
		if(o instanceof BasketBallPlayer) {
			BasketBallPlayer other = (BasketBallPlayer) o;
			team.remove(other);
		}
	}
	//Removes the object(player at the given index
	public void remove(int index) {
		team.remove(index);
	}
	
}
