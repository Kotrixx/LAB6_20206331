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
        String action = request.getParameter("act");
        switch (action){
            case "fav":
                request.setAttribute("listaPlaylist", cancionDao.obtenerCanciones());
                RequestDispatcher view =request.getRequestDispatcher("listaPlaylist.jsp");
                view.forward(request,response);
                break;
            case "borrarFav":
                String idCancion= request.getParameter("idCancion");
                request.setAttribute("listaPlaylist", cancionDao.quitarFavoritos(idCancion));
                //RequestDispatcher view =request.getRequestDispatcher("listaPlaylist.jsp");
                //view.forward(request,response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
