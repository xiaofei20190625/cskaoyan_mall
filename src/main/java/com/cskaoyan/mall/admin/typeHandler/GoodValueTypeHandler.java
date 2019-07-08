package com.cskaoyan.mall.admin.typeHandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Alex_Cheng
 * @date 2019/7/6 10:49
 * @Description TODO
 */
public class GoodValueTypeHandler implements TypeHandler<String[]> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, String[] strings, JdbcType jdbcType) throws SQLException {
        if (strings == null) {
            preparedStatement.setString(i, "");
        } else {
            StringBuffer sb = new StringBuffer();
            for (String string : strings
            ) {
                sb.append(string).append(",");
            }
            String subString = sb.substring(0, sb.length() );
            preparedStatement.setString(i, subString);
        }
    }

    @Override
    public String[] getResult(ResultSet resultSet, String s) throws SQLException {
        String string = resultSet.getString(s);
        return trans(string);
    }

    @Override
    public String[] getResult(ResultSet resultSet, int i) throws SQLException {
        String string = resultSet.getString(i);
        return trans(string);
    }

    @Override
    public String[] getResult(CallableStatement callableStatement, int i) throws SQLException {
        String string = callableStatement.getString(i);
        return trans(string);
    }

    private String[] trans(String string){
        String[] split = string.split(",");
        String[] strings = new String[split.length];
        for (int i = 0; i <split.length ; i++) {
            strings[i] = split[i];
        }
        return  strings;
    }

}
