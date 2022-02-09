package com.xjh.security.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.annotation.Resource;
import javax.sql.DataSource;


/**
 * @author xjh
 * @date 2022/2/7 15:56
 * 使用配置类设置登陆的账号和密码，但是实际开发中都是查询数据库所得
 */
@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource(name = "userDetailsService")
    private UserDetailsService userDetailsService;


    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //加密密码的对象
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String password = passwordEncoder.encode("XJH981117");
        //设置登陆的账号密码和角色
//        auth.inMemoryAuthentication().withUser("xjh").password(password).roles("admin");

        //这才是实际开发中使用的方法
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //设置退出页面
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/");
        //设置自定义无访问权限失败的页面
        http.exceptionHandling().accessDeniedPage("/403");
        //自定义自己编写的登录页面
        http.formLogin()
                //登录页面访问路径
                .loginPage("/")

                //登录访问路径,其实就是controller的访问地址,只需要填写一个路径即可,业务逻辑由security完成
                .loginProcessingUrl("/login")

                //登录成功之后,跳转路径
                .defaultSuccessUrl("/success", true)

                .and().authorizeRequests()
                //设置哪些访问路径可以直接访问,不需要认证
                //.antMatchers("/index").permitAll()

                //当前登录用户只有具有admin权限才可以访问这个路径
                .antMatchers("/index").hasAuthority("admin")

                //只要有其中一个权限就可访问
                //.antMatchers("/index").hasAnyAuthority("admin","manager")

                //当前用户需要具有sale或其中一个的角色才能访问
                /*.antMatchers("/index").hasRole("sale")
                .antMatchers("/index").hasAnyRole("sale","manager")*/

                //.antMatchers("/toLogin").anonymous() //只能匿名用户访问
                // /toLogin请求地址，可以随便访问。
                .antMatchers("/", "/favicon.ico", "/ruoyi.png").permitAll()
                // 授予所有目录下的所有.js文件可访问权限
                .antMatchers("/css/**.css", "/js/*.js", "/img/**",
                        "/ruoyi/css/*.css", "/ruoyi/js/*.js", "/ruoyi/*.js"
                        ,"/js/plugins/*/*.js","/ajax/libs/**/**").permitAll()
                // 授予所有目录下的所有.css文件可访问权限
//                .regexMatchers(".*[.]css").permitAll()
                // 任意的请求，都必须认证后才能访问。
                .anyRequest().authenticated();

        //所有的请求都可以访问
        //.anyRequest().authenticated();

        http.rememberMe()
                .rememberMeParameter("remember-me")
                .tokenValiditySeconds(14 * 24 * 60 * 60)
                .rememberMeCookieName("remember-me")
                .tokenRepository(persistentTokenRepository())
                .userDetailsService(userDetailsService);


        //关闭csrf防护
        http.csrf().disable();
    }


    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);

        //自动生成表
        //jdbcTokenRepository.setCreateTableOnStartup(true);
        return jdbcTokenRepository;
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
