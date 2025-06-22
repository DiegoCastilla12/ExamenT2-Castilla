package com.ExamenT2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ExamenT2.models.Compra;

public interface ICompraRepository extends JpaRepository<Compra, Integer> {
	List<Compra> findAllByOrderByNroOrdenDesc();
}
