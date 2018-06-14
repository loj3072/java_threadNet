package kr.jaen.java.net;
import java.net.*;
import java.io.*;

public class SimpleServer {
  public static void main(String args[]) {
    ServerSocket s = null;
    try {
      s = new ServerSocket(7000); //1. 7000번의 문을 열었다.
    } catch (IOException e) {
      e.printStackTrace();
    }
    while (true) {
      try {
		System.out.println("클라언트 접속을 대기중..");
        Socket s1 = s.accept(); //2. client를 기다리는 중..
        OutputStream s1out = s1.getOutputStream(); //소켓으로부터 출력할 수 있는 스트림 생성
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s1out)); //버퍼 생성
        bw.write("Hello Java and Android !!!\n");
		System.out.println("클라언트에게 문자열 전송중..");
         bw.close();
       s1.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
