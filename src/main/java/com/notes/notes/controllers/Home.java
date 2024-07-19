package com.notes.notes.controllers;

import com.notes.notes.models.Notascreada;
import com.notes.notes.models.Usuario;
import com.notes.notes.services.NotasCreadaService;
import com.notes.notes.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@Controller
public class Home {

    @Autowired
    private NotasCreadaService notasCreadaService;

    @Autowired
    private UsuarioService usuarioService;



    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("nota", new Notascreada());
        model.addAttribute("accion",notasCreadaService.todaNotas());
        model.addAttribute("usuarios", usuarioService.TodosUsuario());
        return "index";
    }

    @PostMapping("/")
    public String guardadBD(@RequestParam("idUsuario") Integer idUsuario, Notascreada notascreada, Model model){
        Optional<Usuario> usuarioOptional = usuarioService.usuarioId(idUsuario);

        if (usuarioOptional.isPresent()) {
            notascreada.setIdUsuario(usuarioOptional.get());
            notasCreadaService.guardarNota(notascreada);
            return "redirect:/";
        } else {
            model.addAttribute("error", "Usuario no encontrado");
            return "index";
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarNota(@PathVariable Integer id) {
        try {
            notasCreadaService.eliminarNota(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al eliminar la nota");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarNota(@PathVariable Integer id, @RequestBody Map<String, Object> updates) {
        Optional<Notascreada> notaOptional = notasCreadaService.notasId(id);

        if (notaOptional.isPresent()) {
            Notascreada notaExistente = notaOptional.get();
            if (updates.containsKey("completado")) {
                notaExistente.setCompletado((Boolean) updates.get("completado"));
            }
            // Actualizar otros campos si es necesario
            Notascreada notaActualizada = notasCreadaService.ActualizarNota(notaExistente);
            return ResponseEntity.ok(notaActualizada);
        }

        return ResponseEntity.status(404).body("Nota no encontrada");
    }
}
