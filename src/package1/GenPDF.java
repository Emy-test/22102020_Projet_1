package package1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.io.font.*;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;

/**
 * Servlet implementation class GenPDF
 */
@WebServlet("/GenPDF")
public class GenPDF extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenPDF() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("application/pdf");

		PdfDocument doc;
		try {

			PdfWriter writer=new PdfWriter(response.getOutputStream());
			doc=new PdfDocument(writer);
			PdfPage page=doc.addNewPage();
			PdfCanvas canvas= new PdfCanvas(page);
			FontProgram fontProgram=FontProgramFactory.createFont();
			PdfFont font = PdfFontFactory.createFont(fontProgram, "UTF-8", true);
			canvas.beginText();
			int start=842;
			int space=20;
			int inline;
			inline=start-space;



		canvas.setTextMatrix(10, inline);inline=inline-space;

		canvas.setFontAndSize(font, 18);canvas.newlineShowText("Niveau de gravite: ["+"] sur 4!");



		canvas.endText();
		}
		catch (Exception de) {throw new ServletException(de);}
		
		doc.close();
		
//
//        String masterPath = request.getServletContext().getRealPath( "/WEB-INF/FacMaster.pdf" );
//        response.setContentType( "application/pdf" );
//       
//        try ( PdfReader reader = new PdfReader( masterPath );
//              PdfWriter writer = new PdfWriter( response.getOutputStream() );
//              PdfDocument document = new PdfDocument( reader, writer ) ) {
//            
//            PdfPage page = document.getPage( 1 );
//            PdfCanvas canvas = new PdfCanvas( page );
//            
//            FontProgram fontProgram = FontProgramFactory.createFont();
//            PdfFont font = PdfFontFactory.createFont( fontProgram, "utf-8", true );
//            canvas.setFontAndSize( font, 12 );
//            
//            canvas.beginText();
//            int top = 500;
//            canvas.setTextMatrix( 116, top );
//            canvas.showText( "Origine" );
//   
//            canvas.endText();
//            
//        }
	} 
		
		
//		response.setContentType("application/pdf");
//		PdfDocument document;
//		
//		try {
//			PdfWriter writer = new PdfWriter(response.getOutputStream());
//			document = new PdfDocument(writer);
//			PdfPage page=document.addNewPage();
//			PdfCanvas canvas=new PdfCanvas(page);
//			FontProgram fontprogram =FontProgramFactory.createFont();
//			PdfFont font =PdfFontFactory.createFont(fontprogram, "UTF-8", true);
//			
//			canvas.setFontAndSize(font, 12);
//			canvas.beginText();
//			
//			canvas.showText("test");
//			canvas.endText();		
//			}
//		catch (Exception de){
//			throw new ServletException(de);
//			
//		}
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
