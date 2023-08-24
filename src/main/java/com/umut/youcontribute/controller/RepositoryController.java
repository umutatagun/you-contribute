package com.umut.youcontribute.controller;

import com.umut.youcontribute.controller.request.CreateRepositoryRequest;
import com.umut.youcontribute.controller.resource.RepositoryResource;
import com.umut.youcontribute.service.RepositoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RequestMapping("/repositories")
@RestController
public class RepositoryController {
    private final RepositoryService repositoryService;

    public RepositoryController(final RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public void create(@RequestBody CreateRepositoryRequest request) {
        repositoryService.create(request);
    }

    @GetMapping
    public List<RepositoryResource> list() {
        return this.repositoryService.list();
    }
}
