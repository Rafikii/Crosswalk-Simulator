package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import logic.Simulator;

public class ControlPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private JPanel titlePanel;
	private JLabel lblControlPanel;

	private JPanel playPauseButtonPanel;
	private JButton btnStartSimulation;
	private JPanel controls;
	private JPanel trailPanel;
	private JButton btnShowHideTrail;

	private Simulator simulator;

	public ControlPanel(Simulator simulator) {
		setSize(new Dimension(200, 500));
		setLayout(new BorderLayout(0, 0));

		this.simulator = simulator;

		setUpTitle();

		controls = new JPanel();
		add(controls, BorderLayout.CENTER);
		controls.setLayout(new GridLayout(1, 0, 0, 0));

		setUpTrailPanel();

		setUpPlayButton();
	}

	private void setUpTitle() {
		titlePanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) titlePanel.getLayout();
		flowLayout.setHgap(50);
		add(titlePanel, BorderLayout.NORTH);

		lblControlPanel = new JLabel("Control Panel");
		titlePanel.add(lblControlPanel);
		lblControlPanel.setHorizontalAlignment(SwingConstants.CENTER);
	}

	private void setUpTrailPanel() {
		trailPanel = new JPanel();
		controls.add(trailPanel);

		btnShowHideTrail = new JButton("Show/Hide Trail");
		trailPanel.add(btnShowHideTrail);
		btnShowHideTrail.setFocusable(false);
		btnShowHideTrail.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				simulator.rafiki.showHideTrail();
			}
		});
	}

	private void setUpPlayButton() {
		playPauseButtonPanel = new JPanel();
		add(playPauseButtonPanel, BorderLayout.SOUTH);

		btnStartSimulation = new JButton("Start Simulation");
		playPauseButtonPanel.add(btnStartSimulation);
		btnStartSimulation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (simulator.isPaused()) {
					btnStartSimulation.setText("Resume");
					simulator.play();
				} else {
					btnStartSimulation.setText("Pause");
					simulator.stop();
				}
			}
		});
	}
}
