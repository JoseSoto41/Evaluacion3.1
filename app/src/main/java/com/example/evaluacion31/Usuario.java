package com.example.evaluacion31;

public class Usuario {
    int id;
    String Nombre, Apellido, Usuario, Password;

    public Usuario( ) {

    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", Nombre='" + Nombre + '\'' +
                ", Apellido='" + Apellido + '\'' +
                ", Usuario='" + Usuario + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Usuario(String nombre, String apellido, String usuario, String password){
        Nombre = nombre;
        Apellido = apellido;
        Usuario = usuario;
        Password = password;        
    }
    
    public Boolean isNull () {
        if (Nombre.equals("")&&Apellido.equals("")&&Usuario.equals("")&&Password.equals("")) {
            return false;
        }else {
            return true;
        }
    }
    }

