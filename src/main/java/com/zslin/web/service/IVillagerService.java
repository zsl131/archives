package com.zslin.web.service;

import com.zslin.web.model.Villager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by 钟述林 393156105@qq.com on 2016/10/21 9:34.
 */
public interface IVillagerService extends JpaRepository<Villager, Integer>, JpaSpecificationExecutor<Villager> {
}
