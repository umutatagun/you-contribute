package com.umut.youcontribute.service;

import com.umut.youcontribute.controller.request.CreateRepositoryRequest;
import com.umut.youcontribute.controller.resource.RepositoryResource;
import com.umut.youcontribute.model.Repository;
import com.umut.youcontribute.repository.RepositoryRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RepositoryService {
    private final RepositoryRepository repository;

    public RepositoryService(RepositoryRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void create(CreateRepositoryRequest request) {
        Repository r = Repository.builder()
                .organization(request.getOrganization())
                .repository(request.getRepository())
                .build();

        this.repository.save(r);
    }

    public List<RepositoryResource> list() {
        return repository.findAll()
                .stream()
                .map(RepositoryResource::createFor)
                .collect(Collectors.toList());
    }
}
