package com.projek.prakerin.pendaftaran.controller;

import com.projek.prakerin.pendaftaran.dao.SiswaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/siswa")   
public class SiswaHtmlController {
    
    @Autowired
    private SiswaDao sd;
    
    @RequestMapping("/list")
    public void daftarSiswa(Model m){
        m.addAtribute("daftarPeserta", sd.findAll());
        
    }
}
