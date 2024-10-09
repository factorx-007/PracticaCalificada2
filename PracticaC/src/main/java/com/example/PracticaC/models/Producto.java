package com.example.PracticaC.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    @NotNull
    @Size(min = 1, max = 100)
    private String nombre;

    @NotNull
    @Min(0)
    private Integer stock;

    @Column(name = "precio_compra")
    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    private Double precioCompra;

    @Column(name = "precio_venta")
    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    private Double precioVenta;

    // Nueva propiedad para descripción
    @Size(max = 255) // Puedes ajustar la longitud según tus necesidades
    private String descripcion;

    // Constructor sin argumentos
    public Producto() {
    }

    // Constructor completo
    public Producto(String nombre, Integer stock, Double precioCompra, Double precioVenta, String descripcion) {
        this.nombre = nombre;
        this.stock = stock;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.descripcion = descripcion;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", nombre='" + nombre + '\'' +
                ", stock=" + stock +
                ", precioCompra=" + precioCompra +
                ", precioVenta=" + precioVenta +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
