import processing.core.PApplet;
import NeuralNetwork.MLP;
import ObstacleRace.GCar;
import ObstacleRace.ObstacleRace;

/**
 * 
 * @author user
 *
 */
public class Main extends PApplet {
	
	// Race
	ObstacleRace race;
	float time = 0;
	
	/**
	 * Setup
	 */
	public void setup() {
		size(640, 480);
		
		race = new ObstacleRace(Configurations.SENSOR_LAYERS, this);
		race.start();
	}

	/**
	 * Draw
	 */
	public void draw() {
		background(0);

		race.draw();
		race.update();
		
		GCar bestGenoma = race.getBestGenoma();
		
		//
		fill(255, 50);
		rect(20, 20, 200, 115);
		fill(255);
		textSize(20);
		text("Gera��o: " + race.getGeneration(), 30, 50);
		textSize(15);
		text("Popula��o: " + race.getPopulationSize(), 40, 70);
		text("Melhor Gene: " + race.getBestGenomaId(), 40, 85);
		text("Melhor Resultado: " + (int)bestGenoma.getFitness(), 40, 100);
		text("Distancia Atual: " + (int)race.getCurrentDistanceToGoal(), 40, 115);
	}
}
