package com.cskaoyan.mall.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/3 Time 23:23
 */
@Component
public class DateToStringConverter implements Converter<Date, String> {
    @Override
    public String convert(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        return format;
    }
}
