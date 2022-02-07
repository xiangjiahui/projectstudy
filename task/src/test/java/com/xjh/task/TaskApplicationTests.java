package com.xjh.task;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class TaskApplicationTests {

    @Resource
    private JavaMailSenderImpl mailSender;

    @Test
    void contextLoads() {
        //这个对象能够发送一些简单的邮件
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件信息设置
        //邮件标题
        message.setSubject("今晚开会通知");
        //邮件内容
        message.setText("今晚7：30开会");

        //邮件发送给谁
        message.setTo("2464674651@qq.com");
        //邮件由谁发送
        message.setFrom("2464674651@qq.com");
        System.out.println("邮件发送成功");
        mailSender.send(message);

    }

    @Test
    public void test2() throws MessagingException {
        //发送复杂邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        //邮件设置
        helper.setSubject("今晚开会通知");
        //这个对象可以设置html内容
        helper.setText("<b style='color:red'>今晚8:00在白宫开会</b>",true);
        //上传文件按
        helper.addAttachment("1.txt",new File("C:\\学习资料\\解决maven项目创建过慢的问题.txt"));
        helper.addAttachment("1.jpg",new File("C:\\Users\\123\\Pictures\\Saved Pictures\\c0b418d39a3444e997791a823bc6bea3.jpg"));


        helper.setTo("2464674651@qq.com");
        helper.setFrom("2464674651@qq.com");

        System.out.println("邮件发送成功");

        mailSender.send(mimeMessage);
    }

}
