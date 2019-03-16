package application;
import javax.swing.JOptionPane;
public class NameDialog {

	public static void main(String[] args)
	{
		String name = JOptionPane.showInputDialog("What is your name?");

		//create
		String message = String.format("Welcome, %s, to Java Programming!", name);

		JOptionPane.showMessageDialog(null, message);


		int value;

		String nameValue = JOptionPane.showInputDialog("Enter a value?");
		value = Integer.parseInt(nameValue);

		value *= 2;

		String message1 = String.format("Value multiplied by 2 : %d", value);

	}
}
