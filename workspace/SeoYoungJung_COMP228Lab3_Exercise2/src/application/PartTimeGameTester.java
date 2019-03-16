package application;

public class PartTimeGameTester extends GameTester{

	final private double HOURLY_SELARY = 20;

	@Override
	void calculateSalary(double hour) {
		this.setSalary(HOURLY_SELARY * hour);
	}

	@Override
	void displayTesterInfo() {
		System.out.println("』 』 』 Part Time Tester』 』 』  \nName : "  + this.getName() + "\nSalary : " + this.getSalary());
	}

}
