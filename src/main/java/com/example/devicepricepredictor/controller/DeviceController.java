package com.example.devicepricepredictor.controller;

import java.util.List;
// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.devicepricepredictor.model.Device;
import com.example.devicepricepredictor.service.DeviceService;

@RestController
@RequestMapping(path="api/v1/device")
public class DeviceController {

    private final DeviceService deviceservice;

    @Autowired
    public DeviceController(DeviceService deviceservice) {
        this.deviceservice = deviceservice;
    }

    @GetMapping
	public List<Device> getDevices() {
		return deviceservice.getDevices();
    }

    @PostMapping
    @ResponseBody
    public String createDevice(@RequestBody Device device) {
        deviceservice.addDevice(device);
        return "Device created: " + device.toString();
    }

    @GetMapping("/{id}")
    public Device getDeviceById(@PathVariable Long id) {
        return deviceservice.getDeviceById(id);
    }

}
