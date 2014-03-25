package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

import java.awt.Color;

import logic.Simulator;

public class SimulatorPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Simulator simulator;

	public SimulatorPanel(Simulator simulator) {
		setBackground(Color.BLACK);

		this.simulator = simulator;
	}

	public void actionPerformed(ActionEvent e) {
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		draw(g);
	}

	private void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		g2d.setColor(Color.YELLOW);
		g2d.draw(new Ellipse2D.Double(0, 0, 50, 50));
		g2d.setColor(Color.RED);
		g2d.fill(new Ellipse2D.Double(0, 0, 50, 50));
	}
}
