package br.edu.unichristus.exception;
import org.springframework.http.ResponseEntity;

import java.io.Serial;

import br.edu.unichristus.domain.dto.MessageDTO;
import org.springframework.http.HttpStatus;

public class CommonsException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    protected HttpStatus status;
    protected String key;
    protected String text;

    public ResponseEntity<MessageDTO> getMessageError() {
        return ResponseEntity.status(status).body(new MessageDTO(text, key));
    }

    public CommonsException(HttpStatus status, String key, String text) {
        this.status = status;
        this.key = key;
        this.text = text;
    }
}


