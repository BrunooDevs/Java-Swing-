package classes;

public class Usuario {

    private int id_persona, id_rol;

    //VARIABLES DE INFORMACION BASICA DEL USUARIO TABLA PERSONAS
    private String username, password, repetirpassword, nombre, apellidos, fecha_nac, tel, correo, domicilio,
            usuario, registeredon;
    private String name_rol, permisos, url;

    //Tabla Paciente atributos
    private int folio, id_medico;
    private String numero_ss, INE;

    //Tabla Camas
    private int numero_cama, id_planta;
    private String caracteristicas;
    private boolean oxigeno, termometro;

    //tabla agendar cita atributos
    //private int folio (ya lo tengo declarado el atributo)
    private String fecha, hora, especialidad, sintomas;
    private boolean estado;


    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepetirpassword() {
        return repetirpassword;
    }

    public void setRepetirpassword(String repetirpassword) {
        this.repetirpassword = repetirpassword;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getRegisteredon() {
        return registeredon;
    }

    public void setRegisteredon(String registeredon) {
        this.registeredon = registeredon;
    }

    public String getName_rol() {
        return name_rol;
    }

    public void setName_rol(String name_rol) {
        this.name_rol = name_rol;
    }

    public String getPermisos() {
        return permisos;
    }

    public void setPermisos(String permisos) {
        this.permisos = permisos;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    //ATRIBUTOS DE LA TABLA PACIENTE
    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }

    public String getNumero_ss() {
        return numero_ss;
    }

    public void setNumero_ss(String numero_ss) {
        this.numero_ss = numero_ss;
    }

    public String getINE() {
        return INE;
    }

    public void setINE(String INE) {
        this.INE = INE;
    }

    public int getNumero_cama() {
        return numero_cama;
    }

    public void setNumero_cama(int numero_cama) {
        this.numero_cama = numero_cama;
    }

    public int getId_planta() {
        return id_planta;
    }

    public void setId_planta(int id_planta) {
        this.id_planta = id_planta;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public boolean isOxigeno() {
        return oxigeno;
    }

    public void setOxigeno(boolean oxigeno) {
        this.oxigeno = oxigeno;
    }

    public boolean isTermometro() {
        return termometro;
    }

    public void setTermometro(boolean termometro) {
        this.termometro = termometro;
    }

    //SET Y GET DE LA TABLA agendarcita
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }


}
