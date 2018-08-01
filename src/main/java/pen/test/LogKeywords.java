package pen.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 * @Description : https://blog.csdn.net/abysscarry/article/details/80891128
 *  根据关键字读取日志文件，按出现次数排序打印关键字（java实现）
 * @Date: 2018年7月31日 下午11:27:43
 */
public class LogKeywords {
	public static void main(String[] args) throws Exception {
		File file = new File("src/main/java/test/sys_info.log");

        System.out.println("请输入关键字：（以空格为间隔）");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] keywords = input.split(" ");

        long start = System.currentTimeMillis();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        System.out.println(Arrays.toString(keywords));

        //该map的key为关键字，value为关键字出现次数
        Map<String, Integer> map = new HashMap<String, Integer>();

        String result = null;
        //按行读取日志文件，对每一行分别计算关键字次数，累加进map
        while((result = bufferedReader.readLine()) != null){
            for(int i = 0; i < keywords.length; i++ ){
                //通过split方法实现搜索关键字次数功能
                int count = (result.split(keywords[i])).length - 1;
                map.put(keywords[i], (map.get(keywords[i]) == null ? 0 : map.get(keywords[i])) + count);
            }
        }

        //将上面map的每个Entry存入list
        ArrayList<Map.Entry<String, Integer>> entryArrayList = new ArrayList<Map.Entry<String, Integer>>();

        for (Map.Entry<String, Integer> m : map.entrySet()){
            entryArrayList.add(m);
        }

        //自定义list的比较器，根据value从大到小排列Entry元素
        Collections.sort(entryArrayList, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        for (Map.Entry<String, Integer> m : entryArrayList){
            System.out.println(m.getKey() + ":" + m.getValue());
        }

        long end = System.currentTimeMillis();
        System.out.println("搜索耗时：" + (end - start) + " ms");

    }
}
