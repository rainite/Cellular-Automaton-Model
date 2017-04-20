package edu.neu.csye6200.ca;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JViewport;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.ScrollPaneConstants;

public class UI extends JFrame implements ActionListener {

	private JFrame Frame = null;
	private JSlider cellNum = null;
	private JSlider genTimes = null;
	private JComboBox<String> rule = null;
	private CACanvas canvas = null;
	HashMap<Integer, ArrayList<CACell>> cellSet = new HashMap<Integer, ArrayList<CACell>>();
	int selec = 1;
	Thread runThread = null;
	
	
	@Override
	public Dimension getPreferredSize() {
	    return new Dimension(1600, 800);
	}

	public UI(){
		Frame = new JFrame();
		JPanel mainPanel = new JPanel();
		JPanel setPanel = new JPanel();
		Border thickBorder = new LineBorder(Color.black, 1);
		JLabel text1 = new JLabel("Cell Numbers:");
//		cellNum = new JTextField(0);
		JLabel text2 = new JLabel("Generation Times:");
//		genTimes = new JTextField(0);
		JLabel text3 = new JLabel("Select Rule:");
		
		
		this.cellNum = new JSlider(JSlider.HORIZONTAL,16,64,40);
	    this.cellNum.setMajorTickSpacing(16);
        this.cellNum.setPaintTicks(true);
	    this.cellNum.setPaintLabels(true);
	    
	    this.genTimes = new JSlider(JSlider.HORIZONTAL,16,64,32);
	    this.genTimes.setMajorTickSpacing(16);
        this.genTimes.setPaintTicks(true);
	    this.genTimes.setPaintLabels(true);


		setPanel.setLayout(new GridLayout(2, 4));
		setPanel.add(text1);
	    setPanel.add(cellNum);
		setPanel.add(text2);
		setPanel.add(genTimes);
		setPanel.add(text3);

		rule = new JComboBox<String>();
		rule.addItem("rule1");
		rule.addItem("rule2");
		rule.addItem("rule3");
		rule.addItem("Surprise me!");
		rule.addActionListener(this);
		setPanel.add(rule);

		JButton str = new JButton("start");
		str.addActionListener(this);
		setPanel.add(str);

		JButton stp = new JButton("stop");
		stp.addActionListener(this);
		setPanel.add(stp);
		
//		JButton pause = new JButton("Pause");
//		stp.addActionListener(this);
//		setPanel.add(pause);
		
		
		setPanel.setBackground(Color.GRAY);
		
		

		

		mainPanel.add(setPanel);
		mainPanel.setBorder(thickBorder);
		mainPanel.setBackground(Color.GRAY);

		
		canvas = new CACanvas();

		JScrollPane scrollPane=new JScrollPane(canvas);
		
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		Frame.setAlwaysOnTop(isAlwaysOnTop());
		Frame.getContentPane().setLayout(new BorderLayout());
		Frame.add(mainPanel,BorderLayout.NORTH);
		Frame.add(scrollPane, BorderLayout.CENTER);
		Frame.setTitle("CAApp");
		Frame.setBackground(Color.WHITE);
		Frame.setSize(800, 600);
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Frame.setVisible(true);
		Frame.setResizable(true);
		Frame.setLocationRelativeTo(null);

	}


	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == rule) {
			int i = rule.getSelectedIndex();
			selec = i + 1;
		}

		if (e.getActionCommand().equals("start")) {
			
				int Num = this.cellNum.getValue();
				int Times = this.genTimes.getValue();

				cellSet = CAGenerationSet.Generation(Times, Num, selec);
				
				ArrayList<CACell> cells = new ArrayList<CACell>();

				for (int i = 0; i < cellSet.size(); i++) {

					for (int j = 0; j < cellSet.get(i).size(); j++) {
						cells.add(cellSet.get(i).get(j));
					}

					cellSet.put(i, cells);
					cells = new ArrayList<CACell>();
				}

				Runnable runnable = new Runnable() {
					public void run() {
						canvas.setCellSet(cellSet);
						for (int i = 0; i < cellSet.size(); i++) {
							for (int j = 0; j < cellSet.get(i).size(); j++) {
								canvas.setTime(i);
								canvas.repaint();
							}
					
							
							
							try {
								Thread.sleep(100);
							} catch (InterruptedException ex) {
								ex.printStackTrace();
							}
						}
					}
				};
				runThread = new Thread(runnable);
				runThread.start();
			}
		

		if (e.getActionCommand().equals("stop")) {
			runThread.stop();
		}
//
//		if (e.getActionCommand().equals("Pause")){
//			if(runThread.isAlive()){
//			try {
//				runThread.wait();
//			} catch (InterruptedException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//
//			}
//			else{
//				runThread.notify();
//			}
//		}
		
		
		
	}

}
