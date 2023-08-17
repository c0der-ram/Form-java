package ram;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/client")
public class Form extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Form() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String country = request.getParameter("country");
		String subject = request.getParameter("subject");
		
		RequestDispatcher dispatcher = null;
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice?useSSL=false","root","root");
			PreparedStatement ps = con.prepareStatement("insert into client(firstname,lastname,email,mobile,country,subject) values(?,?,?,?,?,?)");// table column name must be same
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, email);
			ps.setString(4, mobile);
			ps.setString(5, country);
			ps.setString(6, subject);
			
           int rowCount = ps.executeUpdate();
			
			dispatcher = request.getRequestDispatcher("form.jsp");
			if(rowCount > 0)
			{
				request.setAttribute("status", "success");
			}
			else
			{
				request.setAttribute("status", "failed");
			}
			
			dispatcher.forward(request, response);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} 
			catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}

}
