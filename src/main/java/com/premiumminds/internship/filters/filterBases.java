package com.premiumminds.internship.filters;

public interface filterBases {
	/**
	 * It receives an array and verifies if any of those elements (index) is already used defined by a 1 in the second array
	 * Complexity: O(n/2)
	 * 
	 * @param newList The array to be verified it has 1 in the elements available to use
	 * @param usedElems The array with the elements defined if used or not it has 1 in the elements already used
	 * @return An array filtered by the used elements, meaning it has those index at 1 in the second array
	 */
	public int[] filterUsed (int position, int[] newList, int[] usedElems);
	
	
	
}
