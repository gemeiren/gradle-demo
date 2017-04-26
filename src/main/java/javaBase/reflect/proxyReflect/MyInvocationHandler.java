package javaBase.reflect.proxyReflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description : 
 * @Date: 2017年4月26日 下午10:06:57
 */
class MyInvocationHandler implements InvocationHandler {
	
    private Object obj = null;
    
    public Object bind(Object obj) {
        this.obj = obj;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
    }
    
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    	System.out.println("---------------before");
    	
        Object temp = method.invoke(this.obj, args);
        
        System.out.println("---------------end");
        
        return temp;
    }
}
