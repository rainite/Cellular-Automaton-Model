package edu.neu.csye6200.ca;

public class CACell {

	
	private double colorCell[] ={0,0,0} ;
	private double bwCell = 255;
	public CACell(){
		
		
	}

	public void setCell(double color[]) {
		for (int i = 0; i < color.length; i++) {
			this.colorCell[i] = color[i];
		}
	}
	
	public double[] getCell() {
		
		return colorCell;
		
	}
	
	public void setCell(double bwCell) {
		
		this.bwCell = bwCell;
	}
	
	public double getbwCell() {
		
		return bwCell;
		
	}

}