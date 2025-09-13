package com.iep.mycompany.app.enums;

import com.iep.commons.enums.SubBaseErrorCode;
import org.springframework.http.HttpStatus;

public enum ErrorGeneral implements SubBaseErrorCode {

    ERROR_NOT_FOUND("registro no encontrado",HttpStatus.NOT_FOUND),
    ERROR_SERVICE("servicio no disponible por el momento",HttpStatus.INTERNAL_SERVER_ERROR);

    private String message;
    private HttpStatus httpStatus;

    ErrorGeneral(final String message, final HttpStatus httpStatus){
        this.message=message;
        this.httpStatus=httpStatus;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
