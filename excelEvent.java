package awardproject.view;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * 
 * @author 张磊
 *从excel中读取指定数据
 */

public class excelEvent {

	public static List getExcel(String file) {
		//List用来存储读取的数据
		List list = new ArrayList();
		try {
			Workbook rwb = Workbook.getWorkbook(new File(file));
			Sheet rs = rwb.getSheet(0);
			int clos = rs.getColumns();
			int rows = rs.getRows();
			
			for(int i = 1 ; i < rows ; i++) {
				String id = rs.getCell(4, i).getContents();
				list.add(id);
			}
			
			for(int i = 1 ; i < rows ; i++) {
				String name = rs.getCell(5, i).getContents();
				list.add(name);
			}
			
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static void main(String[] args) {
		List list = excelEvent.getExcel("F:\\信计花名册.xls");
		System.out.println(list.size());
		for (Object object : list) {
			System.out.println(object);
		}
	}
	}
