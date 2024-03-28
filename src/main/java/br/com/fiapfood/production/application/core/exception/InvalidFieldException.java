package br.com.fiapfood.production.application.core.exception;

import br.com.fiapfood.production.adapter.dto.request.exceptions.ErrorMessage;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Builder
@Data
public class InvalidFieldException extends RuntimeException {
    String message;
    List<ErrorMessage.CauseError> causeErrorList;
}
