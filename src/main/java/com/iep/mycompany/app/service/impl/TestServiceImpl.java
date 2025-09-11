package com.iep.mycompany.app.service.impl;

import com.iep.mycompany.app.client.ClientCompanyTest;
import com.iep.mycompany.app.client.impl.ClientCompanyTestService;
import com.iep.mycompany.app.model.request.RequestTest;
import com.iep.mycompany.app.model.response.ResponseTest;
import com.iep.mycompany.app.service.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    //TODO: falta agregar la configuracion de tolerancia a fallos
    // https://medium.com/@ahmettemelkundupoglu/mastering-the-circuit-breaker-pattern-in-microservices-with-java-techniques-for-modern-resiliency-e2a07898586a
    // https://docs.spring.io/spring-cloud-circuitbreaker/reference/index.html
    // https://resilience4j.readme.io/docs/getting-started

    //private final ClientCompanyTest clientCompanyTest;
    private final ClientCompanyTestService service;

    @Override
    public ResponseTest save(RequestTest request) {
        return null;//clientCompanyTest.save(request).getData();
    }

    @Override
    public ResponseTest update(Long id, RequestTest request) {
        return null;//clientCompanyTest.update(id,request).getData();
    }

    @Override
    public ResponseTest findById(Long id) {
        return service.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        //clientCompanyTest.delete(id);
    }
}
