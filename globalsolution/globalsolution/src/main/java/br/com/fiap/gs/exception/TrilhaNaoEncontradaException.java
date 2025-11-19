package br.com.fiap.gs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TrilhaNaoEncontradaException extends RuntimeException {

    public TrilhaNaoEncontradaException(Long id) {
        super("Trilha não encontrada com o ID: " + id);
    }
}