package application;


public class Transaction implements Runnable {

	private Account _acc ;
	private String _taskName;
	private double _money;

	Transaction(String taskName, Account acc, double money)
	{
		_acc = acc;
		_taskName = taskName;
		_money = money;
	}


	public void getBalance()
	{
		System.out.println("---- "+_acc.getBalance());
	}


	@Override
	public void run() {

		System.out.printf( "Task : %s \n", _taskName );
		_acc.updateBalance(this._money);
		System.out.println("balance after transaction :" + _acc.getBalance());

	}

	//600
	//490
	//500
}
