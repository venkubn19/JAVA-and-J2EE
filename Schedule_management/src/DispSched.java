import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispSched
 */
@WebServlet("/DispSched")
public class DispSched extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispSched() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String name = request.getParameter("name3");
		
		try {
			Statement stmt;
			Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/doctors","root","venkateshbn");
            stmt = conn.createStatement();
           
            
            String query6 = "select * from docs where name="+"'"+name+"'"+";";
            ResultSet rs = stmt.executeQuery(query6);
            
            
            response.setContentType("text/html");
            PrintWriter out=response.getWriter();
         
            
            while(rs.next()) {
           
            	out.println("<html>"
                        + "<head><title>Schedule</title></head>"
                        + "<body>"
                        + "<table>"
                        +"<tr>"
                        +"<th>Name</th>"
                        +"<th>Monday</th>"
                        +"<th>Tuesday</th>"
                        +"<th>Wednesday</th>"
                        +"<th>Thursday</th>"
                        +"<th>Friday</th>"
                        +"<th>Saturady</th>"
                        +"</tr>"
                        +"<tr>"
                        +"<td>"+rs.getString(1)+"</td>"
                        +"<td>"+rs.getString(2)+"</td>"
                        +"<td>"+rs.getString(3)+"</td>"
                        +"<td>"+rs.getString(4)+"</td>"
                        +"<td>"+rs.getString(5)+"</td>"
                        +"<td>"+rs.getString(6)+"</td>"
                        +"<td>"+rs.getString(7)+"</td>"
                        +"</tr>"
                        +"</table> <br><br>"
                        +"<h3>Legend</h3>"
                        +"<h5> 0 = 1:00 t0 3:00</h5>"
                        +"<h5> 1 = 4:00 t0 6:00</h5>"
                        +"<h5> 2 = 7:00 t0 9:00</h5>"
                        +"<h5> 3 = 10:00 t0 12:00</h5>"
                        +"<h5> 4 = 13:00 t0 15:00</h5>"
                        +"<h5> 5 = 16:00 t0 18:00</h5>"
                        +"<h5> 6 = 19:00 t0 21:00</h5>"
                        +"<h5> 7 = 22:00 t0 24:00</h5>"
                        +"</body>"
                        +"</html>");
            out.close();
            
            }
		}
		catch(Exception e)
        {
            System.out.println("Exception occurred is"+ e);
        }
	}

}
