package kr.jaen.java.io.serial;
import java.io.*;
public class SerializeObject{
  public static void main (String args[]){
	Customer  c = new Customer();
		c.name="ȫ�浿";
		c.address="����";
		c.age=20;

    try {
      FileOutputStream f = 	new FileOutputStream ("Data.ser");
      ObjectOutputStream s = new ObjectOutputStream (f);
      s.writeObject(c);
	  System.out.println(" ������ �����Ǿ����ϴ�");
      s.close ();
	  f.close();
    } catch (IOException e) {
      e.printStackTrace ();
    }
  }
}
