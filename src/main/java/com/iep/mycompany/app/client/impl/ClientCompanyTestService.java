package com.iep.mycompany.app.client.impl;


import com.iep.mycompany.app.client.ClientCompanyTest;
import com.iep.mycompany.app.model.request.RequestTest;
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



    @CircuitBreaker(name = "default", fallbackMethod = "findByIdError")
    public ResponseTest findById(Long id){
        return repository.findById(id).getData();
    }

    @CircuitBreaker(name = "default", fallbackMethod = "saveError")
    public ResponseTest save (RequestTest test){
        return repository.save(test).getData();
    }

    @CircuitBreaker(name = "default", fallbackMethod = "updateError")
    public ResponseTest update(Long id, RequestTest test){
        return repository.update(id,test).getData();
    }

    @CircuitBreaker(name = "default", fallbackMethod = "updateError")
    public void delete(Long id){
        repository.delete(id);
    }

    private void deleteError(Long id, Exception e)throws Exception{
        log.error("::::Fallo en la eliminacion del registro {}",id);
        throw e;
    }

    private ResponseTest updateError(Long id, RequestTest test, Exception e)throws Exception{
        log.error("::::Fallo en la actualización del registro");
        throw e;
    }

    private ResponseTest saveError(RequestTest test, Exception e)throws Exception{
        log.error("::::Fallo en la persistencia del registro");
        throw e;
    }

    private ResponseTest findByIdError(Long id, Exception e)throws Exception{
        log.error("::::Fallo en la busqueda::: {}",id);
        throw e;
    }

}
