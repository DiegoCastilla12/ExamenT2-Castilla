package com.ExamenT2.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tbl_orden_compra")
public class Compra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nro_orden")
	private Integer nroOrden;
	
	@Column(name = "monto", nullable = false)
	private Double monto;
	
	@Column(name = "direccion_entrega", nullable = false)
	private String direccionEntrega;
	
	@Column(name = "fecha_entrega", nullable = false)
	private LocalDate fechaEntrega;
	
	@Column(name = "estado", nullable = false)
	private String estado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_proveedor")
	private Proveedor proveedor;
}
