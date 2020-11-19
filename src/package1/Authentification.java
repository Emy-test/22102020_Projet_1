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
 * Servlet implementation class Authentification
 */
@WebServlet("/Authentification")
public class Authentification extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public HttpSession session;
//       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Authentification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");	
		PrintWriter pw= response.getWriter();
		Model mod= new Model();
		Modeluser moduser= new Modeluser();
		User user= new User();
		
		String login = request.getParameter("login");
		String pwd = request.getParameter("pwd");
		String role = request.getParameter("role");
		int id = moduser.chercherUser(login, pwd).getId();
		
		session= request.getSession(true);
		session.setAttribute("id_session", id);
		
//		request.getRequestDispatcher( "/NewFile.jsp" ).forward(request,response);
		moduser.chercherUser(login, pwd);
		
		
		if (moduser.chercherUser(login, pwd)!=null) {
			if(moduser.chercherUser(login, pwd).getRole().contentEquals("admin")) {
				request.getRequestDispatcher( "/connexionadmin.jsp" ).forward(request,response);
			}
			else {
			
				request.getRequestDispatcher( "/connexionuser.jsp" ).forward(request,response);
			}
			
		}
		else {
			request.getRequestDispatcher( "/authentif.jsp" ).forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
