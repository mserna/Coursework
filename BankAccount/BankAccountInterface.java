
public interface BankAccountInterface<T>
{

	double savingsAccount ();
	double checkingsAccount ();
	
	void savingsAccount (double balance);
	void checkingsAccount (double balance);
	
	double getCurrentCheckingBalance ();
	double getCurrentSavingBalance ();
	
	boolean isCheckingAccountEmpty ();
	boolean isSavingAccountEmpty ();
	
	void depositToChecking (double amount);
	void depositToSaving (double amount);
	void withdrawFromSaving (double amount);
	void withdrawFromChecking (double amount);
}
