package com.example.demo.repos;

import com.example.demo.model.BaseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<T extends BaseModel> extends JpaRepository<T, Long> {

    @Override
    List<T> findAll();

    @Override
    Optional<T> findById(Long aLong);

    @Override
    <S extends T> S save(S s);
}
