package jarTool.poiExcel;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.record.cf.FontFormatting;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

/** 
 * @Description: 描述 
 * @date 2017年1月17日  上午11:05:37
 */
public class Test09 {
	
	//(5)设置字体
	public static void main(String[] args) throws IOException
	{
		//String filePath="d:\\users\\lizw\\桌面\\POI\\sample.xls";//文件路径
		String filePath= "D:\\Users\\Desktop\\sample09.xls";
		HSSFWorkbook workbook = new HSSFWorkbook();//创建Excel文件(Workbook)
//		HSSFSheet sheet = workbook.createSheet();//创建工作表(Sheet)
//		sheet = workbook.createSheet("Test");//创建工作表(Sheet)
		
		HSSFSheet sheet = workbook.createSheet("Test");// 创建工作表(Sheet)
		HSSFRow row=sheet.createRow(0);
		
		HSSFCell cell=row.createCell(1);
		cell.setCellValue("设置字体");
		HSSFCellStyle style = workbook.createCellStyle();
		HSSFFont font = workbook.createFont();
		font.setFontName("华文行楷");//设置字体名称
		font.setFontHeightInPoints((short)28);//设置字号
		font.setColor(HSSFColor.RED.index);//设置字体颜色
		font.setUnderline(FontFormatting.U_SINGLE);//设置下划线
		font.setTypeOffset(FontFormatting.SS_SUPER);//设置上标下标
		font.setStrikeout(true);//设置删除线
		style.setFont(font);
		cell.setCellStyle(style);
		//cell.setCellStyle(style); 
		
		FileOutputStream out = new FileOutputStream(filePath);
		workbook.write(out);//保存Excel文件
		out.close();//关闭文件流
		System.out.println("OK!");
	}
}
