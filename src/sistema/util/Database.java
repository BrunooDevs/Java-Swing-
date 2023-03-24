package sistema.util;


import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    //metodo getConnection que ya existe dentro de la clase Connection
    public static Connection getConnection() {

        //prueba
        String Usuario = "root";
        String clave = "root";
        String URL = "jdbc:mysql://localhost:3306/citasmedicas?serverTimezone=UTC";
        //jdbc:mysql://localhost:3306/plasmin?serverTimezone=Australia/Sydney

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, Usuario, clave);
            return con;
        } catch (Exception ex) {
            System.out.println("Database.getConnection() Error -->" + ex.getMessage());
            return null;
        }

    }

    public static void close(Connection con) {
        try {
            con.close();
        } catch (Exception ex) {
        }
    }
}
