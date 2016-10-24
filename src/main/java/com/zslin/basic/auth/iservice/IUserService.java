package com.zslin.basic.auth.iservice;

import com.zslin.basic.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by zsl-pc on 2016/8/31.
 */
public interface IUserService extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

    public User findByUsername(String username);

    User findById(Integer id);

//    @Query("FROM User u ")
//    public Page<User> pageAll(Pageable pageable);

    @Query("SELECT ur.rid FROM UserRole ur WHERE ur.uid=?1")
    List<Integer> listUserRoleIds(Integer userId);
}
