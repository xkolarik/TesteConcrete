package br.com.teste.concrete.service;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.teste.concrete.entity.Usuario;
import br.com.teste.concrete.exceptions.CadastroException;
import br.com.teste.concrete.repository.CadastroRepository;
import br.com.teste.concrete.utils.Util;

@Service
public class CadastroService implements CadastroServiceInterface {

	private final Logger logger = Logger.getLogger(CadastroService.class);

	@Autowired
	private CadastroRepository cadastroRepository;

	@Override
	public ResponseEntity<?> incluir(Usuario user) throws CadastroException {
		logger.info("Cadastrando...");

		Usuario userB = cadastroRepository.findByEmail(user.getEmail());

		if (userB.getEmail().equals(user.getEmail())) {
			return new ResponseEntity<>(Util.MessageErro, HttpStatus.CONFLICT);
		}

		cadastroRepository.save(user);
		return new ResponseEntity<Usuario>(user, HttpStatus.CREATED);

	}

	@Override
	public Usuario findByEmail(String email) {
		return cadastroRepository.findByEmail(email);
	}

}
