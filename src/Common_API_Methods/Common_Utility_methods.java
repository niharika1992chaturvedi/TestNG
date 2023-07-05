package Common_API_Methods;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.Iterator;
 public class Common_Utility_methods {

public static void EvidenceCreator(String Filename, String RequestBody,String ResponseBody,int Statuscode)throws IOException 
{

File TextFile =new File("/Users/abhisheksharma/Desktop/RestAssured/evidence//"+Filename+".txt");

System.out.println("New blank text file of name :" + TextFile.getName());

FileWriter dataWrite = new FileWriter(TextFile);


dataWrite.write("Request Body is : "+ RequestBody +"\n\n");

dataWrite.write("Status code is : "+ Statuscode +"\n\n");

dataWrite.write("Response Body is : "+ ResponseBody );

dataWrite.close();

System.out.println("Request body and response body written in textfile :"+TextFile.getName());

}

public static ArrayList<String> ReadDataExcel(String sheetname,String TestCaseName) throws IOException
{

	
	ArrayList<String> ArrayData= new ArrayList <String> ();	
//Create the object of file input stream to Loacte the excel file
FileInputStream Fis= new FileInputStream   ( "/Users/abhisheksharma/Desktop/RestAssured/Datadriven.xlsx");  
   
		//step: Open the excel file by creating the object XSSWORKBOOK
		XSSFWorkbook WorkBook = new XSSFWorkbook(Fis);
		//step no 3: Open the desired Sheet
		int countsheet =WorkBook.getNumberOfSheets();
		for(int i=0; i<countsheet; i++) {
			String Sheetname=WorkBook.getSheetName(i);
			 
			
			//access the desire sheet
			 if(Sheetname.equalsIgnoreCase(sheetname))
					 {
				 
			               //use XSSFSheet to save the sheet into the variable
				          XSSFSheet Sheet=WorkBook.getSheetAt(i);
				          
				          //creat iterator to iterate through rows and find out in which column test case names are found
				          
				          Iterator<Row> Rows=Sheet.iterator();
				          Row FirstRow=Rows.next();
				          
				          //create the iterator to iterated through row and find out in whicg column the test//case name found
				          Iterator<Row>Row = Sheet.iterator();
				          Row FirstRow1 = Row.next();
				          
				         
				          
				        //create the Iterator to Iterated through The cells Of 1st Rows to find out which cell contains testcases name

					          Iterator<Cell> CellsofFirstRow = FirstRow1.cellIterator();
					          int k=0;
					          int TC_column=0;
					          while(CellsofFirstRow.hasNext()) 
					          {
					        	  
					        	  Cell CellValue = CellsofFirstRow.next();
					        	  
					        	  if(CellValue.getStringCellValue().equalsIgnoreCase("TestCaseName"))
					        	  {
					        		  TC_column= k;
							    		 //System.out.println("expectedcloumn for test case name:" +k);
							    		 break;
							    	 }
							    	 k++;
							     }
			                     //verify the row where the desired test case is found and fetch the entire row
							     while(Row.hasNext())
							     {
							          Row Datarow =Row.next();	 
							          String TCName=Datarow.getCell(TC_column).getStringCellValue();
							         //Datarow.getCell(TC_column).getNumericCellValue();
							          if
							          (TCName.equalsIgnoreCase(TestCaseName))
							          {
							        	  Iterator<Cell> CellValues =Datarow.cellIterator();
							        	  while(CellValues.hasNext())
							        	  {
							        		  
							        		  String Data="";
							        		  Cell CurrentCell = CellValues.next();
							        		  try
							        		  {
							        		  String StringData= CurrentCell.getStringCellValue();
							        		  Data = StringData;
							        		  }
							        		  
							        		  catch(IllegalStateException e)
							        		  
							        		  {
							        			  double doubledata=CurrentCell.getNumericCellValue();
							        			  Data = Double.toString(doubledata);
							        		  }
							        		  
							        		  ArrayData.add(Data);
							        		  
							        	  }
							        	  break;
							          }
							     }
							     
						}	
						
					
		}
		return ArrayData;}

	
}
				
				
						
					        		  
					        		  
					        		  
					        		  
					        	  
					          
					        	  
					        	  
					        	  
					        	  
					        	  
					          
				          
				          
					 
		


