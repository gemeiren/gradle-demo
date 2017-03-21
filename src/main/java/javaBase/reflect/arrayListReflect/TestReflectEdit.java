package javaBase.reflect.arrayListReflect;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.*;

/**
 * http://www.cnblogs.com/lzq198754/p/5780331.html
 * 通过反射取得并修改数组的信息
 * @Description : 
 * @Date: 2017年3月21日 下午12:51:24
 */ 

public class TestReflectEdit {
	public static void main(String[] args) throws Exception {
        int[] temp = { 1, 2, 3, 4, 5 };
        Class<?> demo = temp.getClass().getComponentType();
        System.out.println("数组类型： " + demo.getName());
        System.out.println("数组长度  " + Array.getLength(temp));
        System.out.println("数组的第一个元素: " + Array.get(temp, 0));
        Array.set(temp, 0, 100);
        System.out.println("修改之后数组第一个元素为： " + Array.get(temp, 0));
    }
}
