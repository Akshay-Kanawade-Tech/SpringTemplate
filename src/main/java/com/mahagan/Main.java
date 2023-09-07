package com.mahagan;

import com.mahagan.dao.DeviceDAO;
import com.mahagan.model.Device;
import config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main{
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        DeviceDAO deviceDAO =context.getBean(DeviceDAO.class);

        System.out.println("List of device is:");

        for(Device p : deviceDAO.getAllDevice()){
            System.out.println(p);
        }

        System.out.println("\n get device with id 2");

        Device deviceById =deviceDAO.getDeviceById(2L);
        System.out.println(deviceById);

        System.out.println("\n Creating device:");
        Device device = new Device(4L, 36,"Sergery", "Emets");
        System.out.println(device);
        deviceDAO.createDevice(device);
        System.out.println("\n List of device is");

        for(Device p : deviceDAO.getAllDevice()){
            System.out.println(p);
        }

        System.out.println("\nDeleting device with Id 2");
        deviceDAO.deleteDevice(deviceById);

        System.out.println("\nUpdate device with Id 4");

        Device ddevice = deviceDAO.getDeviceById(4L);
        ddevice.setLastName("Changed");
        deviceDAO.updateDevice(ddevice);

        System.out.println("\n List of device is:");
        for(Device p : deviceDAO.getAllDevice()){
            System.out.println(p);
        }
        context.close();
    }
}
