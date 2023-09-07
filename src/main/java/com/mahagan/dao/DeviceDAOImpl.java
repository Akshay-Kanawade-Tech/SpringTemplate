package com.mahagan.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.mahagan.model.Device;
import com.mahagan.model.DeviceMapper;

@Component
public class DeviceDAOImpl implements DeviceDAO {

    JdbcTemplate jdbcTemplate;

    private final String SQL_FIND_DEVICE = "select * from device where id = ?";
    private final String SQL_DELETE_DEVICE = "delete from device where id = ?";
    private final String SQL_UPDATE_DEVICE = "update device set first_name = ?, last_name = ?, price  = ? where id = ?";
    private final String SQL_GET_ALL = "select * from device";
    private final String SQL_INSERT_DEVICE = "insert into device(id, first_name, last_name, price) values(?,?,?,?)";

    @Autowired
    public DeviceDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Device getDeviceById(Long id) {
        return jdbcTemplate.queryForObject(SQL_FIND_DEVICE, new Object[]{id}, new DeviceMapper());
    }

    public List<Device> getAllDevice() {
        return jdbcTemplate.query(SQL_GET_ALL, new DeviceMapper());
    }

    public boolean deleteDevice(Device device) {
        return jdbcTemplate.update(SQL_DELETE_DEVICE, device.getId()) > 0;
    }

    public boolean updateDevice(Device device) {
        return jdbcTemplate.update(SQL_UPDATE_DEVICE, device.getFirstName(), device.getLastName(), device.getPrice(),
                device.getId()) > 0;
    }

    public boolean createDevice(Device device) {
        return jdbcTemplate.update(SQL_INSERT_DEVICE, device.getId(), device.getFirstName(), device.getLastName(),
                device.getPrice()) > 0;
    }
}
