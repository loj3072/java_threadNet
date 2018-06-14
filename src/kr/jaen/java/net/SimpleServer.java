package kr.jaen.java.net;
import java.net.*;
import java.io.*;

public class SimpleServer {
  public static void main(String args[]) {
    ServerSocket s = null;
    try {
      s = new ServerSocket(7000); //1. 7000���� ���� ������.
    } catch (IOException e) {
      e.printStackTrace();
    }
    while (true) {
      try {
		System.out.println("Ŭ���Ʈ ������ �����..");
        Socket s1 = s.accept(); //2. client�� ��ٸ��� ��..
        OutputStream s1out = s1.getOutputStream(); //�������κ��� ����� �� �ִ� ��Ʈ�� ����
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s1out)); //���� ����
        bw.write("Hello Java and Android !!!\n");
		System.out.println("Ŭ���Ʈ���� ���ڿ� ������..");
         bw.close();
       s1.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
