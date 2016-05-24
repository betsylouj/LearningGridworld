import java.awt.Color;
import java.util.Random;

import javax.swing.JOptionPane;

import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

public class LearningGridworld {

	World myWorld;

	public static void main(String[] args) {
		new LearningGridworld().go();
	}

	private void go() {
		myWorld = new World();
		myWorld.show();

		myWorld.add(new Location(1, 1), new Bug());
		int x = new Random().nextInt(10);
		int y = new Random().nextInt(10);
		int colorSwitch = 0;
		Bug myBug = new Bug(Color.blue);
		myBug.turn();
		myBug.turn();
		myWorld.add(new Location(x, y), myBug);
		if (y - 1 >= 0) {
			myWorld.add(new Location(x, y - 1), new Flower(Color.YELLOW));
		}
		if (y + 1 <= 9) {
			myWorld.add(new Location(x, y + 1), new Flower(Color.YELLOW));
		}

		JOptionPane.showMessageDialog(null, "Let's continue");
		for (int i = 0; i <= 9; i++) {
			for (int j = 0; j <= 9; j++) {

				if (colorSwitch == 0) {
					myWorld.add(new Location(j, i), new Flower(Color.red));
				} else {
					myWorld.add(new Location(j, i), new Flower(Color.white));
				}

				if (colorSwitch == 0) {
					colorSwitch = 1;
				} else {
					colorSwitch = 0;
				}
			}
		}
	}
}
