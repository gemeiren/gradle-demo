package jarTool.poiExcel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/** 
 * @Description: http://www.cnblogs.com/LiZhiW/p/4313789.html?utm_source=tuicool&utm_medium=referral 
 * @date 2017年1月17日  上午11:05:37
 */
public class Test01 {
	
	
	//(2)创建单元格
	public static void main(String[] args) throws IOException
	{
		//String filePath="d:\\users\\lizw\\桌面\\POI\\sample.xls";//文件路径
		String filePath= "D:\\Users\\Desktop\\sample01.xls";
		HSSFWorkbook workbook = new HSSFWorkbook();//创建Excel文件(Workbook)
//		HSSFSheet sheet = workbook.createSheet();//创建工作表(Sheet)
//		sheet = workbook.createSheet("Test");//创建工作表(Sheet)
		
		HSSFSheet sheet = workbook.createSheet("Test");// 创建工作表(Sheet)
		HSSFRow row = sheet.createRow(0);// 创建行,从0开始
		HSSFCell cell = row.createCell(0);// 创建行的单元格,也是从0开始
		cell.setCellValue("李志伟");// 设置单元格内容
		row.createCell(1).setCellValue(false);// 设置单元格内容,重载
		row.createCell(2).setCellValue(new Date());// 设置单元格内容,重载
		row.createCell(3).setCellValue(12.345);// 设置单元格内容,重载
		
		
		FileOutputStream out = new FileOutputStream(filePath);
		workbook.write(out);//保存Excel文件
		out.close();//关闭文件流
		System.out.println("OK!");
	}
}
