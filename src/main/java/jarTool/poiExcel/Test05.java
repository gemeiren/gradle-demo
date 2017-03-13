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

/** 
 * @Description: 描述 
 * @date 2017年1月17日  上午11:05:37
 */
public class Test05 {
	
	//3.Excel的单元格操作  (1)设置格式
	public static void main(String[] args) throws IOException
	{
		//String filePath="d:\\users\\lizw\\桌面\\POI\\sample.xls";//文件路径
		String filePath= "D:\\Users\\Desktop\\sample05.xls";
		HSSFWorkbook workbook = new HSSFWorkbook();//创建Excel文件(Workbook)
//		HSSFSheet sheet = workbook.createSheet();//创建工作表(Sheet)
//		sheet = workbook.createSheet("Test");//创建工作表(Sheet)
		
		
		HSSFSheet sheet = workbook.createSheet("Test");// 创建工作表(Sheet)
		HSSFRow row=sheet.createRow(0);
		//设置日期格式--使用Excel内嵌的格式
		HSSFCell cell=row.createCell(0);
		cell.setCellValue(new Date());
		HSSFCellStyle style=workbook.createCellStyle();
		style.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));
		cell.setCellStyle(style);
		//设置保留2位小数--使用Excel内嵌的格式
		cell=row.createCell(1);
		cell.setCellValue(12.3456789);
		style=workbook.createCellStyle();
		style.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
		cell.setCellStyle(style);
		//设置货币格式--使用自定义的格式
		cell=row.createCell(2);
		cell.setCellValue(12345.6789);
		style=workbook.createCellStyle();
		style.setDataFormat(workbook.createDataFormat().getFormat("￥#,##0"));
		cell.setCellStyle(style);
		//设置百分比格式--使用自定义的格式
		cell=row.createCell(3);
		cell.setCellValue(0.123456789);
		style=workbook.createCellStyle();
		style.setDataFormat(workbook.createDataFormat().getFormat("0.00%"));
		cell.setCellStyle(style);
		//设置中文大写格式--使用自定义的格式
		cell=row.createCell(4);
		cell.setCellValue(12345);
		style=workbook.createCellStyle();
		style.setDataFormat(workbook.createDataFormat().getFormat("[DbNum2][$-804]0"));
		cell.setCellStyle(style);
		//设置科学计数法格式--使用自定义的格式
		cell=row.createCell(5);
		cell.setCellValue(12345);
		style=workbook.createCellStyle();
		style.setDataFormat(workbook.createDataFormat().getFormat("0.00E+00"));
		cell.setCellStyle(style);
		
		
		FileOutputStream out = new FileOutputStream(filePath);
		workbook.write(out);//保存Excel文件
		out.close();//关闭文件流
		System.out.println("OK!");
	}
}
