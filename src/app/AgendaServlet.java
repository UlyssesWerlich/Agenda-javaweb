package app;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/Agenda")
public class AgendaServlet extends javax.servlet.http.HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        ContatoDao dao = new ContatoDao();
        ArrayList<Contato> agenda = dao.getAgenda();

        request.setAttribute("Agenda", agenda);
        RequestDispatcher rd = request.getRequestDispatcher("consulta.jsp");
        rd.forward(request,response);
    }
}
