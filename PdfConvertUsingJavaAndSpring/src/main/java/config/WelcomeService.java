package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Component;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.ElementList;
import com.itextpdf.tool.xml.XMLWorkerHelper;
@Component
public class WelcomeService {
//	public static final String DEST = "results/xmlworker/html_1.pdf";
	 
	public String firstPdf (){
		Document document = new Document();
	    try
	    {
	        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("AddTableExample.pdf"));
	        document.open();
	 
	        PdfPTable table = new PdfPTable(3); // 3 columns.
	        table.setWidthPercentage(100); //Width 100%
	        table.setSpacingBefore(10f); //Space before table
	        table.setSpacingAfter(10f); //Space after table
	 
	        //Set Column widths
	        float[] columnWidths = {1f, 1f, 1f};
	        table.setWidths(columnWidths);
	 
	        PdfPCell cell1 = new PdfPCell(new Paragraph("Cell 1"));
	        cell1.setBorderColor(BaseColor.BLUE);
	        cell1.setPaddingLeft(10);
	        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
	 
	        PdfPCell cell2 = new PdfPCell(new Paragraph("Cell 2"));
	        cell2.setBorderColor(BaseColor.GREEN);
	        cell2.setPaddingLeft(10);
	        cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
	 
	        PdfPCell cell3 = new PdfPCell(new Paragraph("Cell 3"));
	        cell3.setBorderColor(BaseColor.RED);
	        cell3.setPaddingLeft(10);
	        cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
	 
	        //To avoid having the cell border and the content overlap, if you are having thick cell borders
	        //cell1.setUserBorderPadding(true);
	        //cell2.setUserBorderPadding(true);
	        //cell3.setUserBorderPadding(true);
	 
	        table.addCell(cell1);
	        table.addCell(cell2);
	        table.addCell(cell3);
	 
	        document.add(table);
	 
	        document.close();
	        writer.close();
	    } catch (Exception e)
	    {
	        e.printStackTrace();
	    }
	    return "First pdf generate successfully check Your work space " ;
	}
	
	public String secondPdf() throws DocumentException, IOException{
		 Document document = new Document();
	        // step 2
	        PdfWriter.getInstance(document, new FileOutputStream("Html1.pdf"));
	        // step 3
	        document.open();
	        // step 4
	        StringBuilder sb = new StringBuilder();
	        sb.append("<div>\n<p align=\"center\">");
	        sb.append("<font size=\"5\">");
	        sb.append("<b>&nbsp;<font color=\"#32cd32\">My centered Para</font></b>");
	        sb.append("</font>");
	        sb.append("<font color=\"#32cd32\">&nbsp;</font>");
	        sb.append("</p>\n</div>");
	 
	        PdfPTable table = new PdfPTable(1);
	        PdfPCell cell = new PdfPCell();
	        ElementList list = XMLWorkerHelper.parseToElementList(sb.toString(), null);
	        for (Element element : list) {
	            cell.addElement(element);
	        }
	        table.addCell(cell);
	        document.add(table);
	 
	        // step 5
	        document.close();
	   
		return "second pdf generate successfully using html  ";
	}
	public String thirdPdf() throws FileNotFoundException, Exception{
		String HTML = "resources/templates/lineheight.html";
		 
		 Document document = new Document();
	        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("html3.pdf"));
	        document.open();
	        XMLWorkerHelper.getInstance().parseXHtml(writer, document,
	                new FileInputStream(HTML));
	        document.close();
		return "third pdf";
	}
	
	public String fourthPdf() throws FileNotFoundException, Exception{
		String HTML = "resources/templates/headers.html";
		 
		 Document document = new Document();
	        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("html4.pdf"));
	        document.open();
	        XMLWorkerHelper.getInstance().parseXHtml(writer, document,
	                new FileInputStream(HTML));
	        document.close();
		return "4 pdf";
	}
	
	public String fifthPdf() throws FileNotFoundException, Exception{
		String HTML = "resources/templates/test.html";
		 
		 Document document = new Document();
	        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("html5.pdf"));
	        document.open();
	        XMLWorkerHelper.getInstance().parseXHtml(writer, document,
	                new FileInputStream(HTML));
	        document.close();
		return "5 pdf";
	}
}
