package kr.jaen.java.thread.create;
import java.awt.*;
import java.awt.event.*;
class StringThread extends Frame implements Runnable{
	int x=300;
   public StringThread () {//������
	   createGUI(); //ȭ��
	  addEvent(); //�̺�Ʈ ó��
   }
   public void createGUI(){
	   setSize(300, 300); //ȭ�� ������
       setVisible(true); //�������
   }
   public void paint(Graphics  g) { //�׸�
       g.setColor(Color.red);
       g.fillOval(50, 50, 50, 50); //ä���� ���� �׷���
       g.setColor(Color.blue);
       g.drawString("How about my appearance", x, 280); //��
   }
   void addEvent() {
	addWindowListener(new WindowAdapter(){
		public void windowClosing(WindowEvent we){
			System.exit(0);
		}
	});
    addMouseListener( new MouseAdapter() { //Ŭ���ϴ� �ڸ��� ���� �׸�
        public void mousePressed(MouseEvent  e) {
           Graphics  g = getGraphics(); 
           g.setColor(Color.red);  
           g.fillOval(e.getX(),e.getY(), 50, 50);
        }
      }
    );
  }
   public static void main(String  arg[]) {
        StringThread st=new  StringThread();
		Thread th=new Thread(st);
		th.start();
   }
   public void run(){
	   while(x>=-150){
		   if(x==-150)
			   x=300;
		   x--;
		   repaint();
		   try{
			   Thread.sleep(15);
		   }catch(InterruptedException ie){
			   ie.printStackTrace();
		   }//end catch
	   }//end while
   }//end run
}