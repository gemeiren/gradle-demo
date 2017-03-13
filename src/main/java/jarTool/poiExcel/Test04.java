package jarTool.poiExcel;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFFooter;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/** 
 * @Description: 描述 
 * @date 2017年1月17日  上午11:05:37
 */
public class Test04 {
	
	//(5)创建页眉和页脚
	public static void main(String[] args) throws IOException
	{
		//String filePath="d:\\users\\lizw\\桌面\\POI\\sample.xls";//文件路径
		String filePath= "D:\\Users\\Desktop\\sample04.xls";
		HSSFWorkbook workbook = new HSSFWorkbook();//创建Excel文件(Workbook)
//		HSSFSheet sheet = workbook.createSheet();//创建工作表(Sheet)
//		sheet = workbook.createSheet("Test");//创建工作表(Sheet)
		
		HSSFSheet sheet = workbook.createSheet("Test");// 创建工作表(Sheet)
		HSSFHeader header =sheet.getHeader();//得到页眉
		header.setLeft("页眉左边");
		header.setRight("页眉右边");
		header.setCenter("页眉中间");
		HSSFFooter footer =sheet.getFooter();//得到页脚
		footer.setLeft("页脚左边");
		footer.setRight("页脚右边");
		footer.setCenter("页脚中间");
		
		FileOutputStream out = new FileOutputStream(filePath);
		workbook.write(out);//保存Excel文件
		out.close();//关闭文件流
		System.out.println("OK!");
	}
}
