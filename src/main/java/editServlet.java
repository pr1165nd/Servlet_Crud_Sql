import Employee.Employee;
import Employee.sqlcommands;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/editServlet")
public class editServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doPost(req, resp);
        String name=req.getParameter("Name");
        String address=req.getParameter("address");
        int Id=Integer.parseInt(req.getParameter("Id"));


        sqlcommands s=new sqlcommands();
        try {
            s.UpdateEmployee(Id,name,address);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        RequestDispatcher rs=req.getRequestDispatcher("welcome.jsp");
        rs.include(req,resp);
    }
}
