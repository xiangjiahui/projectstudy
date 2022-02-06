package com.xjh.exceljiexi.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author xjh
 * @date 2022/2/6 14:27
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserExcelModel  extends BaseRowModel implements Serializable {

    @ExcelProperty(value = "用户名", index = 0)
    private String name;

    @ExcelProperty(value = "年龄", index = 1)
    private Integer age;

    @ExcelProperty(value = "手机号", index = 2)
    private String mobile;

    @ExcelProperty(value = "性别", index = 3)
    private String sex;
}


