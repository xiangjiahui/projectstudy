package com.xjh.exceljiexi.service.impl;

import com.xjh.exceljiexi.domain.UserExcelModel;
import com.xjh.exceljiexi.mapper.UserExcelModelMapper;
import com.xjh.exceljiexi.service.UserExcelModelService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;


/**
 * @author xjh
 * @date 2022/2/6 15:30
 */
@Service
public class UserExcelModelImpl implements UserExcelModelService {

    @Resource
    private UserExcelModelMapper userExcelModelMapper;


    @Override
    public void addUser(List<UserExcelModel> userExcelModel) {
        userExcelModelMapper.insert(userExcelModel);
    }

    @Override
    public List<UserExcelModel> list() {
        return userExcelModelMapper.getAllUser();
    }
}
