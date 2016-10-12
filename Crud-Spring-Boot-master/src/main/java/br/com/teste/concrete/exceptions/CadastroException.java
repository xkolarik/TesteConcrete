package br.com.teste.concrete.exceptions;

public class CadastroException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CadastroException() {
		super();
	}

	public CadastroException(String pMensagem) {
		super(pMensagem);
	}

	public CadastroException(Throwable pException) {
		super(pException);
	}

	public CadastroException(String pMensagem, Throwable pException) {
		super(pMensagem, pException);
	}
}
