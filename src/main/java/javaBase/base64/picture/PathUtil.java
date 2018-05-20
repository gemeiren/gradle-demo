package javaBase.base64.picture;

public class PathUtil {

	/**
	  * 获取工程路径
	  * @param T
	  * @param projectName
	  * @return
	  */
	 public static String getProjectPath(Class<?> T,String projectName){
		 String path = T.getResource("/").toString();
	     System.out.println("path = " + path);
	     projectName = "bin";
	     System.out.println("indexOf 开始的字母位置 = " + path.indexOf(projectName));
//	     path = file:/D:/Developer/CODE/github_own/20170227/gradle-demo/bin/
//	    		 indexOf 开始的字母位置 = 56
	     
	     path = path.substring(0,path.indexOf(projectName))+projectName;
	     System.out.println("projectName - " + projectName);
	     System.out.println(path);
	     System.out.println("charAt(1) = " + path.charAt(1));
	     System.out.println("indexOf(\":\") = " + path.indexOf(":"));//4
	     path = path.substring(path.indexOf(":")+1, path.length());
	     System.out.println("path ------ " + path);// /D:/workspace2/zMP3
	  
	//  file:/D:/workspace2/zMP3/build/classes/
	//  zMP3
	//  file:/D:/workspace2/zMP3
	//  path+="/WEB-INF/classes/setting.properties";
		  path = path.replaceAll("%20", " ");
		  System.out.println(path);
		  return path;
	 }

}
