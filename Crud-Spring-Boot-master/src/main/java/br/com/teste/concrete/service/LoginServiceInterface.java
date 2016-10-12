package br.com.teste.concrete.service;

import javax.security.auth.login.LoginException;

import org.springframework.http.ResponseEntity;

import br.com.teste.concrete.entity.Login;
import br.com.teste.concrete.entity.Usuario;
import br.com.teste.concrete.exceptions.CampoObrigatorioException;

public interface LoginServiceInterface {

	ResponseEntity<?> login(Usuario login) throws CampoObrigatorioException, LoginException;

}
