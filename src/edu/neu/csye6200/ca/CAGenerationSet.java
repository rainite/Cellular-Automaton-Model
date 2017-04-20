package edu.neu.csye6200.ca;

import java.util.ArrayList;
import java.util.HashMap;

public class CAGenerationSet {

	public static HashMap<Integer, ArrayList<CACell>> Generation(int time, int cellsNum, int num) {
		
		HashMap<Integer, ArrayList<CACell>> cellSet = new HashMap<Integer, ArrayList<CACell>>();
		CAGeneration gen = new CAGeneration(cellsNum);
		CARules rule = new CARules(num);
		ArrayList<CACell> cells = null;
		CACell temp = null;

		for (int j = 0; j < time; j++) {
			cells = new ArrayList<CACell>();
			for (int i = 0; i < cellsNum; i++) {
				if (j == 0) {
					cells.add(gen.getCellList(i));
				} else {
					gen.setCelllist(i, rule.getGeneration(cellSet.get(j-1).get((cellsNum + i - 1) % cellsNum),
									cellSet.get(j-1).get(i),
									cellSet.get(j-1).get((i + 1) % cellsNum)));
					temp = new CACell();
					temp.setCell(gen.getCellList(i).getCell());
					cells.add(temp);
				}
			}
			cellSet.put(j, cells);
		}

		return cellSet;
	}
}
