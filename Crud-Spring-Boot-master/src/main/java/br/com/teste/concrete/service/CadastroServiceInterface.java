package br.com.teste.concrete.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import br.com.teste.concrete.entity.Usuario;
import br.com.teste.concrete.exceptions.CadastroException;
import br.com.teste.concrete.exceptions.CampoObrigatorioException;

public interface CadastroServiceInterface {

	ResponseEntity<?> incluir(Usuario user) throws CampoObrigatorioException, CadastroException;

	Usuario findByEmail(String email) throws CampoObrigatorioException, CadastroException;

}
