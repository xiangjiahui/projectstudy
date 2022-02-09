package com.xjh.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xjh.security.domain.Admin;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xjh
 * @date 2022/2/8 15:51
 */
@Mapper
public interface UserMapper extends BaseMapper<Admin> {
}
