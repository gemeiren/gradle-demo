package javaBase.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * http://www.cnblogs.com/jianmang/articles/4909784.html
 * @Description : 打算将Member类实例的成员数据写入文件中，
 * 并打算在读入文件数据后，将这些数据还原为Member对象。
 * 下面的代码简单示范了如何实现这个需求。
 * @Date: 2017年4月2日 上午12:48:30
 */
public class DataStreamDemo {
	
	public static void main(String[] args) {
		
		Member[] members = { new Member("DASdtin", 32), new Member("GdDor", 45),
				new Member("AdFs", 63) };
		try {
			DataOutputStream dataOutputStream = new DataOutputStream(
					new FileOutputStream("E:/create2.txt"));

			for (Member member : members) {
				// 写入UTF字符串
				dataOutputStream.writeUTF(member.getName());
				// 写入int数据
				dataOutputStream.writeInt(member.getAge());
			}

			// 所有数据至目的地
			dataOutputStream.flush();
			// 关闭流
			dataOutputStream.close();

			DataInputStream dataInputStream = new DataInputStream(
					new FileInputStream("E:/create2.txt"));

			// 读出数据并还原为对象
			for (int i = 0; i < members.length; i++) {
				// 读出UTF字符串
				String name = dataInputStream.readUTF();
				System.out.println("i:" + i + ",name:" + name);
				// 读出int数据
				int score = dataInputStream.readInt();
				System.out.println("i:" + i + ",name:" + score);
				members[i] = new Member(name, score);
			}

			// 关闭流
			dataInputStream.close();

			// 显示还原后的数据
			for (Member member : members) {
				System.out
						.printf("%s\t%d%n", member.getName(), member.getAge());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
