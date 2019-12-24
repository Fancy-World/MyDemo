package random.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 一个用于处理用处输入的excel的类
 * 借助于jar包处理excel文件中的数据
 * 返回值：一个存放着所有学生名单的List。
 * @author lxw
 *
 */
public class HandleExcel {
	Workbook workBook;
	public  List<String> handleExcel(String path) {
		List<String> list =null;
		try {
			InputStream fis = new FileInputStream(path);
			int idx = path.lastIndexOf('.');
			String extensionName = path.substring(idx+1);
			workBook = null;
			//根据给****Workbook传入一个输入流，得到workbook实例（可以抽象的理解为是一个excel文档）
			if(extensionName.equals("xls")) {
				//如果用户上传的excel文件是xls格式的，使用HSSFWorkbook类
				workBook = new HSSFWorkbook(fis);
			}else {
				//用户上传的是扩展名为：xlsx格式的文件，使用XSSFWorkbook类
				workBook = new XSSFWorkbook(fis);
			}
			list = getStudent();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//获得行
	List<String> getStudent() {
		//确定学号和姓名的位置(列号)
		int indexStuNum = -1;
		int indexName = -1;
		//获得excel表
		Sheet sheet = workBook.getSheetAt(0);
		//获得第一行
		Row row1 = sheet.getRow(0);
		int flag = -1;//记录列值
		//遍历表的第一行，获得姓名和学号的列号，方便精准读取。
		for(Cell cell : row1) {
			cell.setCellType(CellType.STRING);
			//获得姓名列和学号列的值。
			if("姓名".equals(cell.getStringCellValue())){
				indexName = cell.getColumnIndex();
			}
			if(("学号").equals(cell.getStringCellValue())){
				indexStuNum = cell.getColumnIndex();
			}
		}
		System.out.println("学号位置："+indexStuNum+"姓名位置:"+indexName);
		//定义一个用于保存学生姓名的列表
		List<String> list= new ArrayList<String>();
		for(Row row : sheet) {
			if(row.getRowNum()==0) {
				continue;
			}
			Cell cell =row.getCell(indexName);
			cell.setCellType(CellType.STRING);
			list.add(cell.getStringCellValue());
		}
		return list;
	}
	
	//获得excel总行数
	public int getSumNum() {
		Sheet sheet = workBook.getSheetAt(0);
		int sumNum = sheet.getLastRowNum();
		return sumNum;
	}
	
//测试用
//	public static void main(String args[] ) {   
//		HandleExcel handleExcel1 = new HandleExcel();
//		handleExcel1.handleExcel("F:\\MyJsp\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\Random_row_call\\upload\\新的Excel.xlsx");
//		System.out.println("总的行数为:"+handleExcel1.getSumNum());
//	}
	
}
