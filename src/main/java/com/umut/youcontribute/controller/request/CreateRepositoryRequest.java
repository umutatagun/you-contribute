package com.umut.youcontribute.controller.request;

import lombok.Data;

@Data
public class CreateRepositoryRequest {
    private String repository;
    private String organization;
}
