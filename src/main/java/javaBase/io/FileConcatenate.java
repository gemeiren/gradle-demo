package javaBase.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * http://www.cnblogs.com/jianmang/articles/4909784.html
 * @Description : 
 * @Date: 2017年4月2日 上午10:42:31
 */
public class FileConcatenate {
	/** 
	   * 包装类进行文件级联操作 
	   */  
	  public static void main(String[] args) {  
	     // TODO自动生成的方法存根  
	     try {  
	        concennateFile(args); 
	        System.out.println("over");
	     } catch (IOException e) {  
	        // TODO自动生成的 catch 块  
	        e.printStackTrace();  
	     }  
	  }  
	  public static void concennateFile(String...fileName) throws IOException{  
	     String str;  
	     //构建对该文件您的输入流  
	     BufferedWriter writer=new BufferedWriter(new FileWriter("E:/copy2.txt"));  
	     for(String name: fileName){  
	        BufferedReader reader=new BufferedReader(new FileReader(name));  
	         
	        while ((str=reader.readLine())!=null) {  
	           writer.write(str);  
	           writer.newLine();  
	        }  
	     }  
	  }  
}
