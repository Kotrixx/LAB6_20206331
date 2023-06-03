package Servlets;

import Beans.ListaReproduccion;
import Daos.CancionDao;
import Daos.ListaReproduccionDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PlaylistsServlet", value = {"/PlaylistsServlet","/Playlists"})
public class PlaylistsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ListaReproduccionDao listaReproduccion = new ListaReproduccionDao();
        request.setAttribute("listaPlaylist", listaReproduccion.listarPlaylists());
        //RequestDispatcher view =request.getRequestDispatcher("listaPlaylists.jsp");
        //view.forward(request,response);
        String action = request.getParameter("act") == null? "playlists" : request.getParameter("act") ;
        RequestDispatcher view;
        switch (action){
            case "playlists":
                view =request.getRequestDispatcher("listaPlaylists.jsp");
                view.forward(request,response);
                break;
            case "crear":
                view =request.getRequestDispatcher("nuevaPlaylist.jsp");
                view.forward(request,response);
                break;
            case "list":
                String idPlaylist = request.getParameter("id");
                request.setAttribute("listaCancionesPlaylists", listaReproduccion.obtenerCancionesXplaylist(idPlaylist));
                view =request.getRequestDispatcher("listaCancionesPlaylists.jsp");
                view.forward(request,response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
