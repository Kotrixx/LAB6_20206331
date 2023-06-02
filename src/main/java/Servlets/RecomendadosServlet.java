package Servlets;

import Beans.Cancion;
import Beans.Tour;
import Daos.CancionDao;
import Daos.TourDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "RecomendadosServlet", value = {"/RecomendadosServlet","/listaRecomendados"})
public class RecomendadosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CancionDao cancionDao = new CancionDao();

        request.setAttribute("listaCancionesRecomendadas",cancionDao.obtenerCancionesRecomendadas());
        RequestDispatcher view =request.getRequestDispatcher("listaCancionesRecomendadas.jsp");
        view.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
