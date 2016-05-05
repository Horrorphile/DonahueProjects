package com.donahue.engineering;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
	
	private static int top = 1000;
	private static int tries = 10;

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int guess;
		Random rand = new Random();
		int answer;
		
		answer = rand.nextInt(top);
		
		for (int i = 1;i <= tries;i++){
			
			System.out.println("ROUND " + i);
			
			guess = getNumber(scanner);
			
			if (guess == answer){
				System.out.println("That's Correct! You Win!");
				System.out.println("You got it in " + i + " guesses!");
				break;
			} else if (i == tries){
				break;
			} else if (guess < answer){
				System.out.println("That's a little low. Guess a higher number.");
			} else {
				System.out.println("That's a little high. Guess a lower number.");
			}
		}
		scanner.close();
		System.out.println("GAME OVER - The number was " + answer);
	}
	
	private static int getNumber(Scanner sc){
		int guess = 0;
		
		do{
			System.out.print("Guess a number 0 to " + top + ": ");
			try{
				guess = Integer.parseInt(sc.nextLine());
			}
			catch(NumberFormatException e){
				System.out.println("That's an invalid input.\n");
			}
		} while(guess < 0 || guess > top);
		
		return guess;
	}

}
