package br.com.teste.concrete.exceptions;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.teste.concrete.service.CadastroService;

@ControllerAdvice
public class ExceptionController {
	private final Logger logger = Logger.getLogger(CadastroService.class);

	@ExceptionHandler(CadastroException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public <T> ResponseEntity<T> handleCustomException(CadastroException ex) {
		logger.error("EnderecoException: " + ex.getMessage());
		return new ResponseEntity<T>((T) ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(CampoObrigatorioException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public <T> ResponseEntity<T> handleCustomException(CampoObrigatorioException ex) {
		logger.error("CampoObrigatorioException: " + ex.getMessage());
		if (ex.getBindingResult() != null)
			return new ResponseEntity<T>((T) ex.getBindingResult().getAllErrors(), HttpStatus.INTERNAL_SERVER_ERROR);

		return new ResponseEntity<T>((T) ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
