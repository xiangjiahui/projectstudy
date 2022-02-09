package com.xjh.security.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * @author xjh
 * @date 2022/2/7 15:46
 */
@Controller
public class SecurityController {

    /**
     * @Secured ({"ROLE_manager","ROLE_admin"})
     * @PreAuthorize ("hasAnyAuthority('admin')")
     *
     * @Secured 注解,访问的用户只有具有某个角色才能访问
     * @PreAuthorize 注解,进入方法前就验证用户是否具有对应的权限或者角色
     * 有四个属性: hasAnyAuthority , hasAuthority, hasRole, hasAnyRole
     * @PostAuthorize 注解,访问执行之后再做校验,同样也有四个属性
     * @return
     */

    @GetMapping("/")
    public String login(){
        return "login";
    }


    @GetMapping("/index")
    @PreAuthorize("hasAuthority('admin')")
    public String index(){
        return "index";
    }

    @GetMapping("success")
    private String success(){
        return "success";
    }

    @GetMapping("/403")
    public String error(){
        return "403";
    }

   /* @GetMapping("/register")
    public String register(){
        return "register";
    }*/

}
