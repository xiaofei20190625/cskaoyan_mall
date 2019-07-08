package com.cskaoyan.mall.admin.typeHandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by IceFloe_Rot
 * Date 2019/7/5 Time 14:49
 */
public class BooleanToByteHandler extends BaseTypeHandler<Boolean> {
    //boolean → 0/1
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int index, Boolean input, JdbcType jdbcType) throws SQLException {
        if (input == true){
            preparedStatement.setInt(index, 1);
        }else {
            preparedStatement.setInt(index, 0);
        }

    }

    //0/1 → boolean
    @Override
    public Boolean getNullableResult(ResultSet resultSet, String column) throws SQLException {
        int anInt = resultSet.getInt(column);
        return transferBooleanToInt(anInt);
    }

    @Override
    public Boolean getNullableResult(ResultSet resultSet, int index) throws SQLException {
        int anInt = resultSet.getInt(index);
        return transferBooleanToInt(anInt);
    }

    @Override
    public Boolean getNullableResult(CallableStatement callableStatement, int index) throws SQLException {
        int anInt = callableStatement.getInt(index);
        return transferBooleanToInt(anInt);
    }

    private Boolean transferBooleanToInt(int anInt){
        if (anInt == 1){
            return true;
        }
        return false;
    }
}
