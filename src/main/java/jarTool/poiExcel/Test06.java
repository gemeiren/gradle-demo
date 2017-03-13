package jarTool.poiExcel;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;

/** 
 * @Description: 描述 
 * @date 2017年1月17日  上午11:05:37
 */
public class Test06 {
	
	//(2)合并单元格
	public static void main(String[] args) throws IOException
	{
		//String filePath="d:\\users\\lizw\\桌面\\POI\\sample.xls";//文件路径
		String filePath= "D:\\Users\\Desktop\\sample06.xls";
		HSSFWorkbook workbook = new HSSFWorkbook();//创建Excel文件(Workbook)
//		HSSFSheet sheet = workbook.createSheet();//创建工作表(Sheet)
//		sheet = workbook.createSheet("Test");//创建工作表(Sheet)
		
		
		HSSFSheet sheet = workbook.createSheet("Test");// 创建工作表(Sheet)
		HSSFRow row=sheet.createRow(0);
		//合并列
		HSSFCell cell=row.createCell(0);
		cell.setCellValue("合并列");
		CellRangeAddress region=new CellRangeAddress(0, 0, 0, 5);
		sheet.addMergedRegion(region);
		//合并行
		cell=row.createCell(6);
		cell.setCellValue("合并行");
		region=new CellRangeAddress(0, 5, 6, 6);
		sheet.addMergedRegion(region);
		
		
		FileOutputStream out = new FileOutputStream(filePath);
		workbook.write(out);//保存Excel文件
		out.close();//关闭文件流
		System.out.println("OK!");
	}
}
