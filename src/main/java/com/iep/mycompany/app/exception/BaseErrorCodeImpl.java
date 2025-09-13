package com.iep.mycompany.app.exception;

import com.iep.commons.enums.BaseErrorCode;

public class BaseErrorCodeImpl implements BaseErrorCode {

    private String message;

    @Override
    public String getMessage() {
        return message;
    }
}
