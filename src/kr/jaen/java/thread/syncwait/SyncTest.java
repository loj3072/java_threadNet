package kr.jaen.java.thread.syncwait;
class SyncTest {
	public static void main(String[] args){
		MainData m = new MainData();
		//MainData m = new MainData2();

		IncThread t1 = new IncThread(m,"������ A");
		IncThread t3 = new IncThread(m,"������ B");

		DecThread t2 = new DecThread(m,"������ a");
		DecThread t4 = new DecThread(m,"������ b");
		
		t1.start();		
		t2.start();	
		t3.start();		
		t4.start();	
	
	}
}
