/**
 * Pratham Saldhi
 * CSc-20, Project-2
 * 11/1/2020
 * Prof. Abida Mukkarram
 * Creating a Driver class that 
 * that stores the two text files and 
 * passes in the constructor of 
 * BasketBallteam and SoccerTeam.
 * it contains a bunch of methods like
 * listPlayers,mostRebound,listRed etc.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.*;

public class Driver {

	public static void main(String[] args) {

		File f1 = new File("bearcatlist.txt");
		File f2 = new File("kingslist.txt");
		try {
			SoccerTeam bearCat = new SoccerTeam(f1);
			//listPlayers(bearCat.getTeam());
			//listRed(bearCat.getTeam());
			//searchPlayer(bearCat.getTeam(), "Pearce skinner");
			//winPredictor("bearcat");
			//display(bearCat.getTeam());
			BasketBallTeam kings = new BasketBallTeam(f2);
			//winPredictor("kings");
			//display(kings.getTeam());
			//searchPlayer(kings.getTeam(), "harry giles");
			//mostRebound(kings.getTeam());
			} 
		catch (FileNotFoundException e) {
			System.out.println("File not Found");

		} catch (NullPointerException e) {
			System.out.println("Null pointer Exception");
		}
	}

	/*
	 * Create a method called listPlayers, this methods accepts an arraylist of
	 * players and displays the info about all the players. Call this method two
	 * times using the object kings and bearCat. You must use the same method
	 */
	public static void listPlayers(ArrayList<? extends Player> team) {
		System.out.println("****INFO ABOUT ALL THE PLAYERS IN ARRAYLIST******");
		for (int i = 0; i < team.size(); i++) {
			if (team.get(i) instanceof SoccerPlayer) {
				SoccerPlayer sPlayer = (SoccerPlayer) team.get(i);
				System.out.println("Name: " + sPlayer.getName());
				System.out.println("Salary: " + sPlayer.getSalary());
				System.out.println("Number: " + sPlayer.getNumber());
			} else if (team.get(i) instanceof BasketBallPlayer) {

				BasketBallPlayer bPlayer = (BasketBallPlayer) team.get(i);
				System.out.println("Name: " + bPlayer.getName());
				System.out.println("Salary: " + bPlayer.getSalary());
				System.out.println("Number: " + bPlayer.getNumber());

			}

		}
	}

	/*
	 * Write a method that accepts an array of
	 * SoccerPlayer and lists all the players with red card.
	 */
	public static void listRed(ArrayList<SoccerPlayer> team) {
		System.out.println("Players with red cards: ");
		for (int i = 0; i < team.size(); i++) {
			if (team.get(i).getRedCard() > 0) {
				System.out.println("-" + team.get(i).getName());
			}
		}
	}

	/*
	 * Write a method called mostRebound that 
	 * displays the player with the most rebound
	 */
	public static void mostRebound(ArrayList<BasketBallPlayer> team) {
		System.out.print("Players with most rebounds is: ");
		int maxRebound = team.get(0).getRebound();
		String name = team.get(0).getName();
		for (int i = 0; i < team.size(); i++) {
			if (maxRebound < team.get(i).getRebound()) {
				maxRebound = team.get(i).getRebound();
				name = team.get(i).getName();
			}
		}
		System.out.print(name);
	}

	/*
	 * Write a method called searchPlayer that accepts an arraylist
	 * of type Player and a name of a player. This method searches
	 * the list, if the player is found display the info, otherwise
	 * print a message that the player does not exist.
	 */
	public static void searchPlayer(ArrayList<? extends Player> team, String name) {
		boolean isFound = false;
		for (int i = 0; i < team.size(); i++) {
			if (name.equalsIgnoreCase(team.get(i).getName())) {
				System.out.println("Name: " + team.get(i).getName());
				System.out.println("Salary: " + team.get(i).getSalary());
				System.out.println("Number: " + team.get(i).getNumber());
				isFound = true;
				break;
			}
		}
		if (!isFound) {
			System.out.println("Player does not exists.");
		}
	}

	// Write a method that display the best player with the most goals/points
	public static void display(ArrayList<? extends Player> team) {
		if (team.get(0) instanceof SoccerPlayer) {
			SoccerPlayer sPlayer = (SoccerPlayer) team.get(0);
			int max = sPlayer.getGoals();
			String bestPlayer = sPlayer.getName();
			for (int j = 1; j < team.size(); j++) {
				if (team.get(j) instanceof SoccerPlayer) {
					SoccerPlayer s = (SoccerPlayer) team.get(j);
					if (max < s.getGoals()) {
						max = s.getGoals();
						bestPlayer = s.getName();
					}
				}
			}
			System.out.println(bestPlayer);
		} else if (team.get(0) instanceof BasketBallPlayer) {
			BasketBallPlayer bPlayer = (BasketBallPlayer) team.get(0);
			int max = bPlayer.getTotalPoints();
			String bestPlayer = bPlayer.getName();
			for (int j = 1; j < team.size(); j++) {
				if (team.get(j) instanceof BasketBallPlayer) {
					BasketBallPlayer b = (BasketBallPlayer) team.get(j);
					if (max < b.getTotalPoints()) {
						max = b.getTotalPoints();
						bestPlayer = b.getName();
					}
				}
			}
			System.out.println(bestPlayer);
		}

	}

	/*
	 * Write a method that takes the team name as parameter and simulates series of 10 games 
	 * and each game is a random play. For each game, you need to generate a random number, if the random number 
	 * is bigger than 0.5.its a win; otherwise the team loses a game. This method prints the number of wins 
	 * and losses of each team. Call this method twice, once by passing in “Bear Cat” as team name and other 
	 * for passing in “Kings” as the team name from the main method.
	 */
	public static void winPredictor(String name) {
		Random rand = new Random();
		int losses = 0;
		int wins = 0;
		if (name.equalsIgnoreCase("bearcat") || name.equalsIgnoreCase("kings")) {
			// 0 - 1 : double o = rand.nextDouble();
			for (int i = 1; i <= 10; i++) {
				double chance = rand.nextDouble();
				if (chance > 0.5) {
					// win
					wins++;
				} else {
					// loss
					losses++;
				}
			}
			System.out.println("Wins: " + wins + " Losses: " + losses);
		} else {
			System.out.println("No such team exists.");
		}

	}
}
