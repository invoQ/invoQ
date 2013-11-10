package threadTEst;

public class ThreadTest2 extends Thread{
	@Override
	public void run() {
		for(int i=0; i < 200; i++){
			System.out.println("twiter response");
			try {
				Thread.sleep(700);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
