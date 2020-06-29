import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import Employee.sqlcommands;


@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));

        sqlcommands s=new sqlcommands();
        try {
            s.deleteEmployee(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        RequestDispatcher rs=req.getRequestDispatcher("welcome.jsp");
        rs.include(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
