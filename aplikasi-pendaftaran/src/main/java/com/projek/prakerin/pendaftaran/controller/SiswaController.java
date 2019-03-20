package com.projek.prakerin.pendaftaran.controller;

import com.projek.prakerin.pendaftaran.dao.SiswaDao;
import com.projek.prakerin.pendaftaran.entity.Siswa;
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
@RequestMapping("/api")
public class SiswaController {
    
    @Autowired
    private SiswaDao sd;
    
    @RequestMapping(value="/siswa", method = RequestMethod.GET)
        public Page<Siswa> cariPeserta(Pageable page){
        return sd.findAll(page);
    }
        @RequestMapping(value="/siswa", method = RequestMethod.POST)
        @ResponseStatus(HttpStatus.CREATED)
        public void insertSiswaBaru(@RequestBody Siswa s){
            sd.save(s);
        }
        
        @RequestMapping(value="/siswa/{id}", method = RequestMethod.PUT)
        @ResponseStatus(HttpStatus.OK)
        public void updateSiswa(@PathVariable("id") String id, @RequestBody Siswa s){
            s.setId(id);
            sd.save(s);
        }
        
        @RequestMapping(value="/siswa/{id}", method = RequestMethod.GET)
        @ResponseStatus(HttpStatus.OK)
        public ResponseEntity<Siswa> cariSiswaById(@PathVariable("id") String Id){
            Siswa hasil = sd.findById("id").get();
            if(hasil == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                
            }
            
            return new ResponseEntity<>(hasil, HttpStatus.OK);
            
        }
        
        @RequestMapping(value="/siswa/{id}", method = RequestMethod.DELETE)
        @ResponseStatus(HttpStatus.OK)
        public void hapusSiswa(@PathVariable("id") String id){
            sd.deleteById(id);
        }
}
