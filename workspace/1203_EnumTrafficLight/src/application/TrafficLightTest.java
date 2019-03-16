package application;

public class TrafficLightTest {

	public static void main(String[] args) {
		TrafficLight tf1 = TrafficLight.YELLOW;

		switch(tf1)
		{
		case GREEN:
			System.out.println(tf1.getIndex()+ ": " + tf1.getDescription());
			break;
		case YELLOW:
			System.out.println("The ordinal of yellow is : " + tf1.ordinal());
			break;
		case RED:
			System.out.println("RED " + tf1.getDescription());
			break;
		}

	}

}
