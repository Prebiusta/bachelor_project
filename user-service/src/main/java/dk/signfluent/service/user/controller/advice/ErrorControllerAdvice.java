package dk.signfluent.service.user.controller.advice;

import dk.signfluent.service.user.model.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    protected ResponseEntity<BaseResponse> handleConflict(RuntimeException ex, WebRequest request) {
        return new ResponseEntity<>(BaseResponse.createFailed(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
