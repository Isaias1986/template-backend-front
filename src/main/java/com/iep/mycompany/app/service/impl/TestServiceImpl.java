package com.iep.mycompany.app.service.impl;

import com.iep.mycompany.app.model.request.RequestTest;
import com.iep.mycompany.app.model.response.ResponseTest;
import com.iep.mycompany.app.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

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
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
