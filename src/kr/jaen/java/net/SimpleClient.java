package kr.jaen.java.net;
import java.net.*;
import java.io.*;

public class SimpleClient {
  public static void main(String args[]) {
    try {
      Socket s1 = new Socket("115.145.20.171", 7000);  //1. ����~  //"127.0.0.1":���� ��ǻ�͸� �ǹ���. ���� ��ǻ���� 7000���� �����Ѵ�. ���� ����� �� �ִ� ������ ������.
      BufferedReader br = new BufferedReader(new InputStreamReader(s1.getInputStream())); //���ڿ� ���� �Է� ��Ʈ�� (�������κ��� inputStream����)
      System.out.println("Server���� �� ���ڿ� : "+br.readLine());
      br.close();
      s1.close();
    } catch (ConnectException connExc) {
      System.err.println("Could not connect to the server.");
    } catch (IOException e) {
      // ignore
    }
  }
}
