package infinite.ServletAgent;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AgentSearchServlet
 */
public class AgentSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgentSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int AgentId = Integer.parseInt(request.getParameter("AgentId"));
		AgentDAO dao = new AgentDAO();
		try {
			Agent agent = dao.searchAgent(AgentId);
			if( agent!=null){
				out.println("name "+ agent.getName() +"<br/>");
				out.println("city "+ agent.getCity() +"<br/>");
				out.println("marital status"+ agent.getMaritalStatus() +"<br/>");
				out.println("gender"+ agent.getGender() +"<br/>");
				out.println("Premium "+ agent.getPremium()+"<br/>");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
