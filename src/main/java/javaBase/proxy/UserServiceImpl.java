package javaBase.proxy;
/**
 * http://rejoy.iteye.com/blog/1627405
 * @Description : 目标对象
 * @Date: 2017年4月26日 下午10:04:08
 */
public class UserServiceImpl  implements UserService {  
  
     
    /* (non-Javadoc)
     * @see javaBase.proxy.UserService#add()
     */
    public void add() { 
        System.out.println("----------UserServiceImpl----------add---------------");  
    }  
}  
