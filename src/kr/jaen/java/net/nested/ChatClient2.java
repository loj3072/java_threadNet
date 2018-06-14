package kr.jaen.java.net.nested;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class  ChatClient2 extends Frame implements ActionListener{

	private TextArea ta=new TextArea();
	private TextField tf = new TextField();
	private Button b1=new Button("Send");
	private Button b2=new Button("Exit");
	private Panel p=new Panel();
	private Socket s =null;
	private ObjectOutputStream oos=null;
	private ObjectInputStream ois=null;

	private String ip;
	private int port;
	private String name;

	public ChatClient2(){
		createGUI();
	}
	//GUI �����ϰ� Event ���,ó��
	public void createGUI(){
		p.add(b1);
		p.add(b2);
		add( ta,"West" );
		add(p,"Center");
		
		add( tf, "South");
		
		tf.addActionListener( this );//Event ���
		setBounds( 200,200,500,400 );
		setVisible( true );
		b1.addActionListener(this);//Event ���
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
					System.exit(0);
		    }
		});
		
		addWindowListener( new WindowAdapter() {
				public void windowClosing( WindowEvent we ) {
					System.exit(0);
				}
		});
		
	}
	public  void go( String ip, int port, String name){
		this.ip = ip;
		this.port=port;
		this.name=name;

		try {
			//1. Socket ����
			s = new Socket( ip, port );
			ta.append("�������� ���� !!\n");
			//2. I/O stream ����
			oos = new ObjectOutputStream( s.getOutputStream() );
			ois = new ObjectInputStream( s.getInputStream() );
			ta.append("��Ʈ�� ���� ���� !!\n");
		//  Thread �����...
			t.start();
			
			ta.append("������ ���� ���� !!\n");
			tf.requestFocus();
		}catch(Exception e ){
			ta.append("������ ����������,IP��port�� �´��� Ȯ�� �ٶ��ϴ�.");
		}
	}

	Thread t=new Thread( ){
		public void run(){
			try{
			while( true ) {
				String msg = (String) ois.readObject();
				ta.append( msg +"\n" );
			}
			}catch(Exception e ) {
				ta.append("readObject()�� �����߻� : "+e.getMessage()+"\n");
			}
		}				
	};

	public void actionPerformed( ActionEvent ae ) {
		String msg = tf.getText();
		try{
			oos.writeObject( "["+name+"] "+msg );
		}catch( IOException ioe ) {
			System.out.println("�޼��� ������ �����߻� : "+ioe.getMessage());
			System.exit(0);
		}
		tf.setText("");
	}
	public static void main(String[] args) 	{
		String ip = "127.0.0.1";
		int port = 5500;
		String name = "userID";

		//ChatClient cc=new ChatClient();
		//cc.go( ip,port,name );
		new ChatClient2().go( ip,port,name );
	}

}//outer










