package com.example.FW_ServerSideRender.controllers;

import com.example.FW_ServerSideRender.entities.Mensaje;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/app")
public class MensajeController {

    private List<Mensaje> mensajes;
    private Long nextId = 3L;

    public MensajeController() {
        // Inicialización de datos en memoria
        mensajes = new ArrayList<>();
        mensajes.add(Mensaje.builder().id(1L).titulo("Primer Mensaje SSR").texto("Esta es la lista renderizada en el servidor.").fecha(LocalDateTime.now()).build());
        mensajes.add(Mensaje.builder().id(2L).titulo("Ejemplo Thymeleaf").texto("Usamos Thymeleaf para generar el HTML.").fecha(LocalDateTime.now().minusHours(1)).build());
    }
    // ------------------------

    // LISTAR TODOS
    @GetMapping("/")
    public String listAll(Model model) {
        model.addAttribute("mensajes", mensajes);
        return "list";
    }

    // CREAR MENSAJE
    // GET /app/form
    @GetMapping("/form")
    public String showForm(Model model, @ModelAttribute("mensaje") Mensaje mensaje) {
        if (mensaje.getId() == null) {
            model.addAttribute("mensaje", new Mensaje());
        }
        model.addAttribute("accion","Nuevo mensaje");
        return "form";
    }

    // CARGAR FORMULARIO PARA EDICIÓN
        @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {

        Optional<Mensaje> mensajeOptional = mensajes.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst();

        if (mensajeOptional.isPresent()) {
            model.addAttribute("mensaje", mensajeOptional.get());
            model.addAttribute("accion","Actualizar mensaje");
            return "form"; // Reutiliza el mismo formulario
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Error: Mensaje con ID " + id + " no encontrado para editar.");
            return "redirect:/app/";
        }
    }

    // GUARDAR MENSAJE
        @PostMapping("/save")
    public String save(@ModelAttribute Mensaje mensaje, RedirectAttributes redirectAttributes) {

        if (mensaje.getId() == null) {
            // Lógica de CREACIÓN
            mensaje.setId(nextId++);
            mensaje.setFecha(LocalDateTime.now());
            mensajes.add(mensaje);
            redirectAttributes.addFlashAttribute("successMessage", "Mensaje con ID " + mensaje.getId() + " creado correctamente.");
        } else {
            // Lógica de EDICIÓN
            Optional<Mensaje> mensajeOptional = mensajes.stream()
                    .filter(m -> m.getId().equals(mensaje.getId()))
                    .findFirst();

            if (mensajeOptional.isPresent()) {
                Mensaje m = mensajeOptional.get();
                m.setTitulo(mensaje.getTitulo());
                m.setTexto(mensaje.getTexto());
                m.setFecha(LocalDateTime.now());
                redirectAttributes.addFlashAttribute("successMessage", "Mensaje con ID " + mensaje.getId() + " actualizado correctamente.");
            }
        }

        // Redirecciona al endpoint GET
        return "redirect:/app/";
    }

    // ELIMINAR
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {

        boolean fueEliminado = mensajes.removeIf(m -> m.getId().equals(id));

        if (fueEliminado) {
            redirectAttributes.addFlashAttribute("successMessage", "Mensaje con ID " + id + " eliminado correctamente.");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Error: Mensaje con ID " + id + " no encontrado.");
        }

        return "redirect:/app/";
    }
}