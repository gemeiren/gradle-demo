package javaBase.Path;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 关于ClassLoader中getResource与getResourceAsStream的疑问
 * @Description : http://www.oschina.net/question/129471_34225
 * @Date: 2017年4月30日 下午3:11:59
 */
public class Path {
	
	public String getPath() throws IOException{
		
		InputStream is = this.getClass().getResourceAsStream("/a.txt");
		
		File file = new File(Path.class.getResource("/").getPath()+"/b.txt");
		
		OutputStream os = new FileOutputStream(file);
		int bytesRead = 0;
		byte[] buffer = new byte[8192];
		while ((bytesRead = is.read(buffer, 0, 8192)) != -1) {
		os.write(buffer, 0, bytesRead);
		}
		os.close();
		is.close();
		
		return this.getClass().getResource("/").getPath();
	}
}
