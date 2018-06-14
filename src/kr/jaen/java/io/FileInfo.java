package kr.jaen.java.io;
/*
** File Name ���� 
String getName() : file �̸� �������� 
String getPath() : path �̸� �������� 
String getAbsolutePath() : ���� path �������� 
String getParent() : parent directoy �̸� �������� 
boolean renameTo(File newName) : �ٸ� �̸����� �ٲٱ� 
 
** File Testing 
boolean exists() : �����ϴ��� Ȯ�� 
boolean canWrite() : �� �� �ִ��� Ȯ�� 
boolean canRead() : ���� �� �ִ��� Ȯ�� 
boolean isFIle() : file ���� Ȯ�� 
boolean isDirectory() : directory ���� Ȯ�� 
 
** Directory ���� 
boolean mkdir() : sub directory ���� 
String[] list() : ���� diretory�� �ִ� ��ü file list�� return 

** �׿��� �޼ҵ� 
long lastModified() : ������ ������ ��¥ 
long length() : ũ�� �˷��ֱ� 
boolean delete() : �����ϱ� */
 
import java.io.*;

class FileInfo {
   public static void main(String arg[])throws Exception {

      File file = new File("Data.txt");
      if (file.exists()) {
        System.out.println("���� �̸� : " + file.getName());
		System.out.println("��� �н� : " + file.getPath());
		System.out.println("���� �н� : " + file.getAbsolutePath());

		System.out.println("���� ���� : " + file.canWrite());
		System.out.println("�б� ���� : " + file.canRead());
		System.out.println("���� ���� : " + file.length() + " ����Ʈ");
      }else {
         System.out.println("File not found");
      }          
   }
}
 