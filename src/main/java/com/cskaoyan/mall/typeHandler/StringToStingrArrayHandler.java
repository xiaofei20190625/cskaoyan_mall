package com.cskaoyan.mall.typeHandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StringToStingrArrayHandler extends BaseTypeHandler<String[]> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String[] strings, JdbcType jdbcType) throws SQLException {
        StringBuffer sb = new StringBuffer("[");
        for (String string : strings) {
            sb.append(string).append(",");
        }
        String subString = sb.substring(0, sb.length() - 1) + "]";
        preparedStatement.setString(i, subString);
    }

    @Override
    public String[] getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String string = resultSet.getString(s);
        return stringToStringArray(string);    }

    @Override
    public String[] getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String string = resultSet.getString(i);
        return stringToStringArray(string);    }

    @Override
    public String[] getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String string = callableStatement.getString(i);
        return stringToStringArray(string);    }

    public String[] stringToStringArray(String column) {
        String s = column.substring(1, column.length() -1);
        String[] split = s.split(",");
        for (int i = 0; i < split.length; i++) {
            split[i] = split[i].trim();
            split[i] = split[i].substring(1, split[i].length() -1);
        }
        return split;
    }
}
