package br.com.anderson.rhsolutionAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.anderson.rhsolutionAPI.form.FormFuncionario;
import br.com.anderson.rhsolutionAPI.model.DepartamentoPessoal;
import br.com.anderson.rhsolutionAPI.model.Funcionario;
import br.com.anderson.rhsolutionAPI.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private DepartamentoPessoalService departamentoPessoalService;

    public List<Funcionario> listarTodosFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public Optional<Funcionario> buscarFuncionarioById(Long id) {
        return funcionarioRepository.findById(id);
    }

    public List<Funcionario> listaFuncionariosDoDepartamentoById(Long id) {
        return funcionarioRepository.findByDepartamentoPessoalId(id);
    }
    
    /*
    public Funcionario salvarFuncionario(DtoFuncionario funcionarioDTO) {
        DepartamentoPessoal departamentoPessoal = departamentoPessoalService.buscarDepartamentoById(funcionarioDTO.getDepartamentoPessoal());

        Funcionario funcionario = FuncionarioMapper.toModel(funcionarioDTO);
        funcionario.setDepartamentoPessoal(departamentoPessoal);

        return funcionarioRepository.save(funcionario);
    }*/

  public Funcionario salvarFuncionario(Long id, Funcionario formfuncionario) {
    	
        Optional<Funcionario> funcionarioLocalizado = buscarFuncionarioById(id);
        	if(funcionarioLocalizado.isPresent()) {
        		Funcionario funcionario = funcionarioLocalizado.get();
        		DepartamentoPessoal departamentoPessoal = departamentoPessoalService.buscarDepartamentoByNome(formfuncionario.getDepartamentoPessoal().getNome());
        		
		        funcionario.setCpf(formfuncionario.getCpf());
		        funcionario.setNome(formfuncionario.getNome());
		        funcionario.setSalario(formfuncionario.getSalario());
		        funcionario.setDataNascimento(formfuncionario.getDataNascimento());
		        funcionario.setDepartamentoPessoal(departamentoPessoal);
		        return funcionarioRepository.save(funcionario);
        	}
		        
        	return new Funcionario();
    }
    
    
    public Funcionario salvarFuncionario(Long id, FormFuncionario formfuncionario) {
    	
        Optional<Funcionario> funcionarioLocalizado = buscarFuncionarioById(id);
        	if(funcionarioLocalizado.isPresent()) {
        		Funcionario funcionario = funcionarioLocalizado.get();
        		DepartamentoPessoal departamentoPessoal = departamentoPessoalService.buscarDepartamentoByNome(formfuncionario.getNomeDepartamentoPessoal());
        		
		        funcionario.setCpf(formfuncionario.getCpf());
		        funcionario.setNome(formfuncionario.getNome());
		        funcionario.setSalario(formfuncionario.getSalario());
		        funcionario.setDataNascimento(formfuncionario.getDataNascimento());
		        funcionario.setDepartamentoPessoal(departamentoPessoal);
		        return funcionarioRepository.save(funcionario);
        	}
		        
        	return new Funcionario();
    }

    public void excluirFuncionarioById(Long id) {
        funcionarioRepository.deleteById(id);
    }

}
