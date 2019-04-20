package master;

import java.util.concurrent.ThreadLocalRandom;

import javafx.geometry.Point2D;
import javafx.scene.shape.Circle;

public class Bird {

	Species type;
	
	Point2D center;
	Point2D velocity;
	Point2D acceleration;
	
	Circle body;
	
	public Bird() {
		type = new Species(ThreadLocalRandom.current().nextInt(0,6));
		center = new Point2D(ThreadLocalRandom.current().nextDouble()*Airspace.width,ThreadLocalRandom.current().nextDouble()*Airspace.height);
		velocity = new Point2D(((ThreadLocalRandom.current().nextDouble()*2 )-1)*5,((ThreadLocalRandom.current().nextDouble()*2 )-1)*5);
		acceleration = new Point2D(0,0);
	}
	
	//Overloaded the main methods to support 1 species and many species mode
	public void cohesion(Bird[] mates,double range,double factor) {
		double count = 1;
		Point2D acc = new Point2D(0,0);
		for(Bird b : mates) {
			if(!this.equals(b)) {
				if(center.distance(b.center) < range) {
					acc= acc.add(b.center.subtract(center));
					count += 1.0;
				}
			}
		}
		acceleration = acceleration.add((acc).multiply(factor/count));
	}
	
	public void cohesion(Bird[] mates) {cohesion(mates,type.awareness,type.cohesiveness);}
	
	public void steering(Bird[] mates,double range,double factor) {
		double count = 1;
		Point2D vel = velocity;
		for(Bird b : mates) {
			if(!this.equals(b)) {
				if(center.distance(b.center) < range) {
					vel= vel.add(b.velocity);
					count += 1.0;
				}
			}
		}
		vel = vel.subtract(velocity);
		acceleration = acceleration.add((vel).multiply(factor/count));
	}
	
	public void steering(Bird[] mates) {steering(mates,type.awareness,type.willtosteer);}
	
	public void separation(Bird[] mates,double range,double factor) {
		double count = 1;
		Point2D acc = new Point2D(0,0);
		for(Bird b : mates) {
			if(!this.equals(b)) {
				if(center.distance(b.center) < range) {
					acc= acc.add((b.center.subtract(center)).multiply(1/(center.distance(b.center))));
					count += 1.0;
				}
			}
		}
		acceleration = acceleration.subtract((acc).multiply(factor/count));
	}
	
	public void separation(Bird[] mates) {separation(mates,type.awareness,type.divisiveness);}
}
