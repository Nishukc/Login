package controller;

import com.sun.javaws.progress.PreloaderDelegate;
import domain.User;
import services.UserServices;

import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.util.List;

public class UserServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {


        String page = request.getParameter("page");

        if(page.equalsIgnoreCase("login")){
            String name = request.getParameter("username");
            String password = request.getParameter("username");
            User user = new UserServices().getUser(name, password);
            if(user!=null){

                RequestDispatcher rd = request.getRequestDispatcher("User/homepage.jsp");
                rd.forward(request,response);

                }
            else{
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request,response);
                }
        }

        if(page.equalsIgnoreCase("logout")){
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request,response);
        }

        if(page.equalsIgnoreCase("list")){
            List<User> userList = new UserServices().getUserList();
            request.setAttribute("userList", userList);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/list.jsp");
            requestDispatcher.forward(request,response);

        }
        if(page.equalsIgnoreCase("user/userForm.jsp")){
            RequestDispatcher rd = request.getRequestDispatcher("user/userForm.jsp");
            rd.forward(request,response);
        }

        if(page.equalsIgnoreCase("addUser")){
            User user = new User();
            user.setName(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));
            user.setAddress(request.getParameter("address"));

            new UserServices().add(user);
            List<User> userList = new UserServices().getUserList();
            request.setAttribute("userList",userList);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("User/list.jsp");
            requestDispatcher.forward(request,response);

        }


    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
