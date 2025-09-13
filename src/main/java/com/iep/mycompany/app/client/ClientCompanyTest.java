package com.iep.mycompany.app.client;

import com.iep.commons.model.BaseHttpResponse;
import com.iep.mycompany.app.exception.CustomFeignErrorDecoder;
import com.iep.mycompany.app.model.request.RequestTest;
import com.iep.mycompany.app.model.response.ResponseTest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "company-test", url = "${company-test.uri}", configuration = CustomFeignErrorDecoder.class)
public interface ClientCompanyTest {

    @GetMapping("/test/{id}")
    BaseHttpResponse<ResponseTest> findById(@PathVariable("id") Long id);

    @PostMapping("/test")
    BaseHttpResponse<ResponseTest> save(@RequestBody RequestTest test);

    @PutMapping("/test/{id}")
    BaseHttpResponse<ResponseTest> update(@PathVariable("id") Long id,@RequestBody RequestTest test);

    @DeleteMapping("/test/{id}")
    BaseHttpResponse<Void> delete(@PathVariable("id") Long id);
}
