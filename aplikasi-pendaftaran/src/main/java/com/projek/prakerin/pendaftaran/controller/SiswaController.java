package com.projek.prakerin.pendaftaran.controller;

import com.projek.prakerin.pendaftaran.dao.SiswaDao;
import com.projek.prakerin.pendaftaran.entity.Siswa;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SiswaController {

    @Autowired
    private SiswaDao pd;

    @RequestMapping(value = "/siswa", method = RequestMethod.GET)
    public Page<Siswa> cariPeserta(Pageable page) {
        return pd.findAll(page);
    }

    @RequestMapping(value = "/siswa", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void insertPesertaBaru(@RequestBody @Valid Siswa p) {
        pd.save(p);
    }

    @RequestMapping(value = "/siswa/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updatePeserta(@PathVariable("id") String id, @RequestBody @Valid Siswa p) {
        p.setId(id);
        pd.save(p);
    }

    @RequestMapping(value = "/siswa/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Siswa> cariSiswaById(@PathVariable("id") String id) {
        Siswa hasil = pd.findById("sw001").get();
        if (hasil == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(hasil, HttpStatus.OK);
    }
    
    
}