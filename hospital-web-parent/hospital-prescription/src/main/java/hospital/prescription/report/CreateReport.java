package hospital.prescription.report;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.*;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class CreateReport {
	/**
     * 新建Excel文件，New Workbook
     * @param excelType 可为null，Excel版本，可为2003（.xls）或者2007（.xlsx）,默认为2003版本
     * @param sheetName 新建表单名称
     * @param headList 表头List集合
     * @param dataList 数据List<List<集合>>(行<列>)
     * @param path 新建excel路径
     * @return
     */
    public static boolean createWorkBook(String excelType, String sheetName, 
    		List<String> headList,
    		List<List<String>> dataList, HttpServletResponse response, String fileName){
    	 //清空response
        response.reset();
        //设置response的Header
        OutputStream os = null;
		try {
			response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName,"UTF-8"));
			os = new BufferedOutputStream(response.getOutputStream());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        response.setContentType("application/vnd.ms-excel;charset=gb2312");
        Workbook wb = null;
        /*创建文件*/
        if (excelType == null || excelType.endsWith("2003")) {
            /*操作Excel2003以前（包括2003）的版本，扩展名是.xls */
            wb = new HSSFWorkbook();
        }else if (excelType.endsWith("2007")){
            /*XSSFWorkbook:是操作Excel2007的版本，扩展名是.xlsx */
            wb = new XSSFWorkbook();
        }else {   //默认为2003版本
            /*操作Excel2003以前（包括2003）的版本，扩展名是.xls */
            wb = new HSSFWorkbook();
        }
        /*Excel文件创建完毕*/
        CreationHelper createHelper = wb.getCreationHelper();  //创建帮助工具

        /*创建表单*/
        Sheet sheet = wb.createSheet(sheetName!=null?sheetName:"new sheet");
        // Note that sheet name is Excel must not exceed 31 characters（注意sheet的名字的长度不能超过31个字符，若是超过的话，会自动截取前31个字符）
        // and must not contain any of the any of the following characters:（不能包含下列字符）
        // 0x0000  0x0003  colon (:)  backslash (\)  asterisk (*)  question mark (?)  forward slash (/)  opening square bracket ([)  closing square bracket (])
        /*若是包含的话，会报错。但有一个解决此问题的方法，
        就是调用WorkbookUtil的createSafeSheetName(String nameProposal)方法来创建sheet name,
        若是有如上特殊字符，它会自动用空字符来替换掉，自动过滤。*/
        /*String safeName = WorkbookUtil.createSafeSheetName("[O'Brien's sales*?]"); // returns " O'Brien's sales   "过滤掉上面出现的不合法字符
        Sheet sheet3 = workbook.createSheet(safeName); //然后就创建成功了*/
        /*表单创建完毕*/

        //设置字体
        Font headFont = wb.createFont();
        headFont.setFontHeightInPoints((short)14);
        headFont.setFontName("Courier New");
        headFont.setItalic(false);
        headFont.setStrikeout(false);
        //设置头部单元格样式
        CellStyle headStyle = wb.createCellStyle();
        headStyle.setBorderBottom(BorderStyle.THICK);  //设置单元格线条
        headStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());   //设置单元格颜色
        headStyle.setBorderLeft(BorderStyle.THICK);
        headStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        headStyle.setBorderRight(BorderStyle.THICK);
        headStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
        headStyle.setBorderTop(BorderStyle.THICK);
        headStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
        headStyle.setAlignment(HorizontalAlignment.CENTER);    //设置水平对齐方式
        headStyle.setVerticalAlignment(VerticalAlignment.CENTER);  //设置垂直对齐方式
        //headStyle.setShrinkToFit(true);  //自动伸缩
        headStyle.setFont(headFont);  //设置字体
        /*设置数据单元格格式*/
        CellStyle dataStyle = wb.createCellStyle();
        dataStyle.setBorderBottom(BorderStyle.THIN);  //设置单元格线条
        dataStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());   //设置单元格颜色
        dataStyle.setBorderLeft(BorderStyle.THIN);
        dataStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        dataStyle.setBorderRight(BorderStyle.THIN);
        dataStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
        dataStyle.setBorderTop(BorderStyle.THIN);
        dataStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
        dataStyle.setAlignment(HorizontalAlignment.LEFT);    //设置水平对齐方式
        dataStyle.setVerticalAlignment(VerticalAlignment.CENTER);  //设置垂直对齐方式
        //dataStyle.setShrinkToFit(true);  //自动伸缩
        /*创建行Rows及单元格Cells*/
        Row headRow = sheet.createRow(0); //第一行为头
        for (int i=0;i<headList.size();i++){  //遍历表头数据
            Cell cell = headRow.createCell(i);  //创建单元格
            cell.setCellValue(createHelper.createRichTextString(headList.get(i)));  //设置值
            cell.setCellStyle(headStyle);  //设置样式
        }

        int rowIndex = 1;  //当前行索引
        //创建Rows
        for (List<String> rowdata : dataList){ //遍历所有数据
            Row row = sheet.createRow(rowIndex++); //第一行为头
            for (int j = 0;j< rowdata.size();j++){  //编译每一行
                Cell cell = row.createCell(j);
                cell.setCellStyle(dataStyle);
                cell.setCellValue(createHelper.createRichTextString(rowdata.get(j)));
            }
        }
        //汇总字段
        
        /*创建rows和cells完毕*/

        /*设置列自动对齐*/
        for (int i =0;i<headList.size();i++){
            sheet.autoSizeColumn(i);
        }
        try {
			wb.write(os);
			os.flush();
			os.close();
		} catch (IOException e) {
			return false;
		}
        return true;
    }
    
    public static void main(String[] args) {
//    	CreateReport report = new CreateReport();
//    	List<String> headList = Arrays.asList("序号","单号","药品名称","数量","采购成本");
//    	List<List<String>> dataList = new ArrayList<>();
//    	for (int i = 0; i < 10; i++) {
//			dataList.add(Arrays.asList("" + i,"1000" + i,"药品" + i,"" +i, "2.55"));
//		}
//    	report.createWorkBook(null, "test", headList, dataList, "c:/a.xls");
	}
}





