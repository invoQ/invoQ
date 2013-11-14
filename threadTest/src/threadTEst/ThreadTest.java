package threadTEst;

public class ThreadTest extends Thread{
	@Override
	public void run() {
		super.run();
		for(int i = 0; i < 100 ;  i++){
			System.out.println("facebook response.....");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
