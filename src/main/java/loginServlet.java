import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginservlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        String email=req.getParameter("username");
        String password=req.getParameter("userpass");

        if (email.equals("abc@gmail.com")&&password.equals("root")){
          //  out.println("Valid Entry!");
            RequestDispatcher rs=req.getRequestDispatcher("welcome.jsp");
            rs.include(req,resp);
        }
        else {
            out.println("Invalid entry!");
            RequestDispatcher rs=req.getRequestDispatcher("index.jsp");
            rs.include(req,resp);
            out.println("invalid");
        }

    }
}
