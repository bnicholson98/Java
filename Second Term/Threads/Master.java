public class Master{
	
	public static void main(String args[]){		
		BankAccount account1 = new BankAccount();
		BankAccount account2 = new BankAccount();
		
		final int n1 = 5;
		Thread [] slave1 = new Thread[n1];
		
		for (int i = 0; i < n1; i++){
			slave1[i] = new Thread(new Slave(account1,account2));
			slave1[i].start();
			
		}

		final int n2 = 5;
		Thread [] slave2 = new Thread[n2];
		
		for (int i = 0; i < n2; i++){
			slave2[i] = new Thread(new Slave(account2,account1));
			slave2[i].start();
		}
		
		try{
			for (Thread s : slave1){
				s.join();
			}
			
			for (Thread s : slave2){
				s.join();
			}
		}catch (InterruptedException e){
		}
		
		System.out.println("The sum of balances should be 0 and is actually "
		+(account1.getBalance()+account2.getBalance()));
	}
}
	