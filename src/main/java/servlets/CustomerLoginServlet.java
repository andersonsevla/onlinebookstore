package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.brascode.constant.BookStoreConstants;
import com.brascode.constant.db.UsersDBConstants;
import com.brascode.model.User;
import com.brascode.model.UserRole;
import com.brascode.service.UserService;
import com.brascode.service.impl.UserServiceImpl;

public class CustomerLoginServlet extends HttpServlet {

    UserService authService = new UserServiceImpl();

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        PrintWriter pw = res.getWriter();
        res.setContentType(BookStoreConstants.CONTENT_TYPE_TEXT_HTML);
        String uName = req.getParameter(UsersDBConstants.COLUMN_USERNAME);
        String pWord = req.getParameter(UsersDBConstants.COLUMN_PASSWORD);
        System.out.println("passou aqui.");
        User user = authService.login(UserRole.CUSTOMER, uName, pWord, req.getSession());

        try {

            if (user != null) {

                RequestDispatcher rd = req.getRequestDispatcher("CustomerHome.html");
                rd.include(req, res);
                pw.println("    <div id=\"topmid\"><h1>Welcome to Online <br>Book Store</h1></div>\r\n"
                        + "    <br>\r\n"
                        + "    <table class=\"tab\">\r\n"
                        + "        <tr>\r\n"
                        + "            <td><p>Welcome "+user.getFirstName()+", Manage your Store !!</p></td>\r\n"
                        + "        </tr>\r\n"
                        + "    </table>");

            } else {

                RequestDispatcher rd = req.getRequestDispatcher("CustomerLogin.html");
                rd.include(req, res);
                pw.println("<style> .tab {background-color: #ABBAEA;}</style> <table class=\"tab\"><tr><td>Incorrect UserName or PassWord</td></tr></table>");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}