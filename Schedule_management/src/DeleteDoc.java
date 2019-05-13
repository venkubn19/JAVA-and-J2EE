

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteDoc
 */
@WebServlet("/DeleteDoc")
public class DeleteDoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteDoc() {
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
		
		Final f = new Final();
		Cell[][] schedule;
		schedule = f.removeDoctor(request.getParameter("name2"));
		
		ArrayList<Doctor> doctors = f.getDoctors();
		
		for(int i=0;i<7;i++) {
			for(int j=0;j<8;j++)
				System.out.print(schedule[i][j].getName()+"\t");
			System.out.println();
		}
		
		try {
			Statement stmt;
			Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/doctors","root","venkateshbn");
            stmt = conn.createStatement();
            
            for(int i=0;i<7;i++) {
				ArrayList<String> docs = new ArrayList<String>();
				int z=0;
				for(int j=0;j<8;j++) {
        				String n=schedule[i][j].getName();

        				if(i==0) {
        					 String query2 = "update docs set monday="+"'"+j+"'"+" "+"where name="+"'"+n+"'"+";";
        					 stmt.executeUpdate(query2);
        				}
        				else if(i==1) {
       					 	 String query2 = "update docs set tuesday="+"'"+j+"'"+" "+"where name="+"'"+n+"'"+";";
       					 	 stmt.executeUpdate(query2);
       				    }
        				else if(i==2) {
          					 String query2 = "update docs set wednesday="+"'"+j+"'"+" "+"where name="+"'"+n+"'"+";";
          					 stmt.executeUpdate(query2);
          				}
        				else if(i==3) {
         					 String query2 = "update docs set thursday="+"'"+j+"'"+" "+"where name="+"'"+n+"'"+";";
         					 stmt.executeUpdate(query2);
         				}
        				else if(i==4) {
         					 String query2 = "update docs set friday="+"'"+j+"'"+" "+"where name="+"'"+n+"'"+";";
         					 stmt.executeUpdate(query2);
         				}
        				else if(i==5) {
         					 String query2 = "update docs set saturday="+"'"+j+"'"+" "+"where name="+"'"+n+"'"+";";
         					 stmt.executeUpdate(query2);
         				}
        				
        				docs.add(schedule[i][j].getName());
				}
				for(Doctor d:doctors) {
					int flag=0;
					for(String d1:docs) {
						if(d.getName().equals(d1)) {
							flag=1;
							break;
						}
					}
						if(flag==0) {
							if(i==0) {
	        					 String query2 = "update docs set monday=null"+" "+"where name="+"'"+d.getName()+"'"+";";
	        					 stmt.executeUpdate(query2);
	        				}
	        				else if(i==1) {
	       					 	 String query2 = "update docs set tuesday=null"+" "+"where name="+"'"+d.getName()+"'"+";";
	       					 	 stmt.executeUpdate(query2);
	       				    }
	        				else if(i==2) {
	          					 String query2 = "update docs set wednesday=null"+" "+"where name="+"'"+d.getName()+"'"+";";
	          					 stmt.executeUpdate(query2);
	          				}
	        				else if(i==3) {
	         					 String query2 = "update docs set thursday=null"+" "+"where name="+"'"+d.getName()+"'"+";";
	         					 stmt.executeUpdate(query2);
	         				}
	        				else if(i==4) {
	         					 String query2 = "update docs set friday=null"+" "+"where name="+"'"+d.getName()+"'"+";";
	         					 stmt.executeUpdate(query2);
	         				}
	        				else if(i==5) {
	         					 String query2 = "update docs set saturday=null"+" "+"where name="+"'"+d.getName()+"'"+";";
	         					 stmt.executeUpdate(query2);
	         				}
						}
							
		
				}
			}
		}
		catch(Exception e)
        {
            System.out.println("Exception occurred is"+ e);
        }
		

	}
}
