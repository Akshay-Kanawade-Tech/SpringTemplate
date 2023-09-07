package com.mahagan.dao;


import java.util.List;

import com.mahagan.model.Device;

public interface DeviceDAO {
    Device getDeviceById(Long id);

    List<Device> getAllDevice();

    boolean deleteDevice(Device device);

    boolean updateDevice(Device device);

    boolean createDevice(Device device);
}
