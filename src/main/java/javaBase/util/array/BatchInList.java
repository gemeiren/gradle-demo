package javaBase.util.array;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

/** 
 * @Description: list分页、分段、分割【非数据库、调用外部接口获取的数据分页】
 * @date 2017年3月23日  上午10:41:16
 */
public class BatchInList {
	
	public static void main(String[] args) {
		//1、模拟总数量【对象】
		List<String> orderSnList = new ArrayList<String>();
		for (int i = 0; i < 109; i++) {
			orderSnList.add("i-" + i);
		}
		//2、总数
		int count = orderSnList.size();

		//3、每页大小
		int limit = 50;
		System.out.println("count:"+count);
		if (count <= 0) {
			return;
		}
		
		//4、能分的页数
		int times = count % limit == 0 ? (count / limit) : (count / limit) + 1;
		
		System.out.println("times:" + times);
		
		
		if (times > 0) {
			//5、总数大于50
			for (int i = 0; i < times; i++) {
				
				int fromIndex = i * limit ;  //每页起始位置【0,50,100】
				int toIndex = ((i+1) * limit) > count ? count : ((i+1) * limit) ;//每页终止位置【50,100,109】
				
				int num = toIndex - fromIndex;//具体每页数量
				
				//每页具体内容
				//System.out.println("i == "+ orderSnList.subList(i * limit, ( ((i+1) * limit) > count ? count : ((i+1) * limit) )));
				System.out.println("i == "+ orderSnList.subList(fromIndex, toIndex));
				
			}
		} else {
			//6、总数小于50 【一页】
			System.out.println("orderSnList" + orderSnList);
		}
		
		
		
		List<String> orderSnList2 = new ArrayList<String>(); 
			if (CollectionUtils.isEmpty(orderSnList2)) 
			{
				System.out.println("in orderSnList2");
			}
		
	}
	
	
	
	
}
