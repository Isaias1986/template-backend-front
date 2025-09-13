package com.iep.mycompany.app.model.response;

import lombok.Getter;
import java.io.Serializable;
import java.time.LocalDateTime;


@Getter
public class TestsHttpResponse implements Serializable {
    private LocalDateTime timeStamp;
    private int statusCode;
    private String httpStatus;
    private String generalErrorCode;
    private String message;
    private String developerMessage;
}
