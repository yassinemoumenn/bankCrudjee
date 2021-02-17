package com.example.bankcrudjee.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.bankcrudjee.model.User;
import com.example.bankcrudjee.model.Persone;
import com.example.bankcrudjee.model.Entreprise;
import com.example.bankcrudjee.dao.UserDao;
import com.example.bankcrudjee.dao.UserImpDao;
import static com.example.bankcrudjee.connection.connection.connect;


@WebServlet("/")
public class contrServlet extends HttpServlet {
    private UserDao userDao;

    public contrServlet() throws SQLException {
    }

    public void init() {
        userDao = new UserImpDao();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException

    {
        PrintWriter out = response.getWriter();
        out.print("<br>");
        out.print("<h1>Liste des Entreprises</h1>");
        out.println("<table border='1'><tr><th>Id</th><th>Numero</th><th>Solde</th><th>Nom</th><th>Delete</th>");

        try {
            Connection con = connect();;
            Statement st= con.createStatement();
            ResultSet rs=st.executeQuery("select * from entreprise");
            while(rs.next()) {
                int id1  = rs.getInt(1);



                out.print("<tr><td>");
                out.println(rs.getInt(1));
                out.print("</td>");
                out.print("<td>");
                out.println(rs.getLong(2));
                out.print("</td>");
                out.print("<td>");
                out.println(rs.getDouble(3));
                out.print("</td>");
                out.print("<td>");
                out.println(rs.getString(6));
                out.print("</td>");
                out.print("<td>");
                out.print("<a href=delete?id=");
                out.println(id1);
                out.print(">");
                out.println("Delete");
                out.println("</a>");
                out.print("</td>");
                out.print("</tr>");
            }

        }catch(Exception e)
        {
            System.out.println(e);
        }
        out.print("</table>");

        out.print("<br>");
        out.print("<h1>Liste des Personnes</h1>");


        out.println("<table border='1'><tr><th>Id</th><th>Numero</th><th>Solde</th><th>Nom</th><th>Prenom</th><th>Delete</th>");
        try {
            Connection con = connect();;
            Statement st= con.createStatement();
            ResultSet rs=st.executeQuery("select * from personel");
            while(rs.next()) {
                int id1  = rs.getInt(1);


                out.print("<tr><td>");
                out.println(rs.getInt(1));
                out.print("</td>");
                out.print("<td>");
                out.println(rs.getLong(2));
                out.print("</td>");
                out.print("<td>");
                out.println(rs.getDouble(3));
                out.print("</td>");
                out.print("<td>");
                out.println(rs.getString(6));
                out.print("</td>");
                out.print("<td>");
                out.println(rs.getString(7
                ));
                out.print("</td>");
                out.print("<td>");
                out.print("<a href=delete?id=");
                out.println(id1);
                out.print(">");
                out.println("Delete");
                out.println("</a>");
                out.print("</td>");

                out.print("</tr>");
            }

        }catch(Exception e)
        {
            System.out.println(e);
        }
        out.print("</table>");

        String action = request.getServletPath();

        switch (action) {
            case "/":
                try {
                    userList(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "/insertEntr":
                insertEntreprise(request, response);
                break;
            case "/insertPers":
                insertPersone(request, response);
                break;
            case "/delete":
                delete(request, response);
                break;

            case "/update":
                update(request, response);
                break;
            default:

                break;
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    private void userList(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<User> userList = userDao.allUser();
        request.setAttribute("users", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);

    }


    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String type = request.getParameter("type");
        double solde = Double.parseDouble(request.getParameter("solde"));
        long numero = Long.parseLong(request.getParameter("numero"));

        int id = Integer.parseInt(request.getParameter("id"));
        User user1 = new User(id, numero, solde, type);
        try {
            userDao.updateUser(user1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect("index.jsp");


    }
    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        try {
            userDao.deleteUser(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect("index.jsp");

    }
    private void insertEntreprise(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String type = request.getParameter("type");
        double solde = Double.parseDouble(request.getParameter("solde"));
        long numero = Long.parseLong(request.getParameter("numero"));
        String nom = request.getParameter("nom");
        Entreprise entreprise = new Entreprise(numero, solde, type,nom);
        try {
            userDao.insertUserEntreprise(entreprise);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect("index.jsp");
    }

    private void insertPersone(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String type = request.getParameter("type");
        double solde = Double.parseDouble(request.getParameter("solde"));
        long numero = Long.parseLong(request.getParameter("numero"));
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        Persone persone = new Persone(numero, solde, type,nom,prenom);
        try {
            userDao.insertUserPersone(persone);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect("index.jsp");
    }


    }