package com.iep.mycompany.app.service.impl;

import com.iep.mycompany.app.client.ClientCompanyTest;
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

    private final ClientCompanyTest clientCompanyTest;

    @Override
    public ResponseTest save(RequestTest request) {
        return null;
    }

    @Override
    public ResponseTest update(Long id, RequestTest request) {
        return null;
    }

    @Override
    public ResponseTest findById(Long id) {
        return clientCompanyTest.getById(id).getData();
    }

    @Override
    public void deleteById(Long id) {

    }
}
