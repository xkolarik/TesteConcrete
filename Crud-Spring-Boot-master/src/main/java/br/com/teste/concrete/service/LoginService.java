package br.com.teste.concrete.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.teste.concrete.entity.Login;
import br.com.teste.concrete.entity.Usuario;
import br.com.teste.concrete.repository.CadastroRepository;
import br.com.teste.concrete.utils.Util;

public class LoginService implements LoginServiceInterface {

	@Autowired
	private CadastroRepository cadastroRepository;

	@Override
	public ResponseEntity<?> login(@RequestBody Usuario user) {

		Usuario userB = cadastroRepository.findByEmail(user.getEmail());

		if (userB.getEmail().equalsIgnoreCase(user.getEmail())) {
			if (userB.getPassword().equals(user.getPassword())) {

				userB.setLast_login(Calendar.getInstance());
				cadastroRepository.save(userB);

				return new ResponseEntity<Usuario>(userB, HttpStatus.OK);
			}
			return new ResponseEntity(Util.LoginMessage, HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity(Util.LoginMessage, HttpStatus.NOT_FOUND);
	}
}
