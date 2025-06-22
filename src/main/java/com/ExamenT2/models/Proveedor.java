package com.ExamenT2.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tbl_proveedor")
public class Proveedor {

	@Id
	@Column(name = "id_proveedor")
	private Integer idProveedor;
	
	@Column(name = "ruc")
	private String ruc;
	
	@Column(name = "razon_social")
	private String razonSocial;
	
	@Column(name = "fecha_registro")
	private LocalDate fechaRegistro;
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "pagina_web")
	private String paginaWeb;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_rubro")
	private Rubro rubro;
	
	
}
