package Servlets;

import Daos.CancionDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CancionesServlet", value = {"/CancionesServlet","/listaCanciones"})
public class CancionesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CancionDao cancionDao = new CancionDao();

        //request.setAttribute("listaCanciones",cancionDao.obtenerCanciones());

        //String idBanda = request.getParameter("idbanda");
        /*String idBanda = request.getParameter("idbanda") == null ? "listaCanciones" : request.getParameter("idbanda");
        request.setAttribute("listaCancionesXbanda",cancionDao.obtenerCancionesXbanda(idBanda));
        RequestDispatcher view =request.getRequestDispatcher("listaCanciones.jsp");
        view.forward(request,response);
        */
        String idBanda = request.getParameter("idbanda");
        if(idBanda==null){
            request.setAttribute("listaCanciones", cancionDao.obtenerCanciones());
            RequestDispatcher view =request.getRequestDispatcher("listaCanciones2.jsp");
            view.forward(request,response);
        }
        else{
            request.setAttribute("listaCancionesXbanda", cancionDao.obtenerCancionesXbanda(idBanda));
            RequestDispatcher view =request.getRequestDispatcher("listaCanciones.jsp");
            view.forward(request,response);
        }
        String idCancion;
        String action = request.getParameter("act");
        switch (action){
            case "a":
                idCancion= request.getParameter("id");
                cancionDao.agregarFavoritos(idCancion);
                System.out.println("Ya se agrego");
                response.sendRedirect(request.getContextPath() + "/CancionesServlet");
                break;
            case "q":
                idCancion= request.getParameter("id");
                cancionDao.quitarFavoritos(idCancion);
                System.out.println("Ya se QUITO "+request.getContextPath() );
                response.sendRedirect(request.getContextPath() + "/CancionesServlet");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
