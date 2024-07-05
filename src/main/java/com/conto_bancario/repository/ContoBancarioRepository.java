package com.conto_bancario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conto_bancario.pojo.ContoBancario;

public interface ContoBancarioRepository extends JpaRepository<ContoBancario, Integer> {


}
