package br.com.alvaro.GestaoVagas.Exception;

public class UserFoundedException extends RuntimeException {
	public UserFoundedException(String message) {
        super(message);
    }
}
