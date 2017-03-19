package jarTool.json;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

/** 
 * @Description: 创建简单的json 
 * @date 2016年2月18日  上午10:52:19
 */
public class JsonStringTest {
	public static void main(String[] args) {//createJsonString
		
		    JSONObject jsonObj = new JSONObject();
		    Map<String, String> ingredients = new HashMap<String, String>();
		    ingredients.put("orderNo", "2016111111");
		    jsonObj.put("new_info", ingredients);
		    jsonObj.put("new_seq", "11111");
		    jsonObj.put("detail", "11111");
		    jsonObj.put("request", "11111");
		    
		    Map<String,Object> tempMap1 = new HashMap<String,Object>();
		    tempMap1.put("level", 6);
		    tempMap1.put("reason", "通过");
		    jsonObj.put("result", tempMap1);
		    
		    Map<String,Object> tempMap2 = new HashMap<String,Object>();
		    tempMap2.put("errorCode", "errorCode1111");
		    tempMap2.put("reason", "风险单哦干掉它");
		    jsonObj.put("error", tempMap2);
		    
		    System.out.println("jsonObj.toString()="+jsonObj.toString());
		 
	}

}
