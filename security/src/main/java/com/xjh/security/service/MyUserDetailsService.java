package com.xjh.security.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xjh.security.domain.Admin;
import com.xjh.security.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xjh
 * @date 2022/2/8 15:54
 */
@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {


    @Resource
    private UserMapper userMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据用户名查询数据库
        QueryWrapper<Admin> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);

        Admin admin = userMapper.selectOne(wrapper);

        if (admin == null){
            System.out.println("用户名不存在!!!");
            throw new UsernameNotFoundException("用户名不存在!!!");
        }

        //设置权限
        List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList("admin,ROLE_admin");

        return new User(admin.getUsername(), new BCryptPasswordEncoder().encode(admin.getPassword()), auths);
    }
}
