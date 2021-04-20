package com.springbatch.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.springbatch.demo.annotation.SelfAnnotation;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ResponseDto<T> {
    @JsonProperty("retcode")
    private String code;

    @JsonProperty("retmsg")
    private String message;

    @JsonIgnore
    @SelfAnnotation(value = true)
    private T data;
}
