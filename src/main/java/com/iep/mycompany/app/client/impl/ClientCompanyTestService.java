package com.iep.mycompany.app.client.impl;

import com.iep.commons.exception.BaseCustomException;
import com.iep.mycompany.app.client.ClientCompanyTest;
import com.iep.mycompany.app.enums.ErrorGeneral;
import com.iep.mycompany.app.model.response.ResponseTest;
import feign.FeignException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientCompanyTestService {

    private final ClientCompanyTest repository;



    @CircuitBreaker(name = "client-company-test", fallbackMethod = "findByIdError")
    public ResponseTest findById(Long id){
        return repository.findById(id).getData();
    }

    BaseCustomException findByIdError(Long id, Throwable e){
        log.error("::::Fallo en la busqueda:::"+id);
        log.error(e.getMessage());
        throw new BaseCustomException(null, ErrorGeneral.ERROR_NOT_FOUND);
    }

}
