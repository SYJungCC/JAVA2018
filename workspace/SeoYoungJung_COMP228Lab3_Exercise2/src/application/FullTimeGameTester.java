package application;

public class FullTimeGameTester extends GameTester {

	@Override
	void calculateSalary(double hour) {
		this.setSalary(3000);
	}

	@Override
	void displayTesterInfo() {
		System.out.println("¡Ú ¡Ú ¡Ú Full Time Tester¡Ú ¡Ú ¡Ú \nName : " + this.getName() + "\nSalary : " + this.getSalary());
	}

}
