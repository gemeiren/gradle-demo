package jarTool.okHttp;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.CacheControl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import com.alibaba.fastjson.JSON;

/**
 * @Description: http://www.tuicool.com/articles/rArq63u
 * @date 2017年1月3日 下午5:31:11
 */
public class okhttpTest {
	public static void main(String[] args) {
		String url = "http://10.197.157.122/newSchedule/handlePayRefund";
		String result = null ;
		/*try {
			result = httpGet(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("result : " + JSON.toJSONString(result));*/
		
		testdrlyApi();
	}
	
	private static void testdrlyApi() {
		MediaType JSON_MEDIA_TYPE = MediaType.parse("application/json; charset=utf-8");
		OkHttpClient okhttpClient = new OkHttpClient();
		String apiUrl = "http://log-gd6.com";
		/*String requestContent = objectMapper.writeValueAsString(value);
		private DragonflyAppModel app;
		private Integer size;
		private DragonflyQueryModel query;
		private List<String> fields;*/
		Map<String, Object> requ = new HashMap<String, Object>(); 
		Map<Object, Object> app = new HashMap<Object, Object>();
		app.put("name", "log");
		app.put("key", "4078c84f211fa212a63edf0f3b582291");
		
		Map<Object, Object> query = new HashMap<Object, Object>();
		query.put("queryString", "58147443 AND add");
		
		requ.put("app", app);
		requ.put("size", 100);
		requ.put("query", query);
		
		System.out.println("requ --------- " + requ);
		System.out.println("requ toString --------- " + requ.toString());
		
		Request request = new Request.Builder().cacheControl(CacheControl.FORCE_NETWORK).url(apiUrl)
				.post(RequestBody.create(JSON_MEDIA_TYPE, requ.toString())).build();
		
		try {
			Response response = okhttpClient.newCall(request).execute();
			System.out.println("response-- " + JSON.toJSONString(response));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	
	static OkHttpClient client = new OkHttpClient();

	//HTTP GET
	static String httpGet(String url) throws IOException {
		Request request = new Request.Builder().url(url).build();
		Response response = client.newCall(request).execute();
		if (response.isSuccessful()) {
			return response.body().string();
		} else {
			throw new IOException("Unexpected code " + response);
		}
	}
	
	//HTTP POST   POST提交Json数据
	public static final MediaType JSONFORMAT = MediaType.parse("application/json; charset=utf-8");
	//OkHttpClient client = new OkHttpClient();
	static String httpPost(String url, String json) throws IOException {
	 	RequestBody body = RequestBody.create(JSONFORMAT, json);
	  	Request request = new Request.Builder()
		  .url(url)
		  .post(body)
		  .build();
	  	Response response = client.newCall(request).execute();
		if (response.isSuccessful()) {
			return response.body().string();
		} else {
			throw new IOException("Unexpected code " + response);
		}
	}
	
	
	/*String httpPostV2(String url, String json) throws IOException {

	 	RequestBody formBody = new FormEncodingBuilder()
		.add("platform", "android")
		.add("name", "bug")
		.add("subject", "XXXXXXXXXXXXXXX")
		.build();

	  	Request request = new Request.Builder()
	      .url(url)
	      .post(body)
	      .build();

	  	Response response = client.newCall(request).execute();
		if (response.isSuccessful()) {
		    return response.body().string();
		} else {
		    throw new IOException("Unexpected code " + response);
		}
	}*/
	
}
