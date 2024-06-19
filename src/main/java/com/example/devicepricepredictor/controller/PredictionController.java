package com.example.devicepricepredictor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.example.devicepricepredictor.model.Device;
import com.example.devicepricepredictor.repository.DeviceRepository;

@Controller
public class PredictionController {

    @Autowired
    private DeviceRepository deviceRepository;

    @GetMapping("/predict")
    public String getPrediction(@RequestParam("id") long id, Model model) {
        Device device = deviceRepository.findById(id).orElse(null);

        if (device != null) {
            String url = "http://localhost:5000/predict";
            RestTemplate restTemplate = new RestTemplate();
            String params = "?battery_power=" + device.getBattery_power() +
                            "&blue=" + (device.isBlue() ? 1 : 0) +
                            "&clock_speed=" + device.getClock_speed() +
                            "&dual_sim=" + (device.isDual_sim() ? 1 : 0) +
                            "&fc=" + device.getFc() +
                            "&four_g=" + (device.isFour_g() ? 1 : 0) +
                            "&int_memory=" + device.getInt_memory() +
                            "&m_dep=" + device.getM_dep() +
                            "&mobile_wt=" + device.getMobile_wt() +
                            "&n_cores=" + device.getN_cores() +
                            "&pc=" + device.getPc() +
                            "&px_height=" + device.getPx_height() +
                            "&px_width=" + device.getPx_width() +
                            "&ram=" + device.getRam() +
                            "&sc_h=" + device.getSc_h() +
                            "&sc_w=" + device.getSc_w() +
                            "&talk_time=" + device.getTalk_time() +
                            "&three_g=" + (device.isThree_g() ? 1 : 0) +
                            "&touch_screen=" + (device.isTouch_screen() ? 1 : 0) +
                            "&wifi=" + (device.isWifi() ? 1 : 0);

            ResponseEntity<String> response = restTemplate.getForEntity(url + params, String.class);
            model.addAttribute("prediction", response.getBody());
        }

        return "result"; // A Thymeleaf template to display the result
    }
}
