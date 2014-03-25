package gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import logic.Simulator;

public class Window {
	private JFrame frame = new JFrame();
	private JPanel simulatorPanel;
	private Simulator simulator;

	public Window() {
		frame.setTitle("Crosswalk Simulator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// set size
		frame.setSize(500, 500);

		// set location
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((int) (dim.getWidth() / 2 - frame.getWidth() / 2),
				(int) (dim.getHeight() / 2 - frame.getHeight() / 2));

		// adding simulator panel
		simulator = new Simulator();
		simulatorPanel = new SimulatorPanel(simulator);
		frame.getContentPane().add(simulatorPanel, BorderLayout.CENTER);
	}

	public void start() {
		frame.setVisible(true);
	}
}