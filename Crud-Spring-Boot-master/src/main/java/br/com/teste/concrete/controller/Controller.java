package br.com.teste.concrete.controller;

import javax.security.auth.login.LoginException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.concrete.entity.Login;
import br.com.teste.concrete.entity.Usuario;
import br.com.teste.concrete.exceptions.CadastroException;
import br.com.teste.concrete.exceptions.CampoObrigatorioException;
import br.com.teste.concrete.service.CadastroService;
import br.com.teste.concrete.service.LoginService;
import br.com.teste.concrete.service.LoginServiceInterface;
import br.com.teste.concrete.utils.Util;

@RestController
public class Controller {

	@Autowired
	private CadastroService cadastroService;
	private LoginService loginService;

	private final Logger logger = Logger.getLogger(CadastroService.class);

	@ResponseBody
	@RequestMapping(value = "/api/cadastro", method = RequestMethod.POST)
	public ResponseEntity<?> cadastro(@RequestBody Usuario user, BindingResult bindingResult) throws CadastroException {
		logger.info("Cadastrando...");

		Usuario userB = cadastroService.findByEmail(user.getEmail());

		if (userB.getEmail().equals(user.getEmail())) {
			return new ResponseEntity<>(Util.MessageErro, HttpStatus.CONFLICT);
		}

		cadastroService.incluir(user);
		return new ResponseEntity<Usuario>(user, HttpStatus.CREATED);

	}

	@ResponseBody
	@RequestMapping(value = "/api/login", method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody Usuario user) throws LoginException, CampoObrigatorioException {
		logger.info("Rest login");
		return loginService.login(user);
	}

	@Transactional
	@RequestMapping(value = "/api", method = RequestMethod.GET)
	public @ResponseBody String listar() {
		return "hi";
	}

}
