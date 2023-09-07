package com.mahagan.model;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DeviceMapper implements RowMapper<Device> {

    public Device mapRow(ResultSet resultSet, int i) throws SQLException {

        Device device = new Device();
        device.setId(resultSet.getLong("id"));
        device.setFirstName(resultSet.getString("first_name"));
        device.setLastName(resultSet.getString("last_name"));
        device.setPrice(resultSet.getInt("price"));
        return device;
    }
}
