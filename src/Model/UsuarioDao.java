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

public class UsuarioDao {

    private Connection connection;

    public UsuarioDao() {
        connection = Database.getConnection();
    }//fin del 

    public Permisos obtenerPermisos(String user) {
        try {
            PreparedStatement pstm = null;
            ResultSet rs = null;
            String query = "SELECT * FROM permisos WHERE id_permiso IN (SELECT id_permiso FROM roles as r INNER JOIN usuario as u ON r.ID_Rol = u.id_rol WHERE u.username = ?);";
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

    public Usuario GetInformacionUsuario(int id_persona) {
        try {
            PreparedStatement pstm = null;
            ResultSet rs = null;
            String query = "SELECT * FROM personas WHERE id_persona= '" + id_persona + "'";
            pstm = connection.prepareStatement(query);
            rs = pstm.executeQuery();
            if (rs.next()) {
                Usuario usuario = new Usuario();
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

    public void updateUser(Usuario user, int id_persona) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE personas SET nombre=?, apellidos=?, fecha_nac=?, tel=?, correo=?, domicilio=? WHERE id_persona = ?;");
            preparedStatement.setString(1, user.getNombre());
            preparedStatement.setString(2, user.getApellidos());
            preparedStatement.setString(3, user.getFecha_nac());
            preparedStatement.setString(4, user.getTel());
            preparedStatement.setString(5, user.getCorreo());
            preparedStatement.setString(6, user.getDomicilio());
            //quitar la fecha porque es de solo lectura en user.jsp
            preparedStatement.setInt(7, id_persona);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Usuario> getFolios(int id_persona) {

        List<Usuario> users = new ArrayList<Usuario>();

        try {
            PreparedStatement pstm = null;
            ResultSet rs = null;
            String query = "SELECT folio FROM paciente WHERE id_persona = ?";

            pstm = connection.prepareStatement(query);
            pstm.setInt(1, id_persona);
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

    public List<Doctor> getAllEspecialidades() {

        List<Doctor> users = new ArrayList<Doctor>();

        try {
            PreparedStatement pstm = null;
            ResultSet rs = null;
            String query = "SELECT especialidad FROM medicos";

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

    public ArrayList<Usuario> getAllUsersCitas(int id_persona) {

        ArrayList<Usuario> users = new ArrayList<Usuario>();

        try {
            PreparedStatement pstm = null;
            ResultSet rs = null;
            String query = "SELECT * FROM agendarcita as citas INNER JOIN paciente as persona ON citas.folio = persona.folio WHERE persona.id_persona= '" + id_persona + "'";

            pstm = connection.prepareStatement(query);

            rs = pstm.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setFolio(rs.getInt("folio"));
                usuario.setFecha(rs.getString("fecha"));
                usuario.setHora(rs.getString("hora"));
                usuario.setEspecialidad(rs.getString("especialidad"));
                usuario.setSintomas(rs.getString("sintomas"));
                usuario.setEstado(rs.getBoolean("estado"));
                users.add(usuario);

            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return users;

    }

    public int getIdMedico(String especialidad) {
        int id_medico = 0;
        try {
            PreparedStatement pstm = null;
            ResultSet rs = null;
            String query = "SELECT id_medico FROM medicos WHERE especialidad = ?";
            pstm = connection.prepareStatement(query);
            pstm.setString(1, especialidad);
            rs = pstm.executeQuery();
            if (rs.next()) {
                id_medico = rs.getInt("id_medico");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return id_medico;
    }

    public boolean AltaCita(int id_persona, int id_medico, String nombre, String apelldos, String numeross, String INE,
            String fecha, String hora, String especialidad, String sintomas) {

        int claveGenerada = 0;

        try {

            PreparedStatement pstm = null;

            pstm = connection.prepareStatement("INSERT INTO paciente(id_persona,id_medico,nombre, Apellidos,numero_ss,INE) VALUES (?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);

            pstm.setInt(1, id_persona);
            pstm.setInt(2, id_medico);
            pstm.setString(3, nombre);
            pstm.setString(4, apelldos);
            pstm.setString(5, numeross);
            pstm.setString(6, INE);

            int verificar = pstm.executeUpdate();

            if (verificar > 0) {

                Statement stmt;
                stmt = connection.createStatement();
                stmt.executeUpdate("INSERT INTO agendarcita (folio,fecha,hora,especialidad,sintomas,estado) VALUES ((select MAX(folio) from paciente),'" + fecha + "', '" + hora + "' ,'" + especialidad + "' ,'" + sintomas + "' ,'" + 0 + "');");

                return true;

            } else {
                return false;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }

    public int NumeroDiagnosticos(int id_persona) {

        int numeroDiagnosticos = 0;

        try {

            PreparedStatement pstm = null;
            ResultSet rs = null;
            String query = "SELECT * FROM diagnostico WHERE folio IN (SELECT folio FROM paciente as r WHERE r.id_persona = ?);";

            // String query = "SELECT * FROM diagnostico WHERE folio= '" + 3 + "'";
            pstm = connection.prepareStatement(query);
            pstm.setInt(1, id_persona);
            rs = pstm.executeQuery();

            while (rs.next()) {
                numeroDiagnosticos++;

            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return numeroDiagnosticos;

    }

    public int TotalCitas(int id_persona) {

        int TotalCitas = 0;

        try {
            PreparedStatement pstm = null;
            ResultSet rs = null;
            String query = "SELECT * FROM agendarcita as citas INNER JOIN paciente as persona ON citas.folio = persona.folio WHERE persona.id_persona= '" + id_persona + "'";

            pstm = connection.prepareStatement(query);

            rs = pstm.executeQuery();

            while (rs.next()) {
                TotalCitas++;

            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return TotalCitas;

    }

    public String EspecialidadConcurrente(int id_persona) {

        String EspecialidadC = "";
        int contador = 0;

        try {
            PreparedStatement pstm = null;
            ResultSet rs = null;

            String query = "SELECT especialidad, COUNT( especialidad ) AS total FROM  agendarcita as citas INNER JOIN paciente as persona ON citas.folio = persona.folio WHERE persona.id_persona=? GROUP BY especialidad ORDER BY total DESC";
            pstm = connection.prepareStatement(query);

            pstm.setInt(1, id_persona);
            rs = pstm.executeQuery();

            if (rs.next()) {

                EspecialidadC = rs.getString("especialidad");

            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return EspecialidadC;

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

    public List<Usuario> getDiagnosticos(int id_persona) {

        List<Usuario> users = new ArrayList<Usuario>();

        try {

            PreparedStatement pstm = null;
            ResultSet rs = null;
            String query = "SELECT * FROM diagnostico WHERE folio IN (SELECT folio FROM paciente as r WHERE r.id_persona = ?);";

            // String query = "SELECT * FROM diagnostico WHERE folio= '" + 3 + "'";
            pstm = connection.prepareStatement(query);
            pstm.setInt(1, id_persona);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setFolio(rs.getInt("folio"));
                usuario.setNumero_cama(rs.getInt("numero_cama"));
                usuario.setNombre(rs.getString("medico"));
                usuario.setSintomas(rs.getString("diagnostico"));
                usuario.setEspecialidad(rs.getString("tratamiento"));
                users.add(usuario);
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return users;

    }

}
