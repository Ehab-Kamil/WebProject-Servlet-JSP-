/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserController;

import HibernateDao.HUserDao;
import HibernateEntity.Users;
import db.HDBconnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ehab
 */
@WebServlet(name = "SignupController", urlPatterns = {"/SignupController"})
public class SignupController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SignupController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SignupController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                HttpSession session = request.getSession(true);

        Users user=new Users();
        HUserDao hUserDao=new HUserDao();

        boolean checkName=hUserDao.chechMail(request.getParameter("userName"));
        boolean checkMail=hUserDao.checkName(request.getParameter("userEmail"));
        boolean checkSSN=hUserDao.checkSSN(Integer.parseInt(request.getParameter("userSsn")));
        if(!checkMail && !checkName &&!checkSSN)
        {
            user.setUserName(request.getParameter("userName"));
            user.setUserEmail(request.getParameter("userEmail"));
            user.setUserSsn(Integer.parseInt(request.getParameter("userSsn")));
            user.setUserCharge(Float.parseFloat(request.getParameter("userCharge")));
            user.setUserPassword(request.getParameter("userPassword"));
            user.setUserRegdate(new Date());
            user.setUserZip(0);
                               System.out.println("Insertion done");

            //cartProduct.setUsers(user);
                HDBconnect.getInstance().getSession().beginTransaction();
               HDBconnect.getInstance().getSession().persist(user);
                 HDBconnect.getInstance().getSession().getTransaction().commit();
                   System.out.println("Insertion done");
            response.sendRedirect("UserPages/welcome.jsp");
            session = request.getSession(true);
            session.setAttribute("user", user);
        }
        else{
            request.setAttribute("user", user);
            System.out.println(user.getUserEmail());
            RequestDispatcher rd=request.getRequestDispatcher("UserPages/Signup.jsp");
            rd.forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
