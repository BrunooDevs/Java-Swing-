package Model;

import classes.Doctor;
import classes.Noticias;
import classes.Permisos;
import classes.Usuario;
import java.sql.*;
import java.util.*;
import sistema.util.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DoctorDao {

    private Connection connection;

    public DoctorDao() {
        connection = Database.getConnection();
    }//fin del constructor

    /**
     * **********************************************************
     * obtiene el rol de un usuario dado su id usuario
     * **********************************************************
     */
    public Permisos obtenerPermisos(String user) {
        try {
            PreparedStatement pstm = null;
            ResultSet rs = null;
            String query = "SELECT * FROM permisos WHERE id_permiso IN (SELECT id_permisos FROM roles as r INNER JOIN usuario as u ON r.id_rol = u.id_rol WHERE u.username = ?);";
            pstm = connection.prepareStatement(query);
            pstm.setString(1, user);
            rs = pstm.executeQuery();
            if (rs.next()) {
                Permisos p = new Permisos();
                p.setInfoSelect(rs.getBoolean("select_info"));
                p.setInfoUpdate(rs.getBoolean("update_info"));
                p.setInfoInsert(rs.getBoolean("insert_info"));
                p.setInfoDelete(rs.getBoolean("delete_info"));
                p.setAdmin(rs.getBoolean("Admin"));
                return p; //regresar el objeto con los permisos almacenados
            } else {
                return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Doctor GetInformacionUsuario(int id_persona) {
        try {
            PreparedStatement pstm = null;
            ResultSet rs = null;
            String query = "SELECT * FROM personas WHERE id_persona= '" + id_persona + "'";
            pstm = connection.prepareStatement(query);
            rs = pstm.executeQuery();
            if (rs.next()) {
                Doctor usuario = new Doctor();
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellidos(rs.getString("apellidos"));
                usuario.setFecha_nac(rs.getString("fecha_nac"));
                usuario.setTel(rs.getString("tel"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setDomicilio(rs.getString("domicilio"));
                return usuario; //regresar el objeto con los Datos almacenados
            } else {
                return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<Usuario> getCitasAtender(int id_medico) {

        ArrayList<Usuario> users = new ArrayList<>();

        try {
            PreparedStatement pstm = null;
            ResultSet rs = null;
            String query = "SELECT folio,id_persona,id_medico,nombre,Apellidos,numero_ss,INE FROM paciente WHERE id_medico = ?";

            pstm = connection.prepareStatement(query);
            pstm.setInt(1, id_medico);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setFolio(rs.getInt("folio"));
                usuario.setId_persona(rs.getInt("id_persona"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellidos(rs.getString("Apellidos"));
                usuario.setNumero_ss(rs.getString("numero_ss"));
                usuario.setINE(rs.getString("INE"));
                users.add(usuario);

            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return users;

    }

    public List<Usuario> getMiAgendaFolios(int id_medico) {

        List<Usuario> users = new ArrayList<Usuario>();

        try {
            PreparedStatement pstm = null;
            ResultSet rs = null;
            String query = "SELECT folio FROM paciente WHERE id_medico = ?";

            pstm = connection.prepareStatement(query);
            pstm.setInt(1, id_medico);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setFolio(rs.getInt("folio"));
                users.add(usuario);

            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return users;

    }

    public List<Usuario> getCamas() {

        List<Usuario> users = new ArrayList<Usuario>();

        try {
            PreparedStatement pstm = null;
            ResultSet rs = null;
            String query = "SELECT numero_cama FROM camas";

            pstm = connection.prepareStatement(query);
            //pstm.setInt(1, id_medico);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setNumero_cama(rs.getInt("numero_cama"));
                users.add(usuario);

            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return users;

    }

    public boolean diagnosticos(int folio, int numerocama, String medico, String diagnostico, String tratamiento) {
        try {
            PreparedStatement pstm = null;
            ResultSet rs = null;
            String query = "INSERT INTO diagnostico(folio, numero_cama, medico,diagnostico,tratamiento) VALUES (?,?,?,?,?)";
            pstm = connection.prepareStatement(query);
            pstm.setInt(1, folio);
            pstm.setInt(2, numerocama);
            pstm.setString(3, medico);
            pstm.setString(4, diagnostico);
            pstm.setString(5, tratamiento);
            if (pstm.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return false;
    }

    public int GetpacientesAtendidos(int id_medico) {

        int numeroPacientes = 0;

        try {
            PreparedStatement pstm = null;
            ResultSet rs = null;
            String query = "SELECT folio FROM paciente WHERE id_medico = ?";

            pstm = connection.prepareStatement(query);
            pstm.setInt(1, id_medico);
            rs = pstm.executeQuery();

            while (rs.next()) {
                numeroPacientes++;

            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return numeroPacientes;
    }

    public int getCamasDisponible() {

        int numeroCamas = 0;

        try {
            PreparedStatement pstm = null;
            ResultSet rs = null;
            String query = "SELECT numero_cama FROM camas";

            pstm = connection.prepareStatement(query);
            //pstm.setInt(1, id_medico);
            rs = pstm.executeQuery();

            while (rs.next()) {
                numeroCamas++;

            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return numeroCamas;

    }

    public List<Noticias> getnoticias() {

        List<Noticias> noticias = new ArrayList<Noticias>();

        try {
            PreparedStatement pstm = null;
            ResultSet rs = null;
            String query = "SELECT titulo,Descripcion FROM noticias";
            pstm = connection.prepareStatement(query);

            rs = pstm.executeQuery();

            while (rs.next()) {
                Noticias noticia = new Noticias();
                noticia.setNombreNoticia(rs.getString("titulo"));
                noticia.setDescripcion(rs.getString("Descripcion"));
                noticias.add(noticia);

            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return noticias;

    }

    public void addURLfromImageName(int id_persona, String archivo) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Images(id_persona,url) VALUES (?,?)");
            preparedStatement.setInt(1, id_persona);
            preparedStatement.setString(2, archivo);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getImageById(int urlId) {
        String urlImagen = null;//variable local temporal
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select url from images where id_persona = ?;");
            preparedStatement.setInt(1, urlId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                urlImagen = rs.getString("url");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return urlImagen;
    }

    public void Deleteurl(int Id_persona) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Images WHERE id_persona=?;");
            preparedStatement.setInt(1, Id_persona);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Doctor> getEspecialidad(int id_persona) {

        List<Doctor> users = new ArrayList<Doctor>();

        try {
            PreparedStatement pstm = null;
            ResultSet rs = null;
            String query = "SELECT especialidad FROM medicos WHERE id_medico= '" + id_persona + "'";

            pstm = connection.prepareStatement(query);

            rs = pstm.executeQuery();

            while (rs.next()) {
                Doctor usuario = new Doctor();
                usuario.setEspecialidad(rs.getString("especialidad"));
                users.add(usuario);

            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return users;

    }

    public boolean registroConexiones(int id_usuario, int id_rol) {
        try {
            PreparedStatement pstm = null;
            ResultSet rs = null;
            String query = "INSERT INTO conexiones(id_user, id_rol, fecha) VALUES (?,?,now())";
            pstm = connection.prepareStatement(query);
            pstm.setInt(1, id_usuario);
            pstm.setInt(2, id_rol);
            if (pstm.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return false;
    }

}
