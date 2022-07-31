package br.com.anderson.rhsolutionAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.anderson.rhsolutionAPI.dto.DtoDepartamentoPessoal;
import br.com.anderson.rhsolutionAPI.form.FormDepartamento;
import br.com.anderson.rhsolutionAPI.model.DepartamentoPessoal;
import br.com.anderson.rhsolutionAPI.model.Funcionario;
import br.com.anderson.rhsolutionAPI.repository.DepartamentoPessoalRepository;
import br.com.anderson.rhsolutionAPI.repository.FuncionarioRepository;

@Service
public class DepartamentoPessoalService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private DepartamentoPessoalRepository departamentoPessoalRepository;

    public List<DtoDepartamentoPessoal> listarDepartamentos() {
    	List<DepartamentoPessoal> listaFuncionarios = departamentoPessoalRepository.findAll();
        return DtoDepartamentoPessoal.converte(listaFuncionarios);
    }

    public void excluirDepartamentoById(Long id) {
        List<Funcionario> funcionarios = funcionarioRepository.findByDepartamentoPessoalId(id);

        if (!funcionarios.isEmpty()) {
            throw new RuntimeException("Por favor, exclua primeiro os funcionários do departamento.");
        }

        departamentoPessoalRepository.deleteById(id);
    }

    public Optional<DepartamentoPessoal> buscarDepartamentoById(Long id) {
        return departamentoPessoalRepository.findById(id);
    }
    
    public DepartamentoPessoal buscarDepartamentoByNome(String departamento) {
        return departamentoPessoalRepository.findByNome(departamento);
    }
    
    /*
    public List<DepartamentoPessoal> findByNomeLista(String departamento) {
        return departamentoPessoalRepository.findByNome(departamento);
    }*/
    
    public void excluirDepartamento(Long id) {
        departamentoPessoalRepository.deleteById(id);
    }

    public DepartamentoPessoal salvarDepartamento(DepartamentoPessoal departamentoPessoal) {
        return departamentoPessoalRepository.save(departamentoPessoal);
    }
    
    public DepartamentoPessoal atualizarDepartamento(Long id, FormDepartamento dto) {
        Optional<DepartamentoPessoal> listaDepartamento = buscarDepartamentoById(id);
        try {
        	DepartamentoPessoal departamento = listaDepartamento.get();
        	departamento.setNome(dto.getNome());
	        return departamentoPessoalRepository.save(departamento);
        }catch(Exception ex) {
        	ex.printStackTrace();
    
        }
        	 return null;  
       
        
    }

}
