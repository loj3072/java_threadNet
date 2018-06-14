package kr.jaen.java.net;
import java.net.*;
import java.io.*;

public class SimpleClient {
  public static void main(String args[]) {
    try {
      Socket s1 = new Socket("115.145.20.171", 7000);  //1. 갈게~  //"127.0.0.1":같은 컴퓨터를 의미함. 같은 컴퓨터의 7000번에 접근한다. 서로 통신할 수 있는 소켓이 열렀음.
      BufferedReader br = new BufferedReader(new InputStreamReader(s1.getInputStream())); //글자에 대한 입력 스트림 (소켓으로부터 inputStream생성)
      System.out.println("Server에서 온 문자열 : "+br.readLine());
      br.close();
      s1.close();
    } catch (ConnectException connExc) {
      System.err.println("Could not connect to the server.");
    } catch (IOException e) {
      // ignore
    }
  }
}
