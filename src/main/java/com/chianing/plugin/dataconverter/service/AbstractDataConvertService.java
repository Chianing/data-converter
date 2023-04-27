package com.chianing.plugin.dataconverter.service;

import com.chianing.plugin.dataconverter.common.enums.DataTypeEnum;

/**
 * 数据转换抽象类
 *
 * @author chianing
 * @description 数据转换抽象类
 * @date 2023/04/27 09:48
 */
public abstract class AbstractDataConvertService {
    /**
     * 数据类型
     */
    protected DataTypeEnum type;

    public DataTypeEnum getType() {
        return type;
    }

    protected void setType(DataTypeEnum type) {
        this.type = type;
    }

    /**
     * 格式化
     *
     * @param rawText 原始数据
     * @return 格式化结果
     */
    public abstract String format(String rawText);

    /**
     * 压缩
     *
     * @param rawText 原始数据
     * @return 压缩结果
     */
    public abstract String compress(String rawText);
}
