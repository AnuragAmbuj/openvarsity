package com.openvarsity.base.db;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public abstract class AbstractDaoImpl<T extends AbstractDataDto,
        ID extends Serializable,
        I extends AbstractEntity,
        S extends AbstractDataRepository<I, ID>>
        implements AbstractDao<T, ID> {


    protected abstract S getRepository();

    protected abstract T toDto(I entity);

    protected abstract List<T> toDto(List<I> entities);

    protected abstract I toEntity(T dto);

    protected abstract List<I> toEntity(List<T> dtos);


    @Override
    public T save(T dto) {
        I entity = toEntity(presave(dto));
        I savedEntity = getRepository().save(entity);
        return toDto(savedEntity);
    }


    @Override
    public T saveAndFlush(T dto) {
        I entity = toEntity(presave(dto));
        I savedEntity = getRepository().saveAndFlush(entity);
        return toDto(savedEntity);
    }


    @Override
    public T update(T dto) {
        I entity = toEntity(presave(dto));
        I updatedEntity = getRepository().save(entity);
        return toDto(updatedEntity);
    }


    @Override
    public T updateAndFlush(T dto) {
        I entity = toEntity(presave(dto));
        I updatedEntity = getRepository().saveAndFlush(entity);
        return toDto(updatedEntity);
    }

    @Override
    public List<T> save(List<T> dtos) {
        List<I> entites = toEntity(dtos);
        List<I> savedEntities = getRepository().saveAll(entites);
        return toDto(savedEntities);
    }


    @Override
    public List<T> saveAndFlush(List<T> dtos) {
        List<I> entities = toEntity(dtos);
        List<I> savedEntities = getRepository().saveAll(entities);
        getRepository().flush();
        return toDto(savedEntities);
    }

    @Override
    public List<T> update(List<T> dtos) {
        List<I> entities = toEntity(dtos);
        List<I> updatedEntities = getRepository().saveAll(entities);
        return toDto(updatedEntities);
    }

    @Override
    public List<T> updateAndFlush(List<T> dtos) {
        List<I> entities = toEntity(dtos);
        List<I> updatedEntities = getRepository().saveAll(entities);
        getRepository().flush();
        return toDto(updatedEntities);
    }

    @Override
    public long count() {
        return getRepository().count();
    }

    @Override
    public Optional<T> find(ID id) {
        Optional<I> entity = getRepository().findById(id);
        T dto = null;
        if (entity.isPresent()) {
            dto = toDto(entity.get());
            return Optional.of(dto);
        }
        return Optional.empty();
    }

    @Override
    public List<T> find(List<ID> ids) {
        List<I> entities = getRepository().findAllById(ids);
        return toDto(entities);
    }

    @Override
    public List<T> findAll() {
        List<I> entities = getRepository().findAll();
        return toDto(entities);
    }

    @Override
    public List<T> findAll(Sort sort) {
        List<I> entities = getRepository().findAll(sort);
        return toDto(entities);
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        Page<I> entities = getRepository().findAll(pageable);
        return entities.map(this::toDto);

    }

    @Override
    public List<T> findList(List<ID> ids) {
        List<I> entities = Lists.newArrayList(getRepository().findAllById(ids));
        return toDto(entities);
    }

    @Override
    public List<T> findAllList() {
        List<I> entities = Lists.newArrayList(getRepository().findAll());
        return toDto(entities);
    }

    @Override
    public void flush() {
        getRepository().flush();
    }

    @Override
    public void delete(T dto) {
        I entity = toEntity(dto);
        getRepository().delete(entity);
    }

    @Override
    public void delete(List<T> dtos) {
        List<I> entities = toEntity(dtos);
        getRepository().deleteAll(entities);
    }

    @Override
    public void delete(ID id) {
        getRepository().deleteById(id);
    }

    @Override
    public void deleteAll() {
        getRepository().deleteAll();
    }

    private T presave(T dto) {
        if (!dto.isPublished()) {
            dto.setPublished(true);
        }
        if (!dto.isDeleted()) {
            dto.setDeleted(false);
        }
        return dto;
    }

    private List<T> presave(List<T> dtos) {
        return dtos.stream()
                .map(this::presave)
                .collect(Collectors.toList());
    }

}
