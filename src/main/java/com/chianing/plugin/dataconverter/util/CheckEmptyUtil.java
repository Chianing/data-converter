package com.chianing.plugin.dataconverter.util;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;


public class CheckEmptyUtil {

    /**
     * 校验参数是否为空,字符串trim后是否为空
     */
    public static boolean isEmpty(Object object) {
        if (object == null) {
            return true;
        }

        if (object instanceof Optional) {
            return ((Optional<?>) object).isEmpty();
        }

        if (object instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) object;
            int length = charSequence.length();
            for (int i = 0; i < length; ++i) {
                if (!Character.isWhitespace(charSequence.charAt(i))) {
                    return false;
                }
            }
            return true;
        }

        if (object.getClass().isArray()) {
            return Array.getLength(object) == 0;
        }

        if (object instanceof Map) {
            return ((Map<?, ?>) object).isEmpty();
        }

        if (object instanceof Iterator) {
            return !((Iterator<?>) object).hasNext();
        }

        if (object instanceof Iterable) {
            return !((Iterable<?>) object).iterator().hasNext();
        }

        return false;
    }

    public static boolean isNotEmpty(Object object) {
        return !isEmpty(object);
    }

}
