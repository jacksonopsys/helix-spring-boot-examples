package com.hlx.posterm.repository;

import com.hlx.posterm.model.PostcodeData;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// @Repository
public interface PostcodeCRUDReporitory extends CrudRepository<PostcodeData,Long> {
}
