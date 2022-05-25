package com.premiumminds.internship.screenlocking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.premiumminds.intership.listsAvaliable.possibleList;

/**
 * Created by aamado on 05-05-2022.
 */
class ScreenLockinPattern implements IScreenLockinPattern {
	
//	public static void main(String[] args) throws InterruptedException, ExecutionException {
//		System.out.println(countPatternsFrom(3, 2).get().intValue());
//	}

	/**
	 * Method to count patterns from firstPoint with the length
	 * @param firstPoint initial matrix position
	 * @param length the number of points used in pattern
	 * @return number of patterns
	*/
	public Future<Integer> countPatternsFrom(int firstPoint, int length) {
		ExecutorService service = Executors.newSingleThreadExecutor ();
		return service.submit(new Task(firstPoint-1, length));
	}
		
}

class Task implements Callable<Integer> {
	
	int startPoint;
	int[] alreadyUsed;
	int len;
	List<Integer> sequences; 
	List<List<Integer>> finalSequences;	
	
	public Task (int startingPoint, int length) {  //startingPoint >=0
		this.startPoint = startingPoint;
		this.alreadyUsed = new int[9];
		this.len = length;
		this.sequences = new ArrayList<Integer>();
		this.finalSequences = new ArrayList<List<Integer>>();
	}
	
	@Override
	public Integer call() throws Exception {
		solver(this.startPoint, this.alreadyUsed, this.len, this.sequences, this.finalSequences);
		//System.out.println(Arrays.toString(finalSequences.toArray()));
		return finalSequences.size();
	}
	
	public void solver(int startingPoint, int[] used, int length, List<Integer> sequence, List<List<Integer>> allSequences) {
		
		if (length > 1) {
			if(sequence.size() <= (len-length)) {
				sequence.add(startingPoint);
			} else {
				sequence.set(len-length, startingPoint);
			}
			int[] possibilities = possibleList.getAllPossibilities(startingPoint, used);
			for (int i = 0; i < possibilities.length; i++) {
				if (possibilities[i] == 1) {
					used[startingPoint] = 1;
					solver(i, used, length-1, sequence, allSequences);
					used[startingPoint] = 0;
				}
			}
		} else {
			if(sequence.size() <= (len-length)) {
				sequence.add(startingPoint);
			} else {
				sequence.set(len-length, startingPoint);
			}
			List<Integer> copy = new ArrayList<>(sequence);
			allSequences.add(copy);
			//System.out.println(sequence);
			return;
		}
		
	}
	
}
