package kr.jaen.java.net;
import java.net.*;
import java.io.*;

public class UDPServer {
  public final static int echoPort = 3000;
  static byte[] buffer = new byte[65507];
  public static void main(String[] args) {
    try {
      DatagramSocket ds = new DatagramSocket(echoPort);
      DatagramPacket dp = new DatagramPacket(buffer, buffer.length); //�� ��Ŷ.
      while (true) {
        try {
          ds.receive(dp);//�� ��Ŷ�� �����Ͱ� ����
          String s = new String(dp.getData(), 0, dp.getLength());
          System.out.println("���۵Ǿ�� ���ڿ�("+dp.getAddress() + "): "+ s);
        }catch (IOException e) {
          System.err.println(e);
        }      
       } 
    }catch (SocketException se) {
      System.err.println(se);
    }  
  }  
}