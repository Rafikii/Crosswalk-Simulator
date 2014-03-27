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
import javax.swing.Timer;

import logic.Simulator;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ControlPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private JPanel titlePanel;
	private JLabel lblControlPanel;

	private JPanel controls;

	private JPanel trailPanel;
	private JButton btnShowHideTrail;

	private JPanel timerPanel;
	private JLabel timerSliderLabel;
	private JSlider timerSlider;

	private JPanel playPauseButtonPanel;
	private JButton btnStartSimulation;

	private Simulator simulator;
	private Timer timer;

	public ControlPanel(SimulatorPanel simulatorPanel) {
		setSize(new Dimension(200, 500));
		setLayout(new BorderLayout(0, 0));

		this.simulator = simulatorPanel.simulator;
		this.timer = simulatorPanel.timer;

		setUpTitle();

		controls = new JPanel();
		add(controls, BorderLayout.CENTER);
		controls.setLayout(new GridLayout(5, 0, 0, 0));

		setUpTrailPanel();
		setupTimerSliderPanel();

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

	private void setupTimerSliderPanel() {
		timerPanel = new JPanel();
		controls.add(timerPanel);

		timerSliderLabel = new JLabel("Time Multiplier");
		timerPanel.add(timerSliderLabel);

		timerSlider = new JSlider();
		timerSlider.setSnapToTicks(true);
		timerSlider.setPaintLabels(true);
		timerSlider.setMajorTickSpacing(10);
		timerSlider.setMinorTickSpacing(5);
		timerSlider.setPaintTicks(true);
		timerSlider.setValue(10);
		timerSlider.setMaximum(40);
		timerPanel.add(timerSlider);
		timerSlider.setFocusable(false);

		timerSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				timer.setDelay(1000 / (60 * timerSlider.getValue() / 10));
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
					btnStartSimulation.setText("Pause");
					simulator.play();
				} else {
					btnStartSimulation.setText("Resume");
					simulator.stop();
				}
			}
		});
	}
}
