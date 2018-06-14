package kr.jaen.java.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


class MyRunnable implements Runnable{
	public void run(){
		String name = Thread.currentThread().getName();
		for (int i = 0; i < 5; i++) {
			//��������ִ� ������ �̸� Ȯ�� 
			System.out.println(name+":"+i);
		}
	}
}
public class ExecutorServiceTest {
	public static void main(String[] args) {
		//�ִ� ����� Thread�� ������ 10 ���� ����
		ExecutorService   pool =Executors.newFixedThreadPool(10);
		MyRunnable  command = new MyRunnable();
		
		//command�� 10�� ������ ���� 
		for (int i = 0; i < 10; i++) {
			pool.execute(command);
		}
		try{Thread.sleep(10000);}catch(Exception e){}
		
		System.out.println("---------------");
		
		//������ �����带 �����ϴ��� Ȯ��
		for (int i = 0; i < 5; i++) {
			pool.execute(command);
		}
	}
}
