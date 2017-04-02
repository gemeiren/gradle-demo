package javaBase.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * http://www.cnblogs.com/jianmang/articles/4909784.html
 * @Description : 二、字节流:
1.字节流有输入和输出流，我们首先看输入流InputStream,我们首先解析一个例子（FileInputStream）。
 * @Date: 2017年4月2日 上午12:35:59
 */
public class FileCount {
	/** 
	    * 我们写一个检测文件长度的小程序，别看这个程序挺长的，你忽略try catch块后发现也就那么几行而已。 
	    */  
	   public static void main(String[] args) {  
	      //TODO 自动生成的方法存根  
	             int count=0;  //统计文件字节长度  
	      InputStream streamReader = null;   //文件输入流  
	      try{  
	          streamReader=new FileInputStream(new File("E:/create.jpg"));  
	          /*1.new File()里面的文件地址也可以写成E:\\create.jpg,前一个\是用来对后一个 
	           * 进行转换的，FileInputStream是有缓冲区的，所以用完之后必须关闭，否则可能导致内存占满，数据丢失。 
	          */  
	          while(streamReader.read()!=-1) {  //读取文件字节，并递增指针到下一个字节  
	             count++;  
	          }  
	          System.out.println("---长度是： "+count+" 字节");  
	      }catch (final IOException e) {  
	          //TODO 自动生成的 catch 块  
	          e.printStackTrace();  
	      }finally{  
	          try{  
	             streamReader.close();  
	          }catch (IOException e) {  
	             //TODO 自动生成的 catch 块  
	             e.printStackTrace();  
	          }  
	      }  
	   }  
}
