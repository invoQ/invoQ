package threadTEst;

public class TestMain {
	public static void main(String[] args) {
//		//facebook ÀÀ´ä
//		ThreadTest tt1 = new ThreadTest();
//		
//		ThreadTest2 tt2 = new ThreadTest2();
//		
//		tt1.start();
//		tt2.start();
//		
//		
		
		Runnable tr = new TestRunnable();
		Thread ttl = new Thread(tr);
		
		Runnable tr2 = new TestRunnable2();
		Thread ttl2 = new Thread(tr2);
		
		ttl.start();
		ttl2.start();
		System.out.println("is Done??");
	}
}
