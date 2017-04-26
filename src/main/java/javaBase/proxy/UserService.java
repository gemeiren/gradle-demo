package javaBase.proxy;
/**
 * http://rejoy.iteye.com/blog/1627405
 * @Description : 目标对象实现的接口，用JDK来生成代理对象一定要实现一个接口 
 * @Date: 2017年4月26日 下午10:03:33
 */
public interface UserService {
	/** 
     * 目标方法  
     */  
    public abstract void add(); 
}
