package javaBase.util.array;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

/**
 * @Description: null与new数组的size
 * @date 2017年3月23日 下午3:29:05
 */
public class AddArrayTest {
	public static void main(String[] args) {
		List<String> orderSns = new ArrayList<String>();//null
		/*orderSns.add("1");
		orderSns.add("2");
		orderSns.add("3");*/
		
		System.out.println(".." + orderSns.size());
		List<String> orderSnList = new ArrayList<String>() ;
		if (orderSns.size() > 0) {
			orderSnList.addAll(orderSns);
		}
		System.out.println("orderSnList: " + orderSnList);
		
		System.out.println("--- "+ CollectionUtils.isEmpty(orderSnList));
		
		
		
	}
}
