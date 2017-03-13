package jarTool.poiExcel;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

/** 
 * @Description: 描述 
 * @date 2017年1月17日  上午11:05:37
 */
public class Test08 {
	
	//(4)使用边框
	public static void main(String[] args) throws IOException
	{
		//String filePath="d:\\users\\lizw\\桌面\\POI\\sample.xls";//文件路径
		String filePath= "D:\\Users\\Desktop\\sample08.xls";
		HSSFWorkbook workbook = new HSSFWorkbook();//创建Excel文件(Workbook)
//		HSSFSheet sheet = workbook.createSheet();//创建工作表(Sheet)
//		sheet = workbook.createSheet("Test");//创建工作表(Sheet)
		
		HSSFSheet sheet = workbook.createSheet("Test");// 创建工作表(Sheet)
		HSSFRow row=sheet.createRow(0);
		
		HSSFCell cell=row.createCell(1);
		cell.setCellValue("设置边框");
		HSSFCellStyle style=workbook.createCellStyle();
		style.setBorderTop(HSSFCellStyle.BORDER_DOTTED);//上边框
		style.setBorderBottom(HSSFCellStyle.BORDER_THICK);//下边框
		style.setBorderLeft(HSSFCellStyle.BORDER_DOUBLE);//左边框
		style.setBorderRight(HSSFCellStyle.BORDER_SLANTED_DASH_DOT);//右边框
		style.setTopBorderColor(HSSFColor.RED.index);//上边框颜色
		style.setBottomBorderColor(HSSFColor.BLUE.index);//下边框颜色
		style.setLeftBorderColor(HSSFColor.GREEN.index);//左边框颜色
		style.setRightBorderColor(HSSFColor.PINK.index);//右边框颜色
		cell.setCellStyle(style); 
		
		FileOutputStream out = new FileOutputStream(filePath);
		workbook.write(out);//保存Excel文件
		out.close();//关闭文件流
		System.out.println("OK!");
	}
}
