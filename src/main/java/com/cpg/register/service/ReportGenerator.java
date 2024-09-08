package com.cpg.register.service;

import java.io.File;
import java.io.FileOutputStream;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.io.IOException;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.lowagie.text.DocumentException;

import io.github.birddevelper.salmos.HtmlReportMaker;
import io.github.birddevelper.salmos.setting.HtmlReportTemplate;
import io.github.birddevelper.salmos.setting.SummaryType;

@Service
public class ReportGenerator {
	
	public String htmlToPdf(String processedHtml) {
		ByteArrayOutputStream byteArraryArrayOutputStream=new ByteArrayOutputStream();
		try {
			PdfWriter pdfWriter=new PdfWriter(byteArraryArrayOutputStream);
			
			DefaultFontProvider defaultFontProvider=new DefaultFontProvider(false, true, false);
			
			ConverterProperties converterProperties=new ConverterProperties();
			
			converterProperties.setFontProvider(defaultFontProvider);
			
			HtmlConverter.convertToPdf(processedHtml, pdfWriter,converterProperties);
			
			FileOutputStream fileOutputStream=new FileOutputStream("C:/Users/softa/Downloads/document/score.pdf");
			
			byteArraryArrayOutputStream.writeTo(fileOutputStream);
			byteArraryArrayOutputStream.close();
			
			byteArraryArrayOutputStream.flush();
			fileOutputStream.close();
			
			return null;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/*
	 * @Autowired DataSource dataSource;
	 * 
	 * public String generateReport() { HtmlReportMaker hrm = new
	 * HtmlReportMaker(dataSource); hrm.addSummaryColumn("Age",
	 * SummaryType.AVERAGE); hrm.addSummaryColumn("Salary", SummaryType.SUM);
	 * 
	 * HtmlReportTemplate myTemplate = new HtmlReportTemplate();
	 * myTemplate.setTableCssClass("tblReport");
	 * 
	 * // Generate the report return hrm.generate(); }
	 */
	
	/*
	 * public ByteArrayOutputStream generateVoucherDocumentBaos(String html) throws
	 * IOException, DocumentException { ByteArrayOutputStream baos = new
	 * ByteArrayOutputStream();
	 * 
	 * ITextRenderer renderer = new ITextRenderer();
	 * renderer.setDocumentFromString(html); renderer.layout();
	 * renderer.createPDF(baos); try { baos.close(); } catch (java.io.IOException e)
	 * { // TODO Auto-generated catch block e.printStackTrace(); }
	 * 
	 * return baos; }
	 */
}
