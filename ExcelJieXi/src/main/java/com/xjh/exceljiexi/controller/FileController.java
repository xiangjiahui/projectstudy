package com.xjh.exceljiexi.controller;

import com.alibaba.excel.EasyExcel;
import com.xjh.exceljiexi.config.ModelExcelListener;
import com.xjh.exceljiexi.domain.UserExcelModel;
import com.xjh.exceljiexi.fileutils.MyFileUtil;
import com.xjh.exceljiexi.service.UserExcelModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xjh
 * @date 2022/2/5 17:48
 */
@Controller
@SuppressWarnings("ALL")
public class FileController {

    @Autowired
    private UserExcelModelService userService;

    MyFileUtil fileUtil = new MyFileUtil();

    @RequestMapping("/file")
    public String index(){
        return "file";
    }

    /**
     * 导出数据
     */
    @GetMapping("/exportExcel")
    public void exportData(HttpServletResponse response) throws Exception {
        fileUtil.exportExcel(response);
    }

    /**
     * 解析Excel并写入数据库
     * @param file
     * @return
     */
    @PostMapping("/readExcel")
//    @ResponseBody
    public String readExcel(@RequestParam("file") MultipartFile file){
        List<UserExcelModel> list = fileUtil.readExcel(file);
        userService.addUser(list);
        return "file";
    }


    @GetMapping("/get")
    @ResponseBody
    public List<UserExcelModel> getAllUser(){
        return userService.list();
    }

}
