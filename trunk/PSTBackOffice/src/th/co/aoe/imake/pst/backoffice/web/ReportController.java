package th.co.aoe.imake.pst.backoffice.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import th.co.aoe.imake.pst.backoffice.service.PSTService;

@Controller
@RequestMapping(value={"/report"})
public class ReportController {
	 @Autowired
	 private PSTService pstService;
	 private static  SimpleDateFormat format = new SimpleDateFormat("MMM_yyyy");
	
	 private static  Locale locale = new Locale("th", "TH");
	 public static NumberFormat format_number = NumberFormat.getNumberInstance();
	 static{
		 format_number.setGroupingUsed(false);
		}
		// Locale.
	 private static ResourceBundle bundle;
		static{
				bundle =  ResourceBundle.getBundle( "config" );		
			
		}
	 private static final String SCHEMA= bundle.getString("schema");
	 @RequestMapping(value={"/init"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	 public String eptNormReport(Model model)
	    {
	     //   return "exam/template/empty";
	        return "backoffice/template/empty";
	    }
	 @RequestMapping(value={"/page/{pagename}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	 public String page(Model model,@PathVariable String pagename)
	    {
	       return "backoffice/template/"+pagename; 
	    }
	// @SuppressWarnings({ "deprecation", "unchecked" })
		@RequestMapping(value={"/export_report1"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	    public void export(HttpServletRequest request, HttpServletResponse response,Model model,SecurityContextHolderAwareRequestWrapper srequest)
	    {
			String time_from=request.getParameter("from");
			  Date d=null;
			  try {
				 d=format.parse(time_from);
				//System.out.println(d);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  DateTime dt = new DateTime(d);
			  int day_from=dt.getDayOfMonth();
			  int month= dt.getMonthOfYear();
			  int year= dt.getYear(); 
			  
			  int day_to=dt.dayOfMonth().getMaximumValue();
			 // System.out.println(dt.monthOfYear().getMaximumValue());
			 /* System.out.println(dt.getDayOfMonth());
			  System.out.println(dt.getMonthOfYear());
			  System.out.println(dt.getYear());
			  System.out.println("---------------------");
			  System.out.println(dt.dayOfMonth().getMaximumValue());
			  System.out.println(dt.getMonthOfYear());
			  System.out.println(dt.getYear());*/
		 //src=src+"?from="+time_from_array+"&to="+time_to_array;
		 
		 
		  
	    	//String time_to=request.getParameter("to");
	    	//String[] time_from_array=time_from.split("_");
	    	//String[] time_to_array=time_to.split("_");
	    	String from_sql=year+"-"+month+"-"+day_from+" 00:00:00";
	    	String to_sql=year+"-"+month+"-"+day_to+" 23:59:59";
	    	//2013-05-01 00:00:00
	    	// System.out.println(pstService);
	    	StringBuffer query=new StringBuffer();
	    	StringBuffer query_inner=new StringBuffer();
	    	StringBuffer query_inner_sum=new StringBuffer();
	    	query.append(" SELECT status.pes_id,status.pes_name FROM "+SCHEMA+".PST_EMPLOYEE_STATUS status order by status.pes_id");
	    	// String query1=
	    	 
	    	 
	        HSSFWorkbook wb = new HSSFWorkbook();
	     //   HSSFSheet sheet = wb.createSheet(time_from_array[0]+"/"+" ถึง "+time_to+"สรุปบันทึกการขาด ลา มาสาย พนง.");
	    ///    HSSFSheet sheet = wb.createSheet(time_from_array[0]+"-"+time_from_array[1]+"-"+time_from_array[2]+" ถึง "+time_to_array[0]+"-"+time_to_array[1]+"-"+time_to_array[2]);
	        HSSFSheet sheet = wb.createSheet("ค่าแรงพนักงานรายวัน");
	       
	      //  HSSFRow row = sheet.createRow(0);
	      //  HSSFCellStyle style = wb.createCellStyle(); 
	    	String[] label={"รหัสประจำตัว","เบอร์รถ","ชื่อ-สกุล","ตำแหน่ง","ค่าแรง/วัน"};
	        int indexRow = 2;  
		    HSSFCellStyle cellStyle = wb.createCellStyle();
		    HSSFCellStyle cellStyle2 = wb.createCellStyle();
		    HSSFCellStyle cellStyle3 = wb.createCellStyle();
		    cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		    cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		    cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		    cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		    cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		    cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN); 
		  
		    cellStyle.setFillBackgroundColor(new HSSFColor.GREY_25_PERCENT().getIndex());     
		    cellStyle.setWrapText(true);
		    
		    cellStyle2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		    cellStyle2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		    cellStyle2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		    cellStyle2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		    cellStyle2.setBorderRight(HSSFCellStyle.BORDER_THIN);
		    cellStyle2.setBorderTop(HSSFCellStyle.BORDER_THIN);
		    cellStyle2.setWrapText(true); 
		    
		    Font font = wb.createFont();
		    font.setFontHeightInPoints((short)13);
		    cellStyle2.setFont(font);
		    
		    cellStyle3.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		    cellStyle3.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		    cellStyle3.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		    cellStyle3.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		    cellStyle3.setBorderRight(HSSFCellStyle.BORDER_THIN);
		    cellStyle3.setBorderTop(HSSFCellStyle.BORDER_THIN);
		    cellStyle3.setWrapText(true); 
		   
		    sheet.addMergedRegion(new CellRangeAddress(
		            0, //first row (0-based)
		            0, //last row  (0-based)
		            2, //first column (0-based)
		            10  //last column  (0-based)
		    ));
		    HSSFRow row = sheet.createRow(0);
		    HSSFCell cell = row.createCell(2);
		   // cell = row.createCell(2);	    
		   //	cell.setCellValue("ค่าแรงพนักงานรายวัน  ประจำเดือน _____________________");
			cell.setCellValue("ค่าแรงพนักงานรายวัน  ประจำเดือน "+dt.monthOfYear().getAsText(locale)+" "+dt.year().getAsText());
		   	cell.setCellStyle(cellStyle2);
			cell = row.createCell(10);
			cell.setCellStyle(cellStyle);
		    row = sheet.createRow(indexRow);
			int index=0;
					//Header 5
				  /*  HSSFRow row = sheet.createRow(indexRow);
				    HSSFCell cell = row.createCell(0);
				   int index=0;
				   รหัสประจำตัว
				   เบอร์รถ*/
			 for(int i=0;i<label.length;i++){
			    	cell = row.createCell(index++);	    
			    	cell.setCellValue(label[i]);
			    	cell.setCellStyle(cellStyle);	   
			    }

				  /*  cell = row.createCell(index++);	    
				    cell.setCellValue("ชื่อ-สกุล");
				     cell.setCellStyle(cellStyle);	   
				    cell = row.createCell(index++);	    
				    cell.setCellValue("ตำแหน่ง");
				    cell.setCellStyle(cellStyle); 
				 */
				    List<Object[]> status=pstService.searchObject(query.toString());
				    int status_size=status.size();
			    	 for (Object[] objects : status) {
			    		  cell = row.createCell(index++);	    
						    cell.setCellValue((String)objects[1]);
						    cell.setCellStyle(cellStyle);
						    query_inner.append("   (select count(*) FROM "+SCHEMA+".PST_EMPLOYEE_WORK_MAPPING mapping" +
						    		"    where mapping.pe_id=emp.pe_id and mapping.pes_id in("+(Integer)objects[0]+")" +
						    		"   and mapping.pewm_date_time between '"+from_sql+"' and '"+to_sql+"' ) as work_"+(Integer)objects[0]+" , ");
						    query_inner_sum.append(" ,  (select  (pst_status.pes_wage_rate*(count(*))) FROM "+SCHEMA+".PST_EMPLOYEE_WORK_MAPPING mapping" +
						    		"   left join  "+SCHEMA+".PST_EMPLOYEE_STATUS pst_status on (mapping.pes_id=pst_status.pes_id) " +
						    		" where mapping.pe_id=emp.pe_id and mapping.pes_id in("+(Integer)objects[0]+")" +
						    		"   and mapping.pewm_date_time between '"+from_sql+"' and '"+to_sql+"' ) as work_sum_"+(Integer)objects[0]+"  ");
			    	 }
			    	    cell = row.createCell(index++);	    
					    cell.setCellValue("วันทำงานสะสม");
					    cell.setCellStyle(cellStyle);  
					    
					    cell = row.createCell(index++);	    
					    cell.setCellValue("ค่าแรง(บาท)");
					    cell.setCellStyle(cellStyle); 
				    indexRow++;
				   
				    for(int i=0;i<index;i++){
				    	 if(i==2 || i==3 )
				    		 sheet.setColumnWidth(i,(short)((50*8)/((double)1/20) ));
				    	 else
				    		 sheet.setColumnWidth(i,(short)((20*8)/((double)1/20) ));
				    }
				    query.setLength(0);
				    query.append(" SELECT status.pes_id,status.pes_name FROM "+SCHEMA+".PST_EMPLOYEE_STATUS status where status.pes_wage_rate>0");
				   
				    List<Object[]> work_days=pstService.searchObject(query.toString());
				    StringBuffer status_in=new StringBuffer();
				    int work_days_size=work_days.size();				    
				    for (int i = 0; i <work_days_size; i++) {
						if(i!=(work_days_size-1))
							status_in.append((Integer)work_days.get(i)[0]+",");
						else
							status_in.append((Integer)work_days.get(i)[0]+"");
					}
				    query_inner.append("   (select count(*) FROM "+SCHEMA+".PST_EMPLOYEE_WORK_MAPPING mapping" +
				    		"    where mapping.pe_id=emp.pe_id and mapping.pes_id in("+status_in+")" +
				    		"   and mapping.pewm_date_time between '"+from_sql+"' and '"+to_sql+"' ) as work_all , ");
			    	// System.out.println("status_in->"+status_in.toString());
			    	 query.setLength(0);
			    	 query.append("SELECT "+query_inner.toString()+" " +
			    	 		" emp.pe_uid, pump.prp_no, emp.pe_first_name,emp.pe_last_name,pos.pp_name,emp.pe_wage " +
			    	 		query_inner_sum.toString()+
			    	 		" from "+SCHEMA+".PST_EMPLOYEE emp left join  "+SCHEMA+".PST_POSITION pos" +
			    	 		" on emp.pp_id=pos.pp_id left join  "+SCHEMA+".PST_ROAD_PUMP pump" +
			    	 		" on emp.prp_id=pump.prp_id  ");
			    	// System.out.println(query.toString());
			    	 
				    /* SELECT
				    (select count(*) FROM PST_DB2.PST_EMPLOYEE_WORK_MAPPING mapping 
				    where mapping.pe_id=emp.pe_id and mapping.pes_id in(1,2)
				    and mapping.pewm_date_time between '2013-05-01 00:00:00' and '2013-05-31 00:00:00' ) as work_normal,
				    (select count(*) FROM PST_DB2.PST_EMPLOYEE_WORK_MAPPING mapping 
				    where mapping.pe_id=emp.pe_id and mapping.pes_id in(2)
				    and mapping.pewm_date_time between '2013-05-01 00:00:00' and '2013-05-31 00:00:00' ) as work_special,
				    (select count(*) FROM PST_DB2.PST_EMPLOYEE_WORK_MAPPING mapping 
				    where mapping.pe_id=emp.pe_id and mapping.pes_id in(3,4,5,6)
				    and mapping.pewm_date_time between '2013-05-01 00:00:00' and '2013-05-31 00:00:00' ) as work_leave
				      , emp.* from PST_DB2.PST_EMPLOYEE emp*/
			    	 List<Object[]> emps=pstService.searchObject(query.toString());
			    	// System.out.println("query->"+query.toString());
			    	  int rowIndex=1;  
			    	 int emps_size=emps.size();
			    	 for (int i = 0; i <emps_size; i++) {
			    		//for(status_size)
			    		 row = sheet.createRow(indexRow);
						    indexRow++;
						    index=0;
						    cell = row.createCell(index++);	    
						    cell.setCellValue((String)emps.get(i)[status_size+1]);
						    cell.setCellStyle(cellStyle3); 
						    
						    cell = row.createCell(index++);	    
						    cell.setCellValue((String)emps.get(i)[status_size+2]);
						    cell.setCellStyle(cellStyle3); 
						    
						    cell = row.createCell(index++);	    
						    cell.setCellValue((rowIndex++)+". "+(String)emps.get(i)[status_size+3]+" "+(String)emps.get(i)[status_size+4]);
						    cell.setCellStyle(cellStyle3); 
						    
						    cell = row.createCell(index++);	    
						    cell.setCellValue((String)emps.get(i)[status_size+5]);
						    cell.setCellStyle(cellStyle3);
						    
						    cell = row.createCell(index++);	    
						    cell.setCellValue(((java.math.BigDecimal)emps.get(i)[status_size+6]).intValue());
						    cell.setCellStyle(cellStyle3); 
						    int sum=0;
						    for (int j = 0; j < status_size; j++) {
						    	cell = row.createCell(index++);	    
						    	//System.out.println(emps.get(i)[j].getClass());
							  //  cell.setCellValue((java.math.BigInteger)emps.get(i)[j]+"");
							    cell.setCellValue(((java.math.BigInteger)emps.get(i)[j]).intValue());
							    if(emps.get(i)[j+status_size+7]!=null)
							    	sum=sum+((java.math.BigInteger)emps.get(i)[j+status_size+7]).intValue();
							  //  System.out.println("sum ["+j+"]->"+sum);
							    cell.setCellStyle(cellStyle3);
							}
						    cell = row.createCell(index++);	    
						    cell.setCellValue((java.math.BigInteger)emps.get(i)[status_size]+"");
						    cell.setCellStyle(cellStyle3);
						    
						   sum=sum*((java.math.BigDecimal)emps.get(i)[status_size+6]).intValue();
						    cell = row.createCell(index++);	    
						    cell.setCellValue(sum);
						    cell.setCellStyle(cellStyle3);
					}
	        response.setHeader("Content-Type", "application/octet-stream; charset=UTF-8");
	        String filename="ค่าแรง.xls";
	        if(filename.length()>0){
				String userAgent = request.getHeader("user-agent");
				boolean isInternetExplorer = (userAgent.indexOf("MSIE") > -1);
				byte[] fileNameBytes=null;
				try {
					fileNameBytes = filename.getBytes((isInternetExplorer) ? ("windows-1250") : ("utf-8"));
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    String dispositionFileName = "";
			    for (byte b: fileNameBytes) dispositionFileName += (char)(b & 0xff);

				 String disposition = "attachment; filename=\"" + dispositionFileName + "\"";
				 response.setHeader("Content-disposition", disposition);
			}
	        //response.setHeader("Content-disposition", "attachment; filename=Report.xls");
	        ServletOutputStream servletOutputStream = null;
	        try
	        {
	            servletOutputStream = response.getOutputStream();
	        }
	        catch(IOException e)
	        {
	            e.printStackTrace();
	        }
	        try
	        {
	            wb.write(servletOutputStream);
	        }
	        catch(IOException e)
	        {
	            e.printStackTrace();
	        }
	        try
	        {
	            servletOutputStream.flush();
	        }
	        catch(IOException e)
	        {
	            e.printStackTrace();
	        }
	        try
	        {
	            servletOutputStream.close();
	        }
	        catch(IOException e)
	        {
	            e.printStackTrace();
	        }
	    }


 
	@RequestMapping(value={"/export_report2"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
public void export2(HttpServletRequest request, HttpServletResponse response,Model model,SecurityContextHolderAwareRequestWrapper srequest)
{
	String time_from=request.getParameter("from");
	  Date d=null;
	  try {
		 d=format.parse(time_from);
		//System.out.println(d);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  DateTime dt = new DateTime(d);
	  int day_from=dt.getDayOfMonth();
	  int month= dt.getMonthOfYear();
	  int year= dt.getYear(); 
	  
	  int day_to=dt.dayOfMonth().getMaximumValue();
	 // System.out.println(dt.monthOfYear().getMaximumValue());
	 /* System.out.println(dt.getDayOfMonth());
	  System.out.println(dt.getMonthOfYear());
	  System.out.println(dt.getYear());
	  System.out.println("---------------------");
	  System.out.println(dt.dayOfMonth().getMaximumValue());
	  System.out.println(dt.getMonthOfYear());
	  System.out.println(dt.getYear());*/
 //src=src+"?from="+time_from_array+"&to="+time_to_array;
 
 
  
	//String time_to=request.getParameter("to");
	//String[] time_from_array=time_from.split("_");
	//String[] time_to_array=time_to.split("_");
	String from_sql=year+"-"+month+"-"+day_from+" 00:00:00";
	String to_sql=year+"-"+month+"-"+day_to+" 23:59:59";
	//2013-05-01 00:00:00
	// System.out.println(pstService);
	StringBuffer query=new StringBuffer();
	StringBuffer query_inner=new StringBuffer();
	//StringBuffer query_inner_sum=new StringBuffer();
	query.append(" SELECT pump.prp_id,pump.prp_no FROM "+SCHEMA+".PST_ROAD_PUMP pump order by pump.prp_no");
	// String query1=
	
    HSSFWorkbook wb = new HSSFWorkbook();
 //   HSSFSheet sheet = wb.createSheet(time_from_array[0]+"/"+" ถึง "+time_to+"สรุปบันทึกการขาด ลา มาสาย พนง.");
///    HSSFSheet sheet = wb.createSheet(time_from_array[0]+"-"+time_from_array[1]+"-"+time_from_array[2]+" ถึง "+time_to_array[0]+"-"+time_to_array[1]+"-"+time_to_array[2]);
    HSSFSheet sheet = wb.createSheet("ค่าคิวพนักงานรายวัน");
   
  //  HSSFRow row = sheet.createRow(0);
  //  HSSFCellStyle style = wb.createCellStyle(); 
	String[] label={"รหัสประจำตัว","ชื่อ-สกุล"};
    int indexRow = 2;  
    DataFormat dataFormat = wb.createDataFormat();
    HSSFCellStyle cellStyle = wb.createCellStyle();
    HSSFCellStyle cellStyle2 = wb.createCellStyle();
    HSSFCellStyle cellStyle3 = wb.createCellStyle();
    HSSFCellStyle cellStyle4 = wb.createCellStyle();
    cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
    cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
    cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
    cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
    cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
    cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN); 
  
    cellStyle.setFillBackgroundColor(new HSSFColor.GREY_25_PERCENT().getIndex());     
    cellStyle.setWrapText(true);
    
    cellStyle2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
    cellStyle2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
    cellStyle2.setBorderBottom(HSSFCellStyle.BORDER_NONE);
    cellStyle2.setBorderLeft(HSSFCellStyle.BORDER_NONE);
    cellStyle2.setBorderRight(HSSFCellStyle.BORDER_NONE);
    cellStyle2.setBorderTop(HSSFCellStyle.BORDER_NONE); 
    cellStyle2.setWrapText(true); 
    
    Font font = wb.createFont();
    font.setFontHeightInPoints((short)13);
    cellStyle2.setFont(font);
    
    cellStyle3.setAlignment(HSSFCellStyle.ALIGN_LEFT);
    cellStyle3.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
    cellStyle3.setBorderBottom(HSSFCellStyle.BORDER_THIN);
    cellStyle3.setBorderLeft(HSSFCellStyle.BORDER_THIN);
    cellStyle3.setBorderRight(HSSFCellStyle.BORDER_THIN);
    cellStyle3.setBorderTop(HSSFCellStyle.BORDER_THIN);
    cellStyle3.setWrapText(true); 
    cellStyle3.setDataFormat(dataFormat.getFormat("#,##0.##"));
    
    cellStyle4.setAlignment(HSSFCellStyle.ALIGN_LEFT);
    cellStyle4.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
    cellStyle4.setBorderBottom(HSSFCellStyle.BORDER_THIN);
    cellStyle4.setBorderLeft(HSSFCellStyle.BORDER_THIN);
    cellStyle4.setBorderRight(HSSFCellStyle.BORDER_THIN);
    cellStyle4.setBorderTop(HSSFCellStyle.BORDER_THIN);
    cellStyle4.setWrapText(true); 
    cellStyle4.setFillForegroundColor( IndexedColors.YELLOW.getIndex() );
    cellStyle4.setFillPattern(CellStyle.SOLID_FOREGROUND);
   
    cellStyle4.setDataFormat(dataFormat.getFormat("#,##0.##"));
    sheet.addMergedRegion(new CellRangeAddress(
            0, //first row (0-based)
            0, //last row  (0-based)
            2, //first column (0-based)
            10  //last column  (0-based)
    ));
    HSSFRow row = sheet.createRow(0);
    HSSFCell cell = row.createCell(2);
   // cell = row.createCell(2);	    
   //	cell.setCellValue("ค่าแรงพนักงานรายวัน  ประจำเดือน _____________________");
	cell.setCellValue("ค่าคิวพนักงานรายวัน  ประจำเดือน "+dt.monthOfYear().getAsText(locale)+" "+dt.year().getAsText());
   	cell.setCellStyle(cellStyle2);
	cell = row.createCell(10);
	cell.setCellStyle(cellStyle);
    cellStyle2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
    cellStyle2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
    cellStyle2.setBorderRight(HSSFCellStyle.BORDER_THIN);
    cellStyle2.setBorderTop(HSSFCellStyle.BORDER_THIN); 
    row = sheet.createRow(indexRow);
	int index=0;
	 for(int i=0;i<label.length;i++){
	    	cell = row.createCell(index++);	    
	    	cell.setCellValue(label[i]);
	    	cell.setCellStyle(cellStyle);	   
	    }
		    List<Object[]> status=pstService.searchObject(query.toString());
		    
		    
		/*	SELECT emp.pe_uid,emp.pe_first_name 
			,
			IFNULL((SELECT sum(j_emp.pje_amount) FROM PST_DB.PST_JOB_EMPLOYEE j_emp left join 
			PST_DB.PST_JOB job on j_emp.pj_id=job.pj_id where j_emp.pe_id=emp.pe_id and j_emp.prp_id=2),0) as pst_2,
			IFNULL((SELECT sum(j_emp.pje_amount) FROM PST_DB.PST_JOB_EMPLOYEE j_emp left join 
			PST_DB.PST_JOB job on j_emp.pj_id=job.pj_id where j_emp.pe_id=emp.pe_id and j_emp.prp_id=3),0) as pst_3,
			(SELECT sum(j_emp.pje_amount) FROM PST_DB.PST_JOB_EMPLOYEE j_emp left join 
			PST_DB.PST_JOB job on j_emp.pj_id=job.pj_id where j_emp.pe_id=emp.pe_id  ) as pst_sum
			 FROM PST_DB.PST_EMPLOYEE emp

			SELECT (SELECT IFNULL(sum(j_emp.pje_amount),0) FROM PST_DB.PST_JOB_EMPLOYEE j_emp left join 
			PST_DB.PST_JOB job on j_emp.pj_id=job.pj_id where j_emp.prp_id=pump.prp_id) as pst_1
			 FROM PST_DB.PST_ROAD_PUMP  pump
			 */
		    int status_size=status.size();
	    	 for (Object[] objects : status) {
	    		  cell = row.createCell(index++);	    
				    cell.setCellValue((String)objects[1]);
				    cell.setCellStyle(cellStyle);
				    query_inner.append(" , IFNULL((SELECT sum(j_emp.pje_amount) FROM "+SCHEMA+".PST_JOB_EMPLOYEE j_emp left join " +
				    		" "+SCHEMA+".PST_JOB job on j_emp.pj_id=job.pj_id where j_emp.pe_id=emp.pe_id  " +
				    		"and job.pj_created_time between '"+from_sql+"' and '"+to_sql+"' and j_emp.prp_id="+(Integer)objects[0]+"),0) " +
				    		" as pst_"+(Integer)objects[0]+" ");
				   /* query_inner.append("   (select count(*) FROM "+SCHEMA+".PST_EMPLOYEE_WORK_MAPPING mapping" +
				    		"    where mapping.pe_id=emp.pe_id and mapping.pes_id in("+(Integer)objects[0]+")" +
				    		"   and mapping.pewm_date_time between '"+from_sql+"' and '"+to_sql+"' ) as work_"+(Integer)objects[0]+" , ");
				    query_inner_sum.append(" ,  (select  (pst_status.pes_wage_rate*(count(*))) FROM "+SCHEMA+".PST_EMPLOYEE_WORK_MAPPING mapping" +
				    		"   left join  "+SCHEMA+".PST_EMPLOYEE_STATUS pst_status on (mapping.pes_id=pst_status.pes_id) " +
				    		" where mapping.pe_id=emp.pe_id and mapping.pes_id in("+(Integer)objects[0]+")" +
				    		"   and mapping.pewm_date_time between '"+from_sql+"' and '"+to_sql+"' ) as work_sum_"+(Integer)objects[0]+"  ");*/
	    	 }
	    	 query_inner.append(" , (SELECT sum(j_emp.pje_amount) FROM "+SCHEMA+".PST_JOB_EMPLOYEE j_emp left join " +
	    	 		" "+SCHEMA+".PST_JOB job on j_emp.pj_id=job.pj_id where j_emp.pe_id=emp.pe_id " +
	    	 				" and job.pj_created_time between '"+from_sql+"' and '"+to_sql+"' ) as pst_sum" );
	    	    cell = row.createCell(index++);	    
			    cell.setCellValue("รวม");
			    cell.setCellStyle(cellStyle);  
			    
			   /* cell = row.createCell(index++);	    
			    cell.setCellValue("ค่าแรง(บาท)");
			    cell.setCellStyle(cellStyle); */
		    indexRow++;
		   
		    for(int i=0;i<index;i++){
		    	 if(i==1)
		    		 sheet.setColumnWidth(i,(short)((50*8)/((double)1/20) ));
		    	 else
		    		 sheet.setColumnWidth(i,(short)((20*8)/((double)1/20) ));
		    }
		  //  query.setLength(0);
		  //  query.append(" SELECT status.pes_id,status.pes_name FROM "+SCHEMA+".PST_EMPLOYEE_STATUS status where status.pes_wage_rate>0");
		   
		 /*   List<Object[]> work_days=pstService.searchObject(query.toString());
		    StringBuffer status_in=new StringBuffer();
		    int work_days_size=work_days.size();				    
		    for (int i = 0; i <work_days_size; i++) {
				if(i!=(work_days_size-1))
					status_in.append((Integer)work_days.get(i)[0]+",");
				else
					status_in.append((Integer)work_days.get(i)[0]+"");
			}
		    query_inner.append("   (select count(*) FROM "+SCHEMA+".PST_EMPLOYEE_WORK_MAPPING mapping" +
		    		"    where mapping.pe_id=emp.pe_id and mapping.pes_id in("+status_in+")" +
		    		"   and mapping.pewm_date_time between '"+from_sql+"' and '"+to_sql+"' ) as work_all , ");
		    		*/
	    	 query.setLength(0);
	    	 query.append("SELECT emp.pe_uid,emp.pe_first_name,emp.pe_last_name  "+query_inner.toString()+" " +
	    			" FROM "+SCHEMA+".PST_EMPLOYEE emp order by emp.pe_uid  ");
	    
	    	 List<Object[]> emps=pstService.searchObject(query.toString());
	    	// System.out.println("query->"+query.toString());
	    	  int rowIndex=1;  
	    	 int emps_size=emps.size();
	    	 for (int i = 0; i <emps_size; i++) {
	    		//for(status_size)
	    		 row = sheet.createRow(indexRow);
				    indexRow++;
				    index=0;
				    cell = row.createCell(index++);	    
				    cell.setCellValue((String)emps.get(i)[0]);
				    cell.setCellStyle(cellStyle3); 
				    
				    cell = row.createCell(index++);	    
				    cell.setCellValue((rowIndex++)+". "+(String)emps.get(i)[1]+" "+(String)emps.get(i)[2]);
				    cell.setCellStyle(cellStyle3); 
				    for (int j = 0; j < status_size; j++) {
				    	cell = row.createCell(index++);	    
					    cell.setCellValue(((java.math.BigDecimal)emps.get(i)[j+3]).doubleValue());
					    cell.setCellStyle(cellStyle3);
					}
				    cell = row.createCell(index++);	    
				    cell.setCellValue(((java.math.BigDecimal)emps.get(i)[status_size]).doubleValue());
				    cell.setCellStyle(cellStyle4);
			}
	    	 query.setLength(0);
	    	 query.append("	SELECT (SELECT IFNULL(sum(j_emp.pje_amount),0) FROM "+SCHEMA+".PST_JOB_EMPLOYEE j_emp left join " +
	    	 		" "+SCHEMA+".PST_JOB job on j_emp.pj_id=job.pj_id where j_emp.prp_id=pump.prp_id) as pst_1,pump.prp_no " +
	    	 		" FROM "+SCHEMA+".PST_ROAD_PUMP  pump order by pump.prp_no " +
	    			" ");
	    	emps=pstService.searchObject(query.toString());
		    	// System.out.println("query->"+query.toString());
		    //	  int rowIndex=1;  
	    	 row = sheet.createRow(indexRow);
			 indexRow++;
		     emps_size=emps.size();
		     index=1;
		     cellStyle.setFillForegroundColor( IndexedColors.YELLOW.getIndex() );
		     cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
		      cell = row.createCell(index++);	    
			    cell.setCellValue("รวม");
			    cell.setCellStyle(cellStyle);  
		    	 for (int i = 0; i <emps_size; i++) {
					    cell = row.createCell(index++);	    
					    cell.setCellValue(((java.math.BigDecimal)emps.get(i)[0]).doubleValue());
					    cell.setCellStyle(cellStyle4); 
				}
    response.setHeader("Content-Type", "application/octet-stream; charset=UTF-8");
    String filename="ค่าคิว.xls";
    if(filename.length()>0){
		String userAgent = request.getHeader("user-agent");
		boolean isInternetExplorer = (userAgent.indexOf("MSIE") > -1);
		byte[] fileNameBytes=null;
		try {
			fileNameBytes = filename.getBytes((isInternetExplorer) ? ("windows-1250") : ("utf-8"));
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    String dispositionFileName = "";
	    for (byte b: fileNameBytes) dispositionFileName += (char)(b & 0xff);

		 String disposition = "attachment; filename=\"" + dispositionFileName + "\"";
		 response.setHeader("Content-disposition", disposition);
	}
    //response.setHeader("Content-disposition", "attachment; filename=Report.xls");
    ServletOutputStream servletOutputStream = null;
    try
    {
        servletOutputStream = response.getOutputStream();
    }
    catch(IOException e)
    {
        e.printStackTrace();
    }
    try
    {
        wb.write(servletOutputStream);
    }
    catch(IOException e)
    {
        e.printStackTrace();
    }
    try
    {
        servletOutputStream.flush();
    }
    catch(IOException e)
    {
        e.printStackTrace();
    }
    try
    {
        servletOutputStream.close();
    }
    catch(IOException e)
    {
        e.printStackTrace();
    }
}


}