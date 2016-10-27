package com.zslin.web.service;

import com.zslin.web.model.Family;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by 钟述林 393156105@qq.com on 2016/10/20 11:19.
 */
public interface IFamilyService extends JpaRepository<Family, Integer>, JpaSpecificationExecutor<Family> {
}
