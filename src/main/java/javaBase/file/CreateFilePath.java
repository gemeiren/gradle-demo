package javaBase.file;

import java.io.File;

import com.alibaba.fastjson.JSON;


/**
 * @Description : https://blog.csdn.net/zhangxiaomin1992/article/details/50863988
 * @Date: 2018年5月12日 下午3:44:00
 */
public class CreateFilePath {
	//创建文件夹--单层  
	private static void CreateFile(String dir)  
	{  
	    try {  
	           File dirPath = new File(dir);  
	           if (!dirPath.exists()) {  
	               dirPath.mkdir();  
	           }  
	       } catch (Exception e) {  
	          System.out.println("创建目录操作出错: "+e.getMessage());  
	           e.printStackTrace();  
	       }  
	}  
	//创建文件夹--多层  
	private static boolean CreateMultilayerFile(String dir)  
	{  
	    try {  
	           File dirPath = new File(dir);  
	           if (!dirPath.exists()) {  
	               dirPath.mkdirs();  
	           }  
	       } catch (Exception e) {  
	          System.out.println("创建多层目录操作出错: "+e.getMessage());  
	          e.printStackTrace();  
	          return false;  
	       }  
	    return true;  
	}  
	  
	//新建文件  
	 public static void createNewFile(String path) {  
	        try {  
	            String[] lists=path.split("\\.");  //分 小数点 
	            int lastLength=lists[0].lastIndexOf("\\");  //目录长度
	            System.out.println("lists " + JSON.toJSONString(lists) + "  lastLength " + lastLength);
	            //lists ["e:\\a\\b\\a","txt"]  lastLength 6
	            //得到文件夹目录  
	            String dir=lists[0].substring(0, lastLength);  //文件目录
	            //得到文件名称  
	            String fileName=lists[0].substring(lastLength);//文件目录名称  
	            System.out.println("dir " + dir + "  fileName " + fileName);
	            //dir e:\a\b  fileName \a
	            //得到路径e:\a\b之后,先创建文件夹  
	            if(CreateMultilayerFile(dir)==true)  
	            {  
	                File filePath = new File(path);  
	                if (!filePath.exists()) {  
	                    filePath.createNewFile();  
	                }  
	            }  
	        } catch (Exception e) {  
	            System.out.println("新建文件操作出错: "+e.getMessage());  
	            e.printStackTrace();  
	        }  
	  
	  
	    }  
	public static void main(String[] args)   
	{  
	     // CreateFile("e:\\a");  
	     // CreateMultilayerFile("e:\\a\\b");  
	      createNewFile("e:\\a\\C\\B.txt");  
	}  
}
