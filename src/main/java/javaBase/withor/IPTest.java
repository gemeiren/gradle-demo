package javaBase.withor;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import com.alibaba.fastjson.JSON;

/** 
 * @Description: 获取本地机器地址信息
 * @date 2016年2月25日  上午11:35:36
 */
public class IPTest {

	public static void main(String[] args) {
		System.out.println("开始");
		getLocalAddresses();
		//System.out.println(JSON.toJSON(getLocalAddresses()));
		System.out.println("结束");
	}
	
	public static  List<InetAddress> getLocalAddresses(){
		
		List<InetAddress> localAddressList = null ;
		
		if(localAddressList == null){
			localAddressList = new ArrayList<InetAddress>();
			try {
				//获取可用的网络接口
				Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
				
				System.out.println("网络接口interfaces");
				while (interfaces != null && interfaces.hasMoreElements()) {
					//System.out.println("网络接口 != null");
					NetworkInterface interfaceN = interfaces.nextElement();
					//获取网络接口上的网络地址
					Enumeration<InetAddress> ienum = interfaceN.getInetAddresses();
					
					while (ienum.hasMoreElements()) {
						InetAddress ia = ienum.nextElement();
						//添加网络地址到本机网络地址列表
						System.out.println("添加网络地址到本机网络地址列表="+ia+" Index:"+interfaceN.getIndex());
						localAddressList.add(ia);
					}
				}
				//重新再获取一个网络接口对象
				System.out.println("网络接口interfaces="+JSON.toJSONString(NetworkInterface.getNetworkInterfaces()));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return localAddressList;
	}

}
