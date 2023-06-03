package Daos;

import Beans.Cancion;
import Beans.ListaReproduccion;

import java.sql.*;
import java.util.ArrayList;

public class ListaReproduccionDao {
    private static String user = "root";
    private static String pass = "root";
    private static String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";
    public ArrayList<ListaReproduccion> listarPlaylists(){
        ArrayList<ListaReproduccion> listaPlaylists = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * from listareproduccion;")) {
            while (rs.next()) {
                ListaReproduccion listaReproduccion = new ListaReproduccion(rs.getInt(1),rs.getString(2));
                listaPlaylists.add(listaReproduccion);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("No se pudo realizar la busqueda de playlists");
        }
        return listaPlaylists;
    }

    public ArrayList<Cancion> obtenerCancionesXplaylist(String idPlaylist){
        ArrayList<Cancion> listaCancionesXplaylist = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "select * from cancion where idcancion in ( \n" +
                "select cancion_idcancion from cancion_has_listareproduccion where listaReproduccion_idlistaReproduccion = ?);";
        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1,Integer.parseInt(idPlaylist));

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Cancion cancion = new Cancion(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
                    listaCancionesXplaylist.add(cancion);
                }
            }

        } catch (SQLException e) {
            System.out.println("No se pudo realizar la busqueda de canciones");
            throw new RuntimeException(e);
        }
        return listaCancionesXplaylist;
    }

}
