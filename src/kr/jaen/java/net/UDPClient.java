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
      hostname = "115.145.20.171";   //원격 접속시 수정하세요^^
    }
    try {
      String strInput;
      DatagramPacket outPacket; //데이터그램패킷. 데이터를 소포화 시키는 것이 패킷. 패킷에 IP와 port번호를 넣어서 보냄.
      	InetAddress server = InetAddress.getByName(hostname); //호스트 주소
      	BufferedReader userInput= new BufferedReader(new InputStreamReader(System.in)); //System.in: 키보드로 읽는다(=8비트) ->16비트로 바꿔야 함 ->버퍼로
      	DatagramSocket dSock = new DatagramSocket(); //소켓 오픈     	
		System.out.println("서버로 전송 문자열을 입력하세요. 마지막엔 'q'");
      while (true) {
		System.out.print("\n전송 문자열: ");
        strInput = userInput.readLine(); 	
        if (strInput.equals("q")) break;
        byte[] data = strInput.getBytes();
        outPacket = new DatagramPacket(data, data.length, server, port); //소포 생성. 패킷에 데이터, 데이터의 사이즈, 서버주소, 포트
        dSock.send(outPacket); //소켓을 통해 데이터를 내보냄.
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
		System.out.println("패킷 IP : " + packet.getAddress());
		System.out.println("패킷 PORT : " + packet.getPort());
		System.out.println("패킷 SIZE : " + packet.getLength());		
	}
}