package gui;

public class Launcher {
	public final static int FPS = 60;

	public static void main(String[] args) {
		System.out.println("Launching simulator...");

		Window window = new Window();
		window.start();
	}
}
