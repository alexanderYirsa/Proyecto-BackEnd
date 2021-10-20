package com.alexanderYirsa.app.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


@Entity
@Table (name = "productos")
public class Productos implements Serializable{

	private static final long serialVersionUID = 7120320736439742699L;
	@Id
	@Column(name="codigo_producto")
	private long codigo_producto;
	private String nombre_producto;
	
	@ManyToOne (optional = false)
	@JoinColumn(name = "proveedor_producto", referencedColumnName = "nit_proveedor")
	private Proveedores proveedor;
	
	private float precio_compra;
	private float iva_compra;
	private float precio_venta;
	
	@OneToMany(mappedBy = "producto")
	private List<DetalleVentas> producto_venta;
	
	//Getters and Setters
	public long getCodigo_producto() {
		return codigo_producto;
	}
	public void setCodigo_producto(long codigo_producto) {
		this.codigo_producto = codigo_producto;
	}
	public String getNombre_producto() {
		return nombre_producto;
	}
	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}
	public Proveedores getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedores proveedor) {
		this.proveedor = proveedor;
	}
	public float getPrecio_compra() {
		return precio_compra;
	}
	public void setPrecio_compra(float precio_compra) {
		this.precio_compra = precio_compra;
	}
	public float getIva_compra() {
		return iva_compra;
	}
	public void setIva_compra(float iva_compra) {
		this.iva_compra = iva_compra;
	}
	public float getPrecio_venta() {
		return precio_venta;
	}
	public void setPrecio_venta(float precio_venta) {
		this.precio_venta = precio_venta;
	}

}
