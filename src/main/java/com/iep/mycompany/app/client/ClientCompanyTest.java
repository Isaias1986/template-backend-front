package com.iep.mycompany.app.client;

import com.iep.commons.model.BaseHttpResponse;
import com.iep.mycompany.app.model.response.ResponseTest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "company-test", url = "${company-test.uri}")
public interface ClientCompanyTest {

    @GetMapping("/test/{id}")
    BaseHttpResponse<ResponseTest> getById(@PathVariable("id") Long id);

}
