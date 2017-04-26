package javaBase.reflect.proxyReflect;

/**
 * @Description : 目标代理具体实现
 * @Date: 2017年4月26日 下午10:07:38
 */
public class RealSubject implements Subject {
    public String say(String name, int age) {
        return name + "  " + age;
    }

	@Override
	public void see() {
		System.out.println("---------see--------");
		
	}
}
