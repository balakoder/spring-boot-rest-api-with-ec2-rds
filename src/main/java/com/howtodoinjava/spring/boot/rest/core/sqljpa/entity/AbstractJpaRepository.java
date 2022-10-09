package com.howtodoinjava.spring.boot.rest.core.sqljpa.entity;
 
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import com.howtodoinjava.spring.boot.rest.entity.AbstractJpaEntity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface AbstractJpaRepository<T extends AbstractJpaEntity, I extends Serializable> extends JpaRepository<T, I>, JpaSpecificationExecutor<T> {

	T findFirstByUuid(String uuid);

	T findFirstByUuidAndStatus(String uuid, boolean status);

	List<T> findByUuidIn(Collection<String> uuids);

	List<T> findByUuidInAndStatus(Collection<String> uuids, boolean status);

	Page<T> findByStatus(boolean status, Pageable pageable);

	List<T> findByStatus(boolean status);

	long countByStatus(boolean status);

	Boolean existsByUuid(String uuid);

	Boolean existsByUuidAndStatus(String uuid, boolean status);

	List<T> findByUpdatedAtBetween(Date fromDate, Date toDate);

	List<T> findByIdBetween(I fromId, I toId);

	Optional<T> findByUuidAndStatus(String uuid , boolean status);

}