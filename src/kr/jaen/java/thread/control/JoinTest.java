package kr.jaen.java.thread.control;
class JoinTest {
	public static void main(String[] args){ 
		ThreadA a=new ThreadA();
		ThreadB b=new ThreadB(a);
		b.start();
		a.start();
	}
}
class ThreadA extends Thread{
	public void run(){
		for(int i=0;i<=7;i++){
			System.out.println("������ A ���� �� "+" "+i);
			try{
				sleep(1000);
			}catch(InterruptedException e){e.printStackTrace();}
		}
	}
}
class ThreadB extends Thread{
	ThreadA a;
	public ThreadB(ThreadA a){
		this.a=a;
	}
	public void run(){
		System.out.println("ThreadB Start....");
		try{
			for(int i=0;i<=5;i++){
				System.out.println("������ B ���� �� "+" "+i);
				if(i==2) a.join(); //
			}
		}catch(InterruptedException e){}
	}
}
