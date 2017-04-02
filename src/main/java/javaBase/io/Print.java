package javaBase.io;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * http://www.cnblogs.com/jianmang/articles/4909784.html
 * @Description : 三、字符流（顾名思义，就是操作字符文件的流）
 * @Date: 2017年4月2日 上午10:38:28
 */
public class Print {
	  
	/** 
	 * @param args 
	 */  
	public static void main(String[] args) {  
	    // TODO自动生成的方法存根  
	    char[] buffer=new char[512];   //一次取出的字节数大小,缓冲区大小  
	    int numberRead=0;  
	    FileReader reader=null;        //读取字符文件的流  
	    PrintWriter writer=null;    //写字符到控制台的流  
	     
	    try {  
	       reader=new FileReader("E:/copy1.txt");  
	       writer=new PrintWriter(System.out);  //PrintWriter可以输出字符到文件，也可以输出到控制台  
	       while ((numberRead=reader.read(buffer))!=-1) {  
	          writer.write(buffer, 0, numberRead);  
	       }  
	    } catch (IOException e) {  
	       // TODO自动生成的 catch 块  
	       e.printStackTrace();  
	    }finally{  
	       try {  
	          reader.close();  
	       } catch (IOException e) {  
	          // TODO自动生成的 catch 块  
	          e.printStackTrace();  
	       }  
	       writer.close();       //这个不用抛异常  
	    }  
	        
	}  
}
