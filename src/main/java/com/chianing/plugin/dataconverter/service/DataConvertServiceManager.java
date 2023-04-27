package com.chianing.plugin.dataconverter.service;

import com.chianing.plugin.dataconverter.common.enums.DataTypeEnum;
import com.chianing.plugin.dataconverter.service.impl.DataConvertJsonServiceImpl;
import com.chianing.plugin.dataconverter.service.impl.DataConvertSqlServiceImpl;
import com.chianing.plugin.dataconverter.util.CheckEmptyUtil;
import com.google.common.collect.Maps;

import java.util.EnumMap;

/**
 * 数据转换service管理类
 *
 * @author chianing
 * @description 数据转换service管理类
 * @date 2023/04/27 10:03
 */
public class DataConvertServiceManager {

    private static final EnumMap<DataTypeEnum, AbstractDataConvertService> SERVICE_ENUM_MAP = Maps.newEnumMap(DataTypeEnum.class);

    static {
        AbstractDataConvertService dataConvertService;

        for (DataTypeEnum type : DataTypeEnum.values()) {
            switch (type) {
                case JSON:
                    dataConvertService = new DataConvertJsonServiceImpl();
                    break;
                case SQL:
                    dataConvertService = new DataConvertSqlServiceImpl();
                    break;
                default:
                    continue;
            }

            SERVICE_ENUM_MAP.put(type, dataConvertService);

        }
    }

    public static AbstractDataConvertService getService(DataTypeEnum type) {
        if (CheckEmptyUtil.isEmpty(type)) {
            return null;
        }

        return SERVICE_ENUM_MAP.get(type);

    }

}
