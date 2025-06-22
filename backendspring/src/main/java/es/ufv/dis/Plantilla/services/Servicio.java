package es.ufv.dis.back.final2025.FGP.services;

import es.ufv.dis.back.final2025.FGP.inputOutput.InputOutput;
import es.ufv.dis.back.final2025.FGP.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class Servicio {

    public ArrayList<Usuario> getAllUsuarios() {
        InputOutput io = new InputOutput();
        return io.leerUsuario("usuarios.json");
    }

    public Usuario getUsuarioByID(String id) {
        InputOutput io = new InputOutput();
        ArrayList<Usuario> usuarios = io.leerUsuario("usuarios.json");
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                return usuario;
            }
        }
        return null;
    }
    public ArrayList <Usuario> crearUsuario(Usuario usuario) {
        InputOutput io = new InputOutput();
        ArrayList<Usuario> usuarios = io.leerUsuario("usuarios.json");
        usuarios.add(usuario);
        return io.escribirUsuario("usuarios.json", usuarios);
    }

    public Usuario updateUsuario(String id, Usuario usuario) {
        InputOutput io = new InputOutput();
        ArrayList<Usuario> usuarios = io.leerUsuario("usuarios.json");
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId().equals(id)) {
                usuarios.set(i, usuario);
                io.escribirUsuario("usuarios.json",usuarios);
                return usuario;
            }
        }
        return null;
    }
    public Boolean deleteUsuario(String id) {
        InputOutput io = new InputOutput();
        ArrayList<Usuario> usuarios = io.leerUsuario("usuarios.json");
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId().equals(id)) {
                usuarios.remove(i);
                io.escribirUsuario("usuarios.json",usuarios);
                return true;
            }
        }
        return false;
    }
}
