package com.iep.mycompany.app.model.request;

import com.iep.commons.model.BaseRequestDTO;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class RequestTest extends BaseRequestDTO {


    @NotNull(message = "La propiedad [name] no puede ser nula")
    @NotEmpty(message = "La propiedad [name] no puede ser vacia")
    private String name;

}
