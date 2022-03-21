package com.codogym.cms.repository;

import com.codogym.cms.model.Province;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProvinceRepository extends PagingAndSortingRepository<Province, Long> {
}
