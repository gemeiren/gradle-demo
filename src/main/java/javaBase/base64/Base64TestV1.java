package javaBase.base64;

import sun.misc.BASE64Encoder;  

/**
 * @Description : https://blog.csdn.net/xuefeng0707/article/details/19845111
 * @Date: 2018年5月20日 下午9:30:05
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
