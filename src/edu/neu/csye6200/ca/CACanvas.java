package edu.neu.csye6200.ca;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;

public class CACanvas extends JPanel {

	private HashMap<Integer, ArrayList<CACell>> cellSet = new HashMap<Integer, ArrayList<CACell>>();
	private ArrayList<CACell> cell = new ArrayList<CACell>();
	private int time = -1;

	public void setTime(int time) {
		this.time = time;
	}

	
	public void setCellSet(HashMap<Integer, ArrayList<CACell>> cellSetTemp) {
		for (int i = 0; i < cellSetTemp.size(); i++) {
			for (int j = 0; j < cellSetTemp.get(i).size(); j++) {
				this.cellSet.put(i, cellSetTemp.get(i));
			}
		}
	}
	
	
	public void paint(Graphics g) {
		super.paint(g);
		for (int i = 0; i < time + 1; i++) {
			cell = cellSet.get(i);

			for (int j = 0; j < cell.size(); j++) {
				if ((int) cell.get(j).getCell()[0] == 0 && (int) cell.get(j).getCell()[1] == 0
						&& (int) cell.get(j).getCell()[2] == 0) {
					g.setColor(Color.gray);
					g.fillRect(j * 20, i * 20, 18, 18);
				} else {
					g.setColor(new Color((int) cell.get(j).getCell()[0], (int) cell.get(j).getCell()[1],
							(int) cell.get(j).getCell()[2]));
					g.fillRect(j * 20, i * 20, 18, 18);
				}
			}
		}
	}
	@Override
	  public Dimension getPreferredSize() {
	    return new Dimension(1270, 1270);
	  }

	
}
