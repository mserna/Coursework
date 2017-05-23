
public class BankAccount<T> implements BankAccountInterface<T>
{
	private double checkingsBalance = 100;
	private double savingsBalance = 100;
	
	@Override
	public double savingsAccount() 
	{
		return savingsBalance;
	}

	@Override
	public double checkingsAccount() 
	{
		return checkingsBalance;
	}

	@Override
	public void savingsAccount(double balance) 
	{
		balance = this.savingsBalance;
	}

	@Override
	public void checkingsAccount(double balance) 
	{
		balance = this.checkingsBalance;
		
	}

	@Override
	public double getCurrentCheckingBalance() 
	{
		return this.checkingsBalance;
	}
	
	@Override
	public double getCurrentSavingBalance ()
	{
		return this.savingsBalance;
	}

	@Override
	public boolean isCheckingAccountEmpty() 
	{
		if (this.checkingsBalance <= 0)
		{
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean isSavingAccountEmpty() 
	{
		if (this.savingsBalance <= 0)
		{
			return true;
		}
		
		return false;
	}
	

	@Override
	public void depositToChecking(double amount) 
	{
		this.checkingsBalance = this.checkingsBalance + amount;
		
	}
	
	@Override
	public void depositToSaving(double amount) 
	{
		this.savingsBalance = this.savingsBalance + amount;
		
	}

	@Override
	public void withdrawFromChecking(double amount) 
	{
		if (this.checkingsBalance - amount <= 0)
		{
			System.out.println("Can not withdraw amount. Insufficient funds.");
		}
		else
		{
			this.checkingsBalance = this.checkingsBalance - amount;
		}
	}
	
	@Override
	public void withdrawFromSaving(double amount) 
	{
		if (this.savingsBalance - amount <= 0)
		{
			System.out.println("Can not withdraw amount. Insufficient funds.");
		}
		else
		{
			this.savingsBalance = this.savingsBalance - amount;
		}
	}
}
