package edu.neu.csye6200.ca;

import java.awt.Color;
import java.util.Random;

public class CARules {

	private int ruleNum = 0;
	Random rand = new Random();
	int randNum = rand.nextInt(255);

	public CARules(int num) {
		this.ruleNum = num;
	}

	public CACell getGeneration(CACell cell1, CACell cell2, CACell cell3) {
		double[] cell = new double[3];
		CACell newCell = new CACell();
		Color col = null;

		Color c1 = new Color((int) cell1.getCell()[0], (int) cell1.getCell()[1], (int) cell1.getCell()[2]);
		Color c2 = new Color((int) cell2.getCell()[0], (int) cell2.getCell()[1], (int) cell2.getCell()[2]);
		Color c3 = new Color((int) cell3.getCell()[0], (int) cell3.getCell()[1], (int) cell3.getCell()[2]);
		Color oriBlack = new Color(0,0,0);
		Color oriWhite = new Color(255,255,255);
		if (this.ruleNum == 1) {

			if (c1.equals(oriBlack) && c2.equals(oriBlack) && c3.equals(oriBlack)){
				cell[0] = 0;
				cell[1] = 0;
				cell[2] = 0;
				newCell.setCell(cell);
			}
			if (c1.equals(oriBlack) && c2.equals(oriBlack) && c3.equals(oriWhite)){
				cell[0] = 255;
				cell[1] = 255;
				cell[2] = 255;
				newCell.setCell(cell);
			}
			if (c1.equals(oriBlack) && c2.equals(oriWhite) && c3.equals(oriBlack)){
				cell[0] = 0;
				cell[1] = 0;
				cell[2] = 0;
				newCell.setCell(cell);
			}
			if (c1.equals(oriBlack) && c2.equals(oriWhite) && c3.equals(oriWhite)){
				cell[0] = 255;
				cell[1] = 255;
				cell[2] = 255;
				newCell.setCell(cell);
			}
			if (c1.equals(oriWhite) && c2.equals(oriBlack) && c3.equals(oriBlack)){
				cell[0] = 255;
				cell[1] = 255;
				cell[2] = 255;
				newCell.setCell(cell);
			}
			if (c1.equals(oriWhite) && c2.equals(oriBlack) && c3.equals(oriWhite)){
				cell[0] = 0;
				cell[1] = 0;
				cell[2] = 0;
				newCell.setCell(cell);
			}
			if (c1.equals(oriWhite) && c2.equals(oriWhite) && c3.equals(oriBlack)){
				cell[0] = 255;
				cell[1] = 255;
				cell[2] = 255;
				newCell.setCell(cell);
			}
			if (c1.equals(oriWhite) && c2.equals(oriWhite) && c3.equals(oriWhite)){
				cell[0] = 0;
				cell[1] = 0;
				cell[2] = 0;
				newCell.setCell(cell);
			}

		} else if (this.ruleNum == 2) {
			if ((c1.getRed() == c2.getRed() && c2.getRed() == c3.getRed())
					&& (c1.getBlue() == c2.getBlue() && c2.getBlue() == c3.getBlue())) {
				col = new Color(Color.CYAN.getRed(), Color.CYAN.getGreen(), Color.CYAN.getBlue());
			} else {
				col = new Color((int) ((c3.getRed()) % 42),
						(int) ((c1.getGreen()) % 84),
						(int) ((c2.getBlue()) % 168));
				}
				cell[0] = col.getRed();
				cell[1] = col.getGreen();
				cell[2] = col.getBlue();
				newCell.setCell(cell);
			
		} else if (this.ruleNum == 3)  {
			if ((c1.getRed() == c2.getRed() && c2.getRed() == c3.getRed())
					&& (c1.getBlue() == c2.getBlue() && c2.getBlue() == c3.getBlue())) {
				col = new Color(Color.PINK.getRed(), Color.PINK.getGreen(), Color.PINK.getBlue());
			} else {
				col = new Color((int) ((c2.getRed()) % 3),
						(int) ((c3.getGreen()) % 37),
						(int) ((c1.getBlue()) % 254));
				}
				cell[0] = col.getRed();
				cell[1] = col.getGreen();
				cell[2] = col.getBlue();
				newCell.setCell(cell);
			
		}
		
		else if (this.ruleNum == 4)  {
			if ((c1.getRed() == c2.getRed() && c2.getRed() == c3.getRed())
					&& (c1.getBlue() == c2.getBlue() && c2.getBlue() == c3.getBlue())) {
				col = new Color(Color.ORANGE.getRed(), Color.ORANGE.getGreen(), Color.ORANGE.getBlue());
			} else {
				col = new Color((int) ((c1.getRed() + c2.getRed() + c3.getRed()) % (rand.nextInt(254)+1)),
						(int) ((c1.getGreen() + c2.getGreen() + c3.getGreen()) %  (rand.nextInt(254)+1)),
						(int) ((c1.getBlue() + c2.getBlue() + c3.getBlue()) %  (rand.nextInt(254)+1)));
				}
				cell[0] = col.getRed();
				cell[1] = col.getGreen();
				cell[2] = col.getBlue();
				newCell.setCell(cell);
			
		}

		return newCell;
	}
}
