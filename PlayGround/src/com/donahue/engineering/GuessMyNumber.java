package com.donahue.engineering;

import java.util.Scanner;

public class GuessMyNumber {
	
	private static int tries = 10;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int max = 1000;
		int min = 1;
		int guess = 0;
		
		String hasNumber;
		String correct;
		
		System.out.println("Pick a number between 1 and 1000");
		System.out.println("Do you have a number? [y or n]");
		
		hasNumber = sc.nextLine();
		
		if(hasNumber.equals("y")){
			
			for (int i = 1; i <= tries; i++){
				
				guess = getGuess(min,max);
				
				System.out.println("Guess " + i);
				System.out.println("Is your number " + guess + " ? [y, h, l]");
				
				correct = sc.nextLine();
				
				if(correct.equals("y")){
					System.out.println("You lose I guessed your number in " + i + " tries");
					System.out.println("Game Over");
					break;
				} else if(correct.equals("h")){
					min = guess;
				} else if(correct.equals("l")){
					max = guess;
				}
				
				if(i == tries){
					System.out.println("You win. I didn't guess your number");
					break;
				}
			}
			
		} else {
			System.out.println("Play again when you have a number");
		}
		
		
		sc.close();
	}
	
	private static int getGuess(int min, int max){
		return min + (max - min) / 2;
	}

}
