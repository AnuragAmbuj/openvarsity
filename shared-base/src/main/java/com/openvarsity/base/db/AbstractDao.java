package com.openvarsity.base.db;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;


public interface AbstractDao<T extends AbstractDataDto,
        ID extends Serializable> {

    T save(T dto);

    T saveAndFlush(T dto);

    T update(T dto);

    T updateAndFlush(T dto);

    List<T> save(List<T> dto);

    List<T> saveAndFlush(List<T> dtos);

    List<T> update(List<T> dtos);

    List<T> updateAndFlush(List<T> dtos);

    long count();

    Optional<T> find(ID id);

    List<T> find(List<ID> ids);

    List<T> findAll();

    List<T> findAll(Sort sort);

    Page<T> findAll(Pageable pageable);

    void flush();

    void delete(T dto);

    void delete(List<T> dtos);

    void delete(ID id);

    void deleteAll();

    List<T> findList(List<ID> ids);

    List<T> findAllList();

}