import java.util.*;

public class Slave extends Thread{

	private BankAccount source, target;
	
	public Slave(BankAccount source, BankAccount target){
		this.source = source;
		this.target = target;
	}
		
	public void run(){		
		Random rand = new Random();
		
		for (int i = 0; i < 1000000; i++){
			int amount = rand.nextInt(100);
			
			synchronized  (source){
				int g = source.getBalance();
				source.setBalance(g - amount);
			}
			
			synchronized (target){
				target.setBalance(target.getBalance() + amount);
			}
		}
	}
}