package kr.jaen.java.io.serial;

public class Customer  implements java.io.Serializable
{
	String  name;
	String  address;
	transient int	    age;

	public String toString(){
		return "�̸� : "+name+"\t�ּ� : "+address+"\t���� : "+age;
	}
}


