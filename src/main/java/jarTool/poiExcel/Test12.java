package jarTool.poiExcel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DateUtil;

/** 
 * @Description: http://www.cnblogs.com/LiZhiW/p/4313789.html?utm_source=tuicool&utm_medium=referral 
 * @date 2017年1月17日  上午11:05:37
 */
public class Test12 {
	
	//(7)设置宽度和高度
	public static void main(String[] args) throws IOException
	{
		//String filePath="d:\\users\\lizw\\桌面\\POI\\sample.xls";//文件路径
		String filePath= "D:\\Users\\Desktop\\sample12.xls";
		HSSFWorkbook workbook = new HSSFWorkbook();//创建Excel文件(Workbook)
//		HSSFSheet sheet = workbook.createSheet();//创建工作表(Sheet)
//		sheet = workbook.createSheet("Test");//创建工作表(Sheet)
		
		HSSFSheet sheet = workbook.createSheet("Test");// 创建工作表(Sheet)
		HSSFRow row = sheet.createRow(1);
		HSSFCell cell = row.createCell(1);
		
		cell.setCellValue(new Date());//设置日期数据
		System.out.println(DateUtil.isCellDateFormatted(cell));//输出：false
		HSSFCellStyle style =workbook.createCellStyle();
		style.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));
		cell.setCellStyle(style);//设置日期样式
		System.out.println(DateUtil.isCellDateFormatted(cell));//输出：true
		
		FileOutputStream out = new FileOutputStream(filePath);
		workbook.write(out);//保存Excel文件
		out.close();//关闭文件流
		System.out.println("OK!");
	}
}
