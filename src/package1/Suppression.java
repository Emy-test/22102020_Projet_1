package package1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Suppression
 */
@WebServlet("/Suppression")
public class Suppression extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Suppression() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");	
		PrintWriter pw= response.getWriter();
		
		
		HttpSession session = request.getSession(false);	
		Modelbulletin mod= new Modelbulletin();
		Model modlog = new Model();
		Modelsolution modsol= new Modelsolution();
		Modelperimetre_solution mpsol= new Modelperimetre_solution();
		String codestring = request.getParameter("bulid");
		String solstring = request.getParameter("solid");
		String logstring = request.getParameter("code");
		String solbulstring= request.getParameter("bulsolid");
		
		if (logstring!=null) {
			int logint=Integer.parseInt(logstring);
			modlog.supprimerLogiciels(logint);
			System.out.println("Logiciel supprimé");
			request.getRequestDispatcher( "/listelogiciel.jsp" ).forward(request,response);
		}
		
		if (codestring!=null) {
			int codeint=Integer.parseInt(codestring);
			mod.supprimerBulletin(codeint);
			System.out.println("Bulletin supprimé");
			request.getRequestDispatcher( "/listelogadmin.jsp" ).forward(request,response);
		}
		
		if (solstring!=null) {
			int solint=Integer.parseInt(solstring);
			int solbulint=Integer.parseInt(solbulstring);
			modsol.supprimerSolution(solint);
			mpsol.supprimerperimetre_solution(solint, solbulint);
			System.out.println("Solution supprimée");
			request.getRequestDispatcher( "/listelogadmin.jsp" ).forward(request,response);
		}
		
		
//		mod.supprimerParticipant(c.code);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
