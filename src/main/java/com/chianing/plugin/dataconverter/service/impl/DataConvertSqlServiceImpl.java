package com.chianing.plugin.dataconverter.service.impl;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.visitor.VisitorFeature;
import com.chianing.plugin.dataconverter.common.enums.DataTypeEnum;
import com.chianing.plugin.dataconverter.service.AbstractDataConvertService;
import com.chianing.plugin.dataconverter.util.CheckEmptyUtil;

/**
 * Sql数据转换
 *
 * @author chianing
 * @description Sql数据转换
 * @date 2023/04/27 09:52
 */
public class DataConvertSqlServiceImpl extends AbstractDataConvertService {

    private static final SQLUtils.FormatOption formatOption =
            new SQLUtils.FormatOption(VisitorFeature.OutputUCase, VisitorFeature.OutputPrettyFormat);

    public DataConvertSqlServiceImpl() {
        super.setType(DataTypeEnum.SQL);
    }

    @Override
    public String format(String rawText) {
        if (CheckEmptyUtil.isEmpty(rawText)) {
            return rawText;
        }

        return SQLUtils.formatPGSql(rawText, formatOption);

    }

    @Override
    public String compress(String rawText) {
        if (CheckEmptyUtil.isEmpty(rawText)) {
            return rawText;
        }

        return rawText.trim()
                .replace("\r", " ")
                .replace("\n", " ")
                .replace("  ", " ");

    }
}
