package com.cskaoyan.mall.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/3 Time 23:09
 */
@Component
public class BooleanToIntegerConverter implements Converter<Boolean, Integer> {

    @Override
    public Integer convert(Boolean aBoolean) {
        if (aBoolean == true){
            return 1;
        }
        return 0;
    }
}
