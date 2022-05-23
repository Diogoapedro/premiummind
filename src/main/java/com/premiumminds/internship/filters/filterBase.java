package com.premiumminds.internship.filters;

import com.premiumminds.intership.listsAvaliable.possibleList;

public class filterBase implements filterBases{

	@Override
	public int[] filterUsed(int position, int[] newList, int[] usedElems) {  //position [0,8]
		for (int i = 0; i < newList.length; i++) {
			if (usedElems[i] == 1) {
				int maybe = possibleList.getBlocked(position, i, usedElems);
				if (maybe != 10) {
					newList[maybe] = 1;
				}
				newList[i] = 0;
			}
		}
		
		return newList;
	}

}
