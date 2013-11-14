package threadTEst;

public class TestRunnable implements Runnable{

	@Override
	public void run() {
		for(int i=0; i < 100; i++){
			System.out.println("twiter response");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
