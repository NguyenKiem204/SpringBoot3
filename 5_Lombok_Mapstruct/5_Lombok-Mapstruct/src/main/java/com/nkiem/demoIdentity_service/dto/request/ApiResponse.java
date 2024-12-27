package com.nkiem.demoIdentity_service.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL) // những cái field nào null thì nó sẽ không show ra JSON
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
    private int code = 1000;// khi api thành công nó sẽ trả code về 1000
    private String message;
    private T result;

}
