package kr.jaen.java.thread.syncwait;
class MainData {
	int data;
	 public void increase(String name){	
		System.out.print(name + "�� " + data);
		pause(500);
		data++;
		//this.notify();
		System.out.println("�� " + data + "�� ������Ŵ");
	}
	 public void decrease(String name){
		//if(data <= 0)this.wait();
		System.out.print(name + "�� " + data);
		pause(100);
		data--;
		System.out.println("�� " + data + "�� ���ҽ�Ŵ");
	}
	public void pause(long time){
		try{
			Thread.sleep(100);
		}catch(InterruptedException e){}
	}
}