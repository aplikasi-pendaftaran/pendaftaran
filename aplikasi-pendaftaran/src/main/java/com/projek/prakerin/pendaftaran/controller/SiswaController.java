package com.projek.prakerin.pendaftaran.controller;

import com.projek.prakerin.pendaftaran.dao.SiswaDao;
import com.projek.prakerin.pendaftaran.entity.Siswa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SiswaController {
    
    @Autowired
    private SiswaDao sd;
    
    @RequestMapping(value="/siswa", method = RequestMethod.GET)
        public Page<Siswa> cariPeserta(Pageable page){
        return sd.findAll(page);
    }
}
