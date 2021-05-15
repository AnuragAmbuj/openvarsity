package com.openvarsity.base.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface AbstractDataRepository<T extends AbstractEntity,
        ID extends Serializable>
        extends JpaRepository<T,ID> {
}
