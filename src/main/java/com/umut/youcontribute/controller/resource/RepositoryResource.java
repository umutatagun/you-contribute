package com.umut.youcontribute.controller.resource;

import com.umut.youcontribute.model.Repository;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class RepositoryResource {
    private String repository;
    private String organization;

    public static RepositoryResource createFor(Repository reposiyory) {
        return RepositoryResource.builder()
                .repository(reposiyory.getRepository())
                .organization(reposiyory.getOrganization())
                .build();
    }

    public static List<RepositoryResource> createFor(List<Repository> repositories) {
        return repositories.stream()
                .map(RepositoryResource::createFor)
                .collect(Collectors.toList());
    }
}
