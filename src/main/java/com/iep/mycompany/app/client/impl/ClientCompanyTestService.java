package com.iep.mycompany.app.client.impl;

import com.iep.commons.exception.BaseCustomException;
import com.iep.mycompany.app.client.ClientCompanyTest;
import com.iep.mycompany.app.enums.ErrorGeneral;
import com.iep.mycompany.app.model.response.ResponseTest;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientCompanyTestService {

    private final ClientCompanyTest repository;



    @CircuitBreaker(name = "name", fallbackMethod = "findByIdError")
    public ResponseTest findById(Long id){
        return repository.findById(id).getData();
    }

   public ResponseTest findByIdError(Long id, Throwable e)throws Throwable{
        log.error("::::Fallo en la busqueda:::"+id);
        log.error(e.getMessage());
        throw e;
    }

}
