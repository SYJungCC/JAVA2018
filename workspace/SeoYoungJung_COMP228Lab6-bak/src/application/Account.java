package application;

public class Account {

	private static double _money = 0;

	public synchronized void updateBalance(double amount)
	{
		//System.out.println("Money from account - Start " + this._money);
		_money += amount;
		//System.out.println("Money from account - END " + this._money);
	}

	public  double getBalance() {
		return _money;
	}


}
