package jarTool.poiExcel;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/** 
 * @Description: http://www.cnblogs.com/LiZhiW/p/4313789.html?utm_source=tuicool&utm_medium=referral
 * @date 2017年1月17日  上午11:05:37
 */
public class Test00 {
	
	//2.Excel的基本操作   (1)创建Workbook和Sheet
	public static void main(String[] args) throws IOException
	{
		//String filePath="d:\\users\\lizw\\桌面\\POI\\sample.xls";//文件路径
		String filePath= "D:\\Users\\Desktop\\sample.xls";
		HSSFWorkbook workbook = new HSSFWorkbook();//创建Excel文件(Workbook)
		HSSFSheet sheet = workbook.createSheet();//创建工作表(Sheet)
		sheet = workbook.createSheet("Test");//创建工作表(Sheet)
		FileOutputStream out = new FileOutputStream(filePath);
		workbook.write(out);//保存Excel文件
		out.close();//关闭文件流
		System.out.println("OK!");
	}
}
