package application;

public class FullTimeGameTester extends GameTester {

	@Override
	void calculateSalary(double hour) {
		this.setSalary(3000);
	}

	@Override
	void displayTesterInfo() {
		System.out.println("�� �� �� Full Time Tester�� �� �� \nName : " + this.getName() + "\nSalary : " + this.getSalary());
	}

}
