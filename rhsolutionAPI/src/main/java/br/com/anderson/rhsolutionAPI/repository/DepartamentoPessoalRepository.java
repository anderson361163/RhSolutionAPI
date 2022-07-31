package br.com.anderson.rhsolutionAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.anderson.rhsolutionAPI.model.DepartamentoPessoal;

@Repository
public interface DepartamentoPessoalRepository extends JpaRepository<DepartamentoPessoal, Long> {

	DepartamentoPessoal findByNome(String departamento);
	
	//List<DepartamentoPessoal> findByNomeLista(String departamento);

}
