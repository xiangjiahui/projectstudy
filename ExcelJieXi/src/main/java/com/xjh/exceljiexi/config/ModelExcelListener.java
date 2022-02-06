package com.xjh.exceljiexi.config;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xjh
 * @date 2022/2/6 14:30
 */

public class ModelExcelListener extends AnalysisEventListener {

    private Logger log = LoggerFactory.getLogger(ModelExcelListener.class);

    private List<Object> datas = new ArrayList<>();
    /**
     * 通过 AnalysisContext 对象还可以获取当前 sheet，当前行等数据
     */
    @Override
    public void invoke(Object data, AnalysisContext context) {
        //数据存储到list，供批量处理，或后续自己业务逻辑处理。
        log.info("读取到数据{}",data);
        datas.add(data);
        //根据业务自行处理，可以写入数据库等等
    }

    //所以的数据解析完了调用
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        log.info("所有数据解析完成");
        log.info("所有数据成功写入到数据库");

    }
}

