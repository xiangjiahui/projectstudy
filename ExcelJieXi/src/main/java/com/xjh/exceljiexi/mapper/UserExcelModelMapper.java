package com.xjh.exceljiexi.mapper;

import com.xjh.exceljiexi.domain.UserExcelModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @author xjh
 * @date 2022/2/6 15:11
 */
@Mapper
public interface UserExcelModelMapper {

    /**
     * 插入解析的Excel表到数据库用户表
     * @param userExcelModel
     * @return
     */
    void insert(List<UserExcelModel> userExcelModel);

    /**
     * 获得所有的用户信息
     * @return
     */
    List<UserExcelModel> getAllUser();

}
