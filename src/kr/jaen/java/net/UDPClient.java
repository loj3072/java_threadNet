package kr.jaen.java.net;
import java.net.*;
import java.io.*;

public class UDPClient {
  public final static int port = 3000;
  public static void main(String[] args) {
    String hostname;
    if (args.length > 0) {
      hostname = args[0];
    } else {
      hostname = "115.145.20.171";   //���� ���ӽ� �����ϼ���^^
    }
    try {
      String strInput;
      DatagramPacket outPacket; //�����ͱ׷���Ŷ. �����͸� ����ȭ ��Ű�� ���� ��Ŷ. ��Ŷ�� IP�� port��ȣ�� �־ ����.
      	InetAddress server = InetAddress.getByName(hostname); //ȣ��Ʈ �ּ�
      	BufferedReader userInput= new BufferedReader(new InputStreamReader(System.in)); //System.in: Ű����� �д´�(=8��Ʈ) ->16��Ʈ�� �ٲ�� �� ->���۷�
      	DatagramSocket dSock = new DatagramSocket(); //���� ����     	
		System.out.println("������ ���� ���ڿ��� �Է��ϼ���. �������� 'q'");
      while (true) {
		System.out.print("\n���� ���ڿ�: ");
        strInput = userInput.readLine(); 	
        if (strInput.equals("q")) break;
        byte[] data = strInput.getBytes();
        outPacket = new DatagramPacket(data, data.length, server, port); //���� ����. ��Ŷ�� ������, �������� ������, �����ּ�, ��Ʈ
        dSock.send(outPacket); //������ ���� �����͸� ������.
        UDPClient.viewInfo(outPacket);
      }  
    } catch (UnknownHostException e) {
      System.err.println(e);
    } catch (SocketException se) {
      System.err.println(se);
    } catch (IOException e) {
      System.err.println(e);
    }
  }  // end main
	public static void viewInfo(DatagramPacket packet){
		System.out.println("��Ŷ IP : " + packet.getAddress());
		System.out.println("��Ŷ PORT : " + packet.getPort());
		System.out.println("��Ŷ SIZE : " + packet.getLength());		
	}
}