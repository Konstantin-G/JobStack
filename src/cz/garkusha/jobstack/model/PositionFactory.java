package cz.garkusha.jobstack.model;

import cz.garkusha.jobstack.util.HTMLParser;
import cz.garkusha.jobstack.util.PDFConverter;
import cz.garkusha.jobstack.util.Path;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Model class for new Position.
 *
 * @author Konstantin Garkusha
 */
public class PositionFactory {

    public static Position getNewPosition(int id, String URLToJob){
        HTMLParser htmlParser = new HTMLParser(URLToJob);
//        PDFConverter pdfConverter = new PDFConverter(URLToJob);

        // id - have as parameter
        String result           = null;
        String company          = htmlParser.getCompany();
        String jobTitle         = htmlParser.getJobTitle();
        String jobTitlePDF      = Path.getRelativeJobDescriptionPath() + getPDFFileName(company, jobTitle);
        String location         = htmlParser.getLocation();
        // web - have as parameter
        String person           = htmlParser.getPerson();
        String phone            = htmlParser.getPhone();
        String email            = htmlParser.getEmail();
        String requestSentDate  = null;
        String answerDate       = null;
        String conversation     = null;

        return new Position(id , result, company, jobTitle, jobTitlePDF,location, URLToJob, person, phone, email, requestSentDate, answerDate, conversation);
    }

    private static String getPDFFileName( String company, String jobTitle) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
        return simpleDateFormat.format(new Date()) + "_" + company + "_" + jobTitle + ".pdf";
    }

}
