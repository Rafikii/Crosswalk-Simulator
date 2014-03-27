package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;
import javax.swing.Timer;

import logic.Person;
import logic.Simulator;

public class SimulatorPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Simulator simulator;
	private Timer timer;

	public SimulatorPanel(Simulator simulator) {
		setBackground(Color.BLACK);

		this.simulator = simulator;

		timer = new Timer(1000 / 60, simulatorUpdater);
		timer.start();
	}

	ActionListener simulatorUpdater = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			simulator.update();
			repaint();
		}
	};

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		draw(g);
	}

	private void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		drawPerson(g2d, simulator.rafiki);
	}

	private void drawPerson(Graphics2D g2d, Person person) {
		g2d.setColor(Color.RED);
		if (person.showTrail) {
			for (int i = 0; i < person.trail.size(); i += person.trailPrecision)
				g2d.drawLine((int) person.trail.get(i).x,
						(int) person.trail.get(i).y,
						(int) person.trail.get(i).x,
						(int) person.trail.get(i).y);
		}

		g2d.setColor(Color.YELLOW);
		g2d.draw(new Ellipse2D.Double(person.position.x - person.radius / 2,
				person.position.y - person.radius / 2, person.radius,
				person.radius));
		g2d.fill(new Ellipse2D.Double(person.position.x - person.radius / 2,
				person.position.y - person.radius / 2, person.radius,
				person.radius));
	}
}
