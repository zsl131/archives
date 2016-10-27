package com.zslin.web.service;

import com.zslin.web.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by 钟述林 393156105@qq.com on 2016/10/20 9:24.
 */
public interface ITeamService extends JpaRepository<Team, Integer>, JpaSpecificationExecutor<Team> {
}
