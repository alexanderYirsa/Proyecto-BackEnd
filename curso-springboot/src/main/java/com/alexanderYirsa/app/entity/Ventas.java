package com.alexanderYirsa.app.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table (name = "ventas")
public class Ventas {
	@Id
	@Column(name="codigo_venta")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo_venta;
	
	@ManyToOne (optional = false)
	@JoinColumn(name = "cliente_venta", referencedColumnName = "cedula_cliente")
	private Clientes cliente;

	@ManyToOne (optional = false)
	@JoinColumn(name = "usuario_venta", referencedColumnName = "cedula_usuario")
	private Usuarios usuario;

	private float subtotal_venta;
	private long ivaventa;
	private long total_venta;
	
	//@OneToMany(mappedBy = "venta")
	//private List<DetalleVentas> codigo_venta_detalle;

	//Getters and Setters
	public long getCodigo_venta() {
		return codigo_venta;
	}
	public void setCodigo_venta(long codigo_venta) {
		this.codigo_venta = codigo_venta;
	}
	public Clientes getCliente() {
		return cliente;
	}
	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}
	public Usuarios getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}
	public float getSubtotal_venta() {
		return subtotal_venta;
	}
	public void setSubtotal_venta(float subtotal_venta) {
		this.subtotal_venta = subtotal_venta;
	}
	public long getIvaventa() {
		return ivaventa;
	}
	public void setIvaventa(long ivaventa) {
		this.ivaventa = ivaventa;
	}
	public long getTotal_venta() {
		return total_venta;
	}
	public void setTotal_venta(long total_venta) {
		this.total_venta = total_venta;
	}
	
}
