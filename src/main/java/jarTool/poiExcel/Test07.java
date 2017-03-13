package jarTool.poiExcel;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/** 
 * @Description: 描述 
 * @date 2017年1月17日  上午11:05:37
 */
public class Test07 {
	
	//(3)单元格对齐
	public static void main(String[] args) throws IOException
	{
		//String filePath="d:\\users\\lizw\\桌面\\POI\\sample.xls";//文件路径
		String filePath= "D:\\Users\\Desktop\\sample07.xls";
		HSSFWorkbook workbook = new HSSFWorkbook();//创建Excel文件(Workbook)
//		HSSFSheet sheet = workbook.createSheet();//创建工作表(Sheet)
//		sheet = workbook.createSheet("Test");//创建工作表(Sheet)
		
		
		HSSFSheet sheet = workbook.createSheet("Test");// 创建工作表(Sheet)
		HSSFRow row=sheet.createRow(0);
		
		HSSFCell cell=row.createCell(0);
		cell.setCellValue("单元格对齐");
		HSSFCellStyle style=workbook.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平居中
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中
		style.setWrapText(true);//自动换行
		style.setIndention((short)5);//缩进
		style.setRotation((short)60);//文本旋转，这里的取值是从-90到90，而不是0-180度。
		cell.setCellStyle(style);   
		
		FileOutputStream out = new FileOutputStream(filePath);
		workbook.write(out);//保存Excel文件
		out.close();//关闭文件流
		System.out.println("OK!");
	}
}
