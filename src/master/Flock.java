package master;

import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.shape.Circle;

public class Flock {

	private Bird[] birds = new Bird[20];
	private double maxV = 10;
	
	//Flock-wide parameters
	private double awareness = 45;
	private double cohesiveness = 1;
	private double willtosteer = 1;
	private double divisiveness = 35;

	
	public Flock() {for(int i = 0;i<birds.length;i++) {birds[i] = new Bird();}}
	
	public void update(boolean s) {
		for(Bird boid : birds) {
			
			if(!s) {
				//1 species
				boid.cohesion(birds,awareness,cohesiveness);
				boid.steering(birds,awareness,willtosteer);
				boid.separation(birds,awareness,divisiveness);
			}else {
				//many species
				boid.cohesion(birds);
				boid.steering(birds);
				boid.separation(birds);
			}
			
			//Velocity = velocity + acceleration
			boid.velocity = boid.velocity.add(boid.acceleration);
			if(boid.velocity.magnitude() > maxV) {	boid.velocity = boid.velocity.multiply(maxV/boid.velocity.magnitude());}
			
			//Position = position + velocity
			boid.center = boid.center.add(boid.velocity);
			if(boid.center.getX() < 0) {				boid.center = boid.center.add(new Point2D(Airspace.width,0));}
			if(boid.center.getX() > Airspace.width) {	boid.center = boid.center.add(new Point2D(-Airspace.width,0));}
			if(boid.center.getY() < 0) {				boid.center = boid.center.add(new Point2D(0,Airspace.height));}
			if(boid.center.getY() > Airspace.height) {	boid.center = boid.center.add(new Point2D(0,-Airspace.height));}
			boid.body.relocate(boid.center.getX(),boid.center.getY());
			
			//Reset acceleration
			boid.acceleration = new Point2D(0,0);

		}
	}
	
	public void draw(Group root) {
		for(Bird boid : birds) {
			boid.body = new Circle(boid.center.getX(),boid.center.getY(),4);
			boid.body.setFill(boid.type.color);
			boid.body.setStrokeWidth(1.0);

			root.getChildren().add(boid.body);
		}
	}
}
