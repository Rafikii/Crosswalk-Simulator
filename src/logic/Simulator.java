package logic;

public class Simulator {
	public Person rafiki;
	private boolean firstTimePlaying = true;
	private boolean paused = true;

	public Simulator() {
		rafiki = new Person(10, 10, 10);
	}
	
	public void update() {
		if (!paused) {
			rafiki.update();
		}
	}

	public void play() {
		paused = false;
		
		if (firstTimePlaying) {
			firstTimePlaying = false;
			
			rafiki.incSpeed();
		}
	}

	public void stop() {
		paused = true;
	}
	
	public boolean isPaused() {
		return paused;
	}
}
