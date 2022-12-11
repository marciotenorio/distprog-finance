package br.imd.distprog.finance.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.ResourceAccessException;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class UnavailableResourceException extends ResourceAccessException {
    public UnavailableResourceException(String msg) {
        super(msg);
    }
}
