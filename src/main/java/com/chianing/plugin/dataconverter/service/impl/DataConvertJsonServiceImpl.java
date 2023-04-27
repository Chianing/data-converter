package com.chianing.plugin.dataconverter.service.impl;

import com.chianing.plugin.dataconverter.common.enums.DataTypeEnum;
import com.chianing.plugin.dataconverter.service.AbstractDataConvertService;
import com.chianing.plugin.dataconverter.util.CheckEmptyUtil;
import com.chianing.plugin.dataconverter.util.JsonUtil;

/**
 * Json数据转换
 *
 * @author chianing
 * @description Json数据转换
 * @date 2023/04/27 09:52
 */
public class DataConvertJsonServiceImpl extends AbstractDataConvertService {
    public DataConvertJsonServiceImpl() {
        super.setType(DataTypeEnum.JSON);
    }

    @Override
    public String format(String rawText) {
        if (CheckEmptyUtil.isEmpty(rawText)) {
            return rawText;
        }

        return JsonUtil.prettifyJson(rawText);
    }

    @Override
    public String compress(String rawText) {
        if (CheckEmptyUtil.isEmpty(rawText)) {
            return rawText;
        }

        return rawText.trim()
                .replace(" ", "")
                .replace("\r", "")
                .replace("\n", "");
    }
}
