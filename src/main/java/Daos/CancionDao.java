package Daos;

import Beans.Banda;
import Beans.Cancion;
import Beans.Tour;

import java.net.CacheRequest;
import java.sql.*;
import java.util.ArrayList;

public class CancionDao {
    private static String user = "root";
    private static String pass = "root";
    private static String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";
    public ArrayList<Cancion> obtenerCanciones(){
        ArrayList<Cancion> listaCancionesRecomendadas = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Tour> listaTours = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM cancion;")) {
            while (rs.next()) {
                Cancion cancion = new Cancion(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
                listaCancionesRecomendadas.add(cancion);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("No se pudo realizar la busqueda de canciones");
        }
        return listaCancionesRecomendadas;
    }

    public ArrayList<Cancion> obtenerCancionesXbanda(String idBanda){
        ArrayList<Cancion> listaCancionXbanda = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "select * from cancion\n" +
                "where banda = ?";
        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
             pstmt.setString(1,idBanda);
            //pstmt.setString(1, job.getJobId());
            //pstmt.setString(2, job.getJobTitle());
            //pstmt.setInt(3, job.getMinSalary());
            //pstmt.setInt(4, job.getMaxSalary());
            //pstmt.executeUpdate();
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Cancion cancion = new Cancion(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
                    listaCancionXbanda.add(cancion);
                }
            }

        } catch (SQLException e) {
            System.out.println("No se pudo realizar la busqueda de canciones");
            throw new RuntimeException(e);
        }
        return listaCancionXbanda;
    }
    public ArrayList<Cancion> listarCancionesFavoritas(){
        ArrayList<Cancion> listaCancionesFavoritas = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * from cancion\n" +
                     "where favorito = 1;")) {
            while (rs.next()) {
                Cancion cancion = new Cancion(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
                listaCancionesFavoritas.add(cancion);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("No se pudo realizar la busqueda de canciones");
        }
        return listaCancionesFavoritas;
    }


    public void agregarFavoritos(String idBanda){
        ArrayList<Cancion> listaCancionXbanda = new ArrayList<>();
        int favorito = 1;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "UPDATE cancion SET favorito = ? WHERE idCancion = ?";
        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1,favorito);
            pstmt.setString(2,idBanda);
            //pstmt.setString(1, job.getJobId());
            //pstmt.setString(2, job.getJobTitle());
            //pstmt.setInt(3, job.getMinSalary());
            //pstmt.setInt(4, job.getMaxSalary());
            //pstmt.executeUpdate();
            pstmt.executeQuery();
        } catch (SQLException e) {
            System.out.println("No se pudo realizar la busqueda de canciones");
            throw new RuntimeException(e);
        }
    }


    public ArrayList<Cancion> obtenerCancionesRecomendadas(){
        ArrayList<Cancion> listaCancionesRecomendadas = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM lab6sw1.cancion\n" +
                     "WHERE idCancion in (SELECT cancion_idcancion FROM reproduccion\n" +
                     "group by cancion_idcancion having\n" +
                     "count(*) >2 order by count(*) desc);")) {
            while (rs.next()) {
                Cancion cancion = new Cancion(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
                listaCancionesRecomendadas.add(cancion);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("No se pudo realizar la busqueda de canciones");
        }
        return listaCancionesRecomendadas;
    }

    /*public ArrayList<Cancion> obtenerCancionesRecomendadas(ArrayList<> listaIdCacnionesRecomendadas){
        ArrayList<Cancion> listaCancionesRecomendadas = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "SELECT * FROM lab6sw1.cancion\n" +
                "WHERE idCancion in (10,15,11,16,9);";
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            //pstmt.setString(1, job.getJobId());
            //pstmt.setString(2, job.getJobTitle());
            //pstmt.setInt(3, job.getMinSalary());
            //pstmt.setInt(4, job.getMaxSalary());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listabandas;
    }*/


}
