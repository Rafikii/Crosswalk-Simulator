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
	public Simulator simulator;
	public Timer timer;

	public SimulatorPanel(Simulator simulator) {
		setBackground(Color.BLACK);

		this.simulator = simulator;

		timer = new Timer((int) Math.round(1000.0 / Launcher.FPS),
				simulatorUpdater);
		timer.start();
	}

	ActionListener simulatorUpdater = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			simulator.update();

			if (simulator.rafiki.position.x + simulator.rafiki.radius > getWidth()
					|| simulator.rafiki.position.x - simulator.rafiki.radius < 0)
				simulator.rafiki.speed.x = -simulator.rafiki.speed.x;

			if (simulator.rafiki.position.y + simulator.rafiki.radius > getHeight()
					|| simulator.rafiki.position.y - simulator.rafiki.radius < 0)
				simulator.rafiki.speed.y = -simulator.rafiki.speed.y;

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

		if (person.radius != 0) {
			g2d.setColor(Color.YELLOW);
			g2d.draw(new Ellipse2D.Double(person.position.x - person.radius,
					person.position.y - person.radius, person.radius * 2,
					person.radius * 2));
			g2d.fill(new Ellipse2D.Double(person.position.x - person.radius,
					person.position.y - person.radius, person.radius * 2,
					person.radius * 2));
		}
	}
}
