package com.kina.admin;

import com.kina.admin.bean.User;
import com.kina.admin.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
class Boot05WebAdminApplicationTests {
    //  此版本已经注入好了，不需要再@Autowired注入了
    @Autowired
    UserMapper userMapper;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Test
    void contextLoads() {
//        jdbcTemplate.queryForList("select * from hero");
        Object oLong = jdbcTemplate.queryForObject("select count(*) from hero", Long.class);
        System.out.println(oLong + "-------------");
    }

    @Test
    void testUserMapper() {
        User user = userMapper.selectById(1);
        System.out.println(user);
    }

}
