package gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.UIManager;

import java.awt.BorderLayout;

import logic.Simulator;

public class Window {
	private JFrame frame = new JFrame();
	private SimulatorPanel simulatorPanel;
	private ControlPanel controlPanel;
	private Simulator simulator;

	public Window() {
		frame.setTitle("Crosswalk Simulator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println("Error initiating the frame\n");
		}

		// set size
		frame.setSize(700, 500);

		// set location
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((int) (dim.getWidth() / 2 - frame.getWidth() / 2),
				(int) (dim.getHeight() / 2 - frame.getHeight() / 2));

		// adding simulator panel
		simulator = new Simulator();
		simulatorPanel = new SimulatorPanel(simulator);
		frame.getContentPane().add(simulatorPanel, BorderLayout.CENTER);

		// adding controls panel
		controlPanel = new ControlPanel(simulatorPanel);
		frame.getContentPane().add(controlPanel, BorderLayout.EAST);
	}

	public void start() {
		frame.setVisible(true);
	}
}
