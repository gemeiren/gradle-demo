package javaBase.Path;

import java.io.IOException;

/**
 * @Description : 测试path路径
 * @Date: 2017年4月30日 下午3:12:57
 */
public class testPath {
	public static void main(String[] args) {
		Path path = new Path();
		 try {
			System.out.println("-----: "+ path.getPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
