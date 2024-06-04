package com.mycontact.servlets;

import com.mycontact.classe.Contact;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/contacts", "/addContact", "/editContact", "/updateContact", "/deleteContact"})
public class contactServlet extends HttpServlet {

    private List<Contact> contacts = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getServletPath().equals("/contacts")) {
            request.setAttribute("contacts", contacts);
            RequestDispatcher dispatcher = request.getRequestDispatcher("contact.jsp");
            dispatcher.forward(request, response);
        } else if (request.getServletPath().equals("/addContact")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("addContact.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        if (action.equals("/addContact")) {
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String competence = request.getParameter("competence");

            Contact newContact = new Contact(nom, prenom, competence);
            contacts.add(newContact);

            response.sendRedirect("contacts");
        } else if (action.equals("/editContact")) {
            int index = Integer.parseInt(request.getParameter("index"));
            Contact contact = contacts.get(index);

            request.setAttribute("contact", contact);
            request.setAttribute("index", index);
            RequestDispatcher dispatcher = request.getRequestDispatcher("editContact.jsp");
            dispatcher.forward(request, response);
        } else if (action.equals("/updateContact")) {
            int index = Integer.parseInt(request.getParameter("index"));
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String competence = request.getParameter("competence");

            Contact updatedContact = new Contact(nom, prenom, competence);
            contacts.set(index, updatedContact);

            response.sendRedirect("contacts");
        } else if (action.equals("/deleteContact")) {
            int index = Integer.parseInt(request.getParameter("index"));
            contacts.remove(index);

            response.sendRedirect("contacts");
        }
    }
}
