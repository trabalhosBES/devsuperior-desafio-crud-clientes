package br.com.study.devsuperiordesafiocrudclientes.dto.errors;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

@AllArgsConstructor
@Getter
public class CustomError {

    private Instant timeStamp;
    private  Integer status;
    private  String error;
    private  String path;

}
