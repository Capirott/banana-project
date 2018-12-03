package com.erick.oobj.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.erick.oobj.api.model.SoninhoEntity;
import com.erick.oobj.api.repository.filter.SoninhoFilter;

@NoRepositoryBean
public interface SoninhoRepository<B extends SoninhoEntity, T, F extends SoninhoFilter>
		extends JpaRepository<B, T>, SoninhoSearchRepository<B, F> {

}
