package javaBase.base64;

import sun.misc.BASE64Encoder;  

/**
 * @Description : https://blog.csdn.net/xuefeng0707/article/details/19845111
 * @Date: 2018年5月20日 下午9:30:05
 * 
 * Base64是网络上最常见的用于传输8Bit字节码的编码方式之一，
 * Base64就是一种基于64个可打印字符来表示二进制数据的方法
 * 
 * Base64一般用于在HTTP协议下传输二进制数据，
 * 由于HTTP协议是文本协议，
 * 所以在HTTP协议下传输二进制数据需要将二进制数据转换为字符数据。
 * 
 */
public class Base64TestV1 {  
  
    public static void main(String[] args) { 
    	
        BASE64Encoder encoder = new BASE64Encoder();  
        String s = "Xue";  
        String encoded = encoder.encode(s.getBytes());  
        System.out.println("Xue -> " + encoded);  
          
        s = "Xu";  
        encoded = encoder.encode(s.getBytes());  
        System.out.println("Xu -> " + encoded);  
          
        s = "X";  
        encoded = encoder.encode(s.getBytes());  
        System.out.println("X -> " + encoded);  
    }  
}  
