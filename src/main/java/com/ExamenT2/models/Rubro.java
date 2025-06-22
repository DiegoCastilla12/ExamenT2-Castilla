package com.ExamenT2.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tbl_rubro")
public class Rubro {
	@Id
	@Column(name = "id_rubro")
	private int idRubro;
	
	@Column(name = "denominacion")
	private String denominacion;
	
	public String toString() { 
        return denominacion;
    }
}
