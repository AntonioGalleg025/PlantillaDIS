package es.ufv.dis.back.final2025.FGP.controllers;

import es.ufv.dis.back.final2025.FGP.model.Usuario;
import es.ufv.dis.back.final2025.FGP.services.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/api/ExamenFinal")
public class MainController {

    private final Servicio servicio;

    @Autowired
    public MainController(Servicio servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/Usuario")
    public ArrayList<Usuario> getAllTurismo() {
        return servicio.getAllUsuarios();
    }

    @GetMapping("/Usuario/{id}")
    public ResponseEntity <Usuario> getTurismolByTo(@PathVariable String id) {
        return ResponseEntity.ok(servicio.getUsuarioByID(id));
    }
    @PostMapping("/Usuario")
    public ResponseEntity <ArrayList<Usuario>> createTurismo(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(servicio.crearUsuario(usuario));
    }
    @PutMapping("/Usuario/{id}")
    public ResponseEntity <Usuario> updateTurismo(@PathVariable String id, @RequestBody Usuario turismo) {
        return ResponseEntity.ok(servicio.updateUsuario(id, turismo));
    }
    @DeleteMapping("/Usuario/{id}")
    public ResponseEntity <Boolean> deleteTurismo(@PathVariable String id) {
        return ResponseEntity.ok(servicio.deleteUsuario(id));
    }
}
