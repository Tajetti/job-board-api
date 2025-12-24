package br.com.alvaro.GestaoVagas.Modules.Exception;

public class UserFoundedException extends RuntimeException {
	public UserFoundedException(String message) {
        super(message);
    }
}
