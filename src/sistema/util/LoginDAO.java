package sistema.util;

import classes.Usuario;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class LoginDAO {

    private Connection connection;

    public LoginDAO() {
        connection = Database.getConnection();
    }

    public boolean checkUser(String usuario, String contra) {
        try {

            Statement stmt = connection.createStatement();
            String sql = "SELECT username , password FROM usuario WHERE username= '" + usuario + "' AND password= '" + contra + "'";
            stmt = connection.createStatement(); // Esta es linea que tienes que incluir
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) // found
            {
                //metodos
                return true;
            } else {
                //metodo
                return false;
            }
        } catch (Exception ex) {
            System.out.println("prueba xd() -->" + ex.getMessage());
            return false;
        }
    }

    public int rol(String usuario, String contra) {
        int role = 0;
        try {

            Statement stmt = connection.createStatement();
            String sql = "SELECT id_rol FROM usuario WHERE username= '" + usuario + "' AND password= '" + contra + "'";
            stmt = connection.createStatement(); // Esta es linea que tienes que incluir
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) // found
            {
                //metodos
                role = rs.getInt("id_rol");

            }

        } catch (Exception ex) {
            System.out.println("Error in check() -->" + ex.getMessage());

        }
        return role;

    }

    public int getIdPersona(String nombre) {
        int usuario = 0;
        try {
            PreparedStatement pstm = null;
            ResultSet rs = null;
            String query = "SELECT id_persona FROM usuario WHERE username = ?";
            pstm = connection.prepareStatement(query);
            pstm.setString(1, nombre);
            rs = pstm.executeQuery();
            if (rs.next()) {
                usuario = rs.getInt("id_persona");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return usuario;
    }
    
        public void addUser(String nombre,String apellidos,String fechaNac,String tel,String correo,
        String domicilio,String usuario,String contraseña) {
        try {

            Statement stmt;
            stmt = connection.createStatement();
            int res = stmt.executeUpdate("INSERT INTO personas (nombre,apellidos,fecha_nac,tel,correo,domicilio) VALUES ('" + nombre + "', '" + apellidos + "' ,'" + fechaNac + "', '" + tel + "', '" + correo + "'   ,'" + domicilio + "');");

            if (res > 0) {

                stmt.executeUpdate("INSERT INTO usuario (id_persona,username,password,id_rol) VALUES ((select MAX(id_persona) from personas),'" + usuario + "', '" + contraseña + "' ,'" + 2 + "');");

            }

            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
