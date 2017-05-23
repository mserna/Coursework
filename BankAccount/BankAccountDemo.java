
public class BankAccountDemo 
{
	
	public static void main (String[] args)
	{	
		BankAccount account = new BankAccount();
		
		System.out.println("Hello welcome to your personal bank account: ");
		System.out.println("This is a mock bank, and we would like to test your"
							+ " finance skills. Lets get");

		System.out.println("So far, your current checkings balance is: " + account.getCurrentCheckingBalance());
		System.out.println("So far, your current savings balance is: " + account.getCurrentSavingBalance());
	}
}
