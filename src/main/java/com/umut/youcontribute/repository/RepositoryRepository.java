package com.umut.youcontribute.repository;

import com.umut.youcontribute.model.Repository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface RepositoryRepository extends PagingAndSortingRepository<Repository, Integer> {
    List<Repository> findAll();
}
