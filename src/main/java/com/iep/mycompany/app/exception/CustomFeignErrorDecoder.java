package com.iep.mycompany.app.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iep.commons.exception.BaseCustomException;
import com.iep.mycompany.app.model.response.TestsHttpResponse;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
public class CustomFeignErrorDecoder  implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        try {
        HttpStatus status = HttpStatus.valueOf(response.status());
        String responseBody = extractResponseBody(response);

        log.error("Feign client error. Method: {}, Status: {}, Body: {}",s, status, responseBody);
        ObjectMapper mapper = new ObjectMapper();
        mapper = mapper.findAndRegisterModules();
        TestsHttpResponse httpResponse = mapper.readValue(responseBody, TestsHttpResponse.class);

        return new BaseCustomException(
                httpResponse.getDeveloperMessage(),
                () -> httpResponse.getGeneralErrorCode(),
                HttpStatus.valueOf(httpResponse.getHttpStatus()) );

        }catch (Exception e){
            log.error(e.getMessage());
            throw new BaseCustomException(() -> HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private String extractResponseBody(Response response) {
        if (response.body() == null) {
            return "No response body";
        }

        try {
            return new String(response.body().asInputStream().readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException ex) {
            log.error("Failed to read response body", ex);
            return "Error reading response body";
        }
    }

}

