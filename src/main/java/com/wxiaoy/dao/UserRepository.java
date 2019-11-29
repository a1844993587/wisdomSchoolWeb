package com.wxiaoy.dao;

import com.wxiaoy.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Alex Yu
 * @date 2019/11/29 15:43
 */
public interface UserRepository extends JpaRepository<User, String> {

    User findByAccount(String account);

}
