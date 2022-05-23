package com.premiumminds.intership.listsAvaliable;

import java.util.Arrays;

public class possibleList implements possibleLists {

	@Override
	public int[] getAllPossibilities (int startingPoint) { //startingPoint >= 0
		
		int[] possibilities = new int[10];
		
		if(startingPoint == 4) {
			
			Arrays.fill(possibilities, 1);
			possibilities[4] = 0;
			
		} else if ((startingPoint % 2) == 0) {
			
			for(int i = 0; i < possibilities.length; i+=2) {
				possibilities[i] = 1;
			}
			
		} else {
			
			for(int i = 1; i < possibilities.length; i+=2) {
				possibilities[i] = 1;
			}
		}
		
		return possibilities;
	}

	public static int getBlocked (int position, int next, int[] usedElem) {
		
		int i = 10;
		
		if ((position % 2) == 0) {
			
			i = pairBlocked(position, next);
			
			if(i == 10 || usedElem[i] == 1);
				i = 10; //já foi usado então coloco valor não esperado
			
		} else if (position != 5) {
			
			i = oddBlocked(position, next);
			
			if(i == 10 || usedElem[i] == 1);
				i = 10; //já foi usado então coloco valor não esperado
			
		}		
		
		return i;
	}

	private static int oddBlocked (int position, int next) {
		
		int i = 10;
		
		if (next == 4) {
			if (position == 1)
				i = 7;
			else if (position == 3)
				i = 5;
			else if (position == 5)
				i = 3;
			else {
				i = 1;
			}
			
		}
		
		return i;
	}

	private static int pairBlocked (int position, int next) {
		
		int i = 10;
		
		if (position == 0) {
			if (next == 1) 
				i = 2;
			else if (next == 3)
				i = 6;
			else if (next == 4)
				i = 8;
		} else if (position == 2) {
			if (next == 1) 
				i = 0;
			else if (next == 4)
				i = 6;
			else if (next == 5)
				i = 8;
		} else if (position == 6) {
			if (next == 3) 
				i = 0;
			else if (next == 4)
				i = 2;
			else if (next == 7)
				i = 8;
		} else if (position == 8) {
			if (next == 4) 
				i = 0;
			else if (next == 5)
				i = 2;
			else if (next == 7)
				i = 6;
		}
		
		return i;
	}

}
