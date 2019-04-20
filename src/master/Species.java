package master;

import javafx.scene.paint.Color;

public class Species {
	
	Color color;
	double awareness;
	double cohesiveness;
	double willtosteer;
	double divisiveness;
	
	public Species(int n) {
		
		switch(n) {
			case 0:	color = Color.RED;			awareness = 48;	cohesiveness = 0.3;	willtosteer = 1.2;	divisiveness = 40;	break;
			case 1:	color = Color.INDIANRED;	awareness = 24;	cohesiveness = 0.3;	willtosteer = 1.2;	divisiveness = 40;	break;
			case 2:	color = Color.GREEN;		awareness = 48;	cohesiveness = 1.2;	willtosteer = 1.2;	divisiveness = 20;	break;
			case 3:	color = Color.LIMEGREEN;	awareness = 24;	cohesiveness = 1.2;	willtosteer = 1.2;	divisiveness = 20;	break;
			case 4:	color = Color.BLUE;			awareness = 48;	cohesiveness = 1.2;	willtosteer = 0.3;	divisiveness = 40;	break;
			case 5:	color = Color.LIGHTBLUE;	awareness = 24;	cohesiveness = 1.2;	willtosteer = 0.3;	divisiveness = 40;	break;
		}
	}
}
