package com.projek.prakerin.pendaftaran.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HaloController {
    
    @RequestMapping("/halo")
    public Map<String, Object>halo(){
        Map<String, Object>hasil = new HashMap<>();
        hasil.put("waktu", new Date());
        return hasil;
    }
    
}
