package com.me.crud.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.ElementListener;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.me.crud.pojo.Applications;


public class PDFResumeView  extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document pdfdoc, PdfWriter pdfwriter,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//model was added to the scope by the Controller
		Applications app = (Applications) model.get("application");
		
		Font boldFont = new Font(Font.HELVETICA, 18, Font.BOLD);
		Font normalBold = new Font(Font.HELVETICA, 10, Font.BOLD);
		//Font normal = new Font(Font.HELVETICA, 10, Font.NORMAL);
		pdfdoc.add(Image.getInstance("https://www.northeastern.edu/guidelines/images/page/AltLogo_S_bR.png"));
		pdfdoc.add(new Paragraph("Application Details",boldFont ));
		pdfdoc.add(new Paragraph("Application ID: " + app.getAppId(),normalBold));
		pdfdoc.add(new Paragraph("Date Submitted: " + app.getDateSubmitted(),normalBold));
		
		pdfdoc.add(new Paragraph("Job Details",boldFont ));
		pdfdoc.add(new Paragraph("Job ID: " + app.getJob().getID(),normalBold));
		pdfdoc.add(new Paragraph("Company Name: " + app.getJob().getCompanyName(),normalBold));
		pdfdoc.add(new Paragraph("Title: " + app.getJob().getTitle(),normalBold));
		pdfdoc.add(new Paragraph("Openings: " + app.getJob().getOpenings(),normalBold));
		pdfdoc.add(new Paragraph("Length: " + app.getJob().getLength(),normalBold));
		pdfdoc.add(new Paragraph("City: " + app.getJob().getCity(),normalBold));
		pdfdoc.add(new Paragraph("Country: " + app.getJob().getCountry(),normalBold));
		pdfdoc.add(new Paragraph("Description: " + app.getJob().getDescription(),normalBold));
		pdfdoc.add(new Paragraph("Wage: " + app.getJob().getMinWage()+"<"+app.getJob().getWageType()+"<"+app.getJob().getMaxWage(),normalBold));
		
		pdfdoc.add(new Paragraph("Student Details",boldFont ));
		pdfdoc.add(new Paragraph("Name: " + app.getStudent().getfName()+" "+app.getStudent().getlName(),normalBold));
		pdfdoc.add(new Paragraph("Email: " + app.getStudent().getEmail(),normalBold));
		pdfdoc.add(new Paragraph("Mobile: " + app.getStudent().getMobile(),normalBold));
		pdfdoc.add(new Paragraph("Course Name: " + app.getStudent().getCourseName(),normalBold));
		pdfdoc.add(new Paragraph("Car Availability: " + app.getStudent().getCarAvail(),normalBold));
		pdfdoc.add(new Paragraph("Linkedin URL: " + app.getStudent().getLinkedinUrl(),normalBold));
		pdfdoc.add(new Paragraph("SkypeID: " + app.getStudent().getSkypeID(),normalBold));
		pdfdoc.add(new Paragraph("Coop Faculty: " + app.getStudent().getCoopFaculty().getfName()+" "+app.getStudent().getCoopFaculty().getlName(),normalBold));
		pdfdoc.add(new Paragraph("Technical Skill: " + app.getTechnicalSkills(),normalBold));
		pdfdoc.add(new Paragraph("Work Experience: " + app.getWorkExperience(),normalBold));
		pdfdoc.add(new Paragraph("Current University: " + app.getCurrentUniversity(),normalBold));
	}

}