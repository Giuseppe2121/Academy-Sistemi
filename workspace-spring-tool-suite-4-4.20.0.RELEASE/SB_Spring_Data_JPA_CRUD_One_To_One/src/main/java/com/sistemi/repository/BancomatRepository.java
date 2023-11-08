package com.sistemi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemi.entity.Bancomat;

public interface BancomatRepository extends JpaRepository<Bancomat, String> {
	
	

}
