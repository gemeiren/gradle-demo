package javaBase.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * http://www.cnblogs.com/jianmang/articles/4909784.html
 * @Description : 2.FileOutputStream 循序渐进版， InputStream是所有字节输出流的父类，子类有 ByteArrayOutputStream,FileOutputStream,ObjectOutputStreanm,这些我们在后面都会一一说 到。先说FileOutputStream
 * @Date: 2017年4月2日 上午12:40:43
 */
public class FileCopy {
	 public static void main(String[] args) {  
	     // TODO自动生成的方法存根  
	     byte[] buffer=new byte[512];   //一次取出的字节数大小,缓冲区大小  
	     int numberRead=0;  
	     FileInputStream input=null;  
	     FileOutputStream out =null;  
	     try {  
	        input=new FileInputStream("E:/create.jpg");  
	        out=new FileOutputStream("E:/create2.jpg"); //如果文件不存在会自动创建  
	         
	        while ((numberRead=input.read(buffer))!=-1) {  //numberRead的目的在于防止最后一次读取的字节小于buffer长度，  
	           out.write(buffer, 0, numberRead);       //否则会自动被填充0  
	        }  
	     } catch (final IOException e) {  
	        // TODO自动生成的 catch 块  
	        e.printStackTrace();  
	     }finally{  
	        try {  
	           input.close();  
	           out.close();  
	        } catch (IOException e) {  
	           // TODO自动生成的 catch 块  
	           e.printStackTrace();  
	        }  
	         
	     }  
	  }  
}
