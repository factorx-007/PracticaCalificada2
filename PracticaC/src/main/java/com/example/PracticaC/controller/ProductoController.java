package com.example.PracticaC.controller;

import com.example.PracticaC.models.Producto;
import com.example.PracticaC.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.Optional;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductsRepository repo;

    @GetMapping({"", "/"})
    public String showProductList(Model model) {
        model.addAttribute("productos", repo.findAll(Sort.by(Sort.Direction.DESC, "idProducto")));
        return "productos/index";
    }

    @GetMapping("/crear")
    public String showCreatePage(Model model) {
        model.addAttribute("producto", new Producto());
        return "productos/crearProducto";
    }

    @PostMapping("/crear")
    public String createProduct(
            @Valid @ModelAttribute Producto producto,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "productos/crearProducto";
        }

        repo.save(producto);
        return "redirect:/productos";
    }

    @GetMapping("/editar")
    public String showEditPage(
            Model model,
            @RequestParam Long idProducto
    ) {
        Optional<Producto> optionalProducto = repo.findById(idProducto);
        if (optionalProducto.isEmpty()) {
            return "redirect:/productos";
        }

        model.addAttribute("producto", optionalProducto.get());
        return "productos/editarProducto";
    }

    @PostMapping("/editar")
    public String updateProduct(
            @RequestParam Long idProducto,
            @Valid @ModelAttribute Producto producto,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "productos/editarProducto";
        }

        producto.setIdProducto(idProducto);
        repo.save(producto);
        return "redirect:/productos";
    }

    @GetMapping("/eliminar")
    public String deleteProduct(@RequestParam Long idProducto) {
        Optional<Producto> optionalProducto = repo.findById(idProducto);
        if (optionalProducto.isEmpty()) {
            return "redirect:/productos";
        }

        repo.delete(optionalProducto.get());
        return "redirect:/productos";
    }
}
