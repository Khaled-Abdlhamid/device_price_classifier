package com.example.devicepricepredictor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.devicepricepredictor.model.Device;
import com.example.devicepricepredictor.repository.DeviceRepository;

@Service
public class DeviceService {

	private final DeviceRepository deviceRepository;

	@Autowired
    public DeviceService(DeviceRepository deviceRepository) {
		this.deviceRepository = deviceRepository;
	}

	public List<Device> getDevices() {
		return deviceRepository.findAll();
    }

	public void addDevice(Device device) {
		deviceRepository.save(device);
    }

    public Device getDeviceById(Long id) {
        Optional<Device> device = deviceRepository.findById(id);
        return device.orElseThrow(() -> new IllegalStateException("Device with ID " + id + " does not exist"));
    }
}
