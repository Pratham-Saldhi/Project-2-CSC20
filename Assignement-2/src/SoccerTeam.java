/**
 * Pratham Saldhi
 * CSc-20, Project-2
 * 11/1/2020
 * Prof. Abida Mukkarram
 * Creating a SoccerTeam class that reads the
 * data from a file and constructs an object of 
 * type SoccerPlayer and adds it into the list.
 * It contains methods like add, getTeam,selectTheBest,
 * selectTheMostRed, equals etc.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SoccerTeam {
	//Private field
	private ArrayList<SoccerPlayer> team = new ArrayList<SoccerPlayer>();

	/**
	 * Reads the info for the players from a file and creates an object of
	 * SoccerPlayer and then stores it in the arrayList called team.
	 * 
	 * @throws FileNotFoundException
	 */
	public SoccerTeam(File f1) throws FileNotFoundException {
		Scanner input = new Scanner(f1);
		while (input.hasNextLine()) {
			String line = input.nextLine();
			Scanner in = new Scanner(line);
			// Taking first two strings in name
			String name = in.next();
			name += " "+in.next();
			// Salary
			double salary = (double) in.nextInt();
			// Number
			int number = in.nextInt();
			// Goals
			int goals = in.nextInt();
			// Fouls
			int fouls = in.nextInt();
			// red
			int red = in.nextInt();
			// yellow
			int yellow = in.nextInt();
			// offside
			int offSide = in.nextInt();
			// assist
			int assist = in.nextInt();
			// team
			String teamName = in.next();
			SoccerPlayer teamMate = new SoccerPlayer(name, salary, number, goals, fouls, red, yellow, offSide, assist,
					teamName);
			team.add(teamMate);

		}
	}

	// Add object
	public void add(SoccerPlayer s) {
		team.add(s);
	}

	// Add object at given position
	public void add(Object o, int pos) {
		if(o instanceof SoccerPlayer) {
		SoccerPlayer other = (SoccerPlayer)o;
		team.add(pos, other);
		}
	}

	//returns the object team of arraylist type
	public ArrayList<SoccerPlayer> getTeam() {
		return team;
	}

	/*
	 * Return the player with the most goals
	 */
	public String selectTheBest() {
		int max = team.get(0).getGoals();
		String bestPlayer = team.get(0).getName();
		for (int i = 1; i < team.size(); i++) {
			if (max < team.get(i).getGoals()) {
				max = team.get(i).getGoals();
				bestPlayer = team.get(i).getName();
			}
		}
		return bestPlayer;
	}

	/*
	 * Returns the player with the most red card
	 */
	public String selectMostRed() {
		int maxRed = team.get(0).getRedCard();
		String playerOut = team.get(0).getName();
		for (int i = 1; i < team.size(); i++) {
			if (maxRed < team.get(i).getRedCard()) {
				maxRed = team.get(i).getRedCard();
				playerOut = team.get(i).getName();
			}
		}
		return playerOut;
	}

	/*
	 * Returns a string representing all the
	 * players in the team. A for loop is needed
	 */
	public String toString() {
		String teamMembers =  team.get(0).getName();
		for (int i = 1; i < team.size(); i++) {
			teamMembers += ", " + team.get(i).getName();
		}
		return "[" + teamMembers + "]";
	}

	/*
	 * Returns true if the team this is the same
	 * as the team other. Need a loop to compare
	 *  all the players.
	 */
	public boolean equals(Object o) {
		if (o instanceof SoccerTeam) {
			boolean isEqual = false;
			int counter = 0;
			SoccerTeam other = (SoccerTeam) o;
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

	// Removes the object(Player) from the list
	public void remove(Object o) {
		if(o instanceof SoccerPlayer) {
			SoccerPlayer other = (SoccerPlayer) o;
			team.remove(other);
		}
	}

	// Removes the object(player at the given index)
	public void remove(int index) {
		team.remove(index);
	}

}
