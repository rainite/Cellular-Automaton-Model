package edu.neu.csye6200.ca;

import java.awt.Color;
import java.util.ArrayList;

public class CAGeneration {

	private ArrayList<CACell> CellList = new ArrayList<CACell>();


	public CAGeneration(int cellNum) 
	{
		double a[] = {0,0,0};
		double b[] = {255,255,255};

		CACell temp = new CACell();
		temp.setCell(b);
		
		for (int i = 0; i < cellNum; i++) {
			CACell cell = new CACell();
			cell.setCell(a);
			CellList.add(cell);
		}
		CellList.set(cellNum / 2, temp);
	}

	public void setCelllist(int index, CACell cell) 
	{
		CellList.set(index, cell);
	}


	public void AddCell(CACell cell)
	{
		CellList.add(cell);
	}

	public CACell getCellList(int index) 
	{
		return CellList.get(index);
	}

	public ArrayList<CACell> getCellList() 
	{
		return CellList;
	}

}
