package com.xjh.exceljiexi.service;

import com.xjh.exceljiexi.domain.UserExcelModel;

import java.util.List;

/**
 * @author xjh
 * @date 2022/2/6 15:29
 */
public interface UserExcelModelService {

    /**
     * 将解析Excel得到的list集合中的数据写入到数据库
     * @param userExcelModel
     */
    void addUser(List<UserExcelModel> userExcelModel);

    List<UserExcelModel> list();

}
