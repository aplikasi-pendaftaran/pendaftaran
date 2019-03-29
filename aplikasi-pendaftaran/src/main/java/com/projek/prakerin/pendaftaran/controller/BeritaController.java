package com.projek.prakerin.pendaftaran.controller;

import com.projek.prakerin.pendaftaran.dao.BeritaDao;
import com.projek.prakerin.pendaftaran.entity.Berita;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BeritaController {
    
    @Autowired
    private BeritaDao bd;

    @RequestMapping(value = "/berita", method = RequestMethod.GET)
    public Page<Berita> cariBerita(Pageable page) {
        return bd.findAll(page);
    }

    @RequestMapping(value = "/berita", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void insertBeritaBaru(@RequestBody @Valid Berita b) {
        bd.save(b);
    }
    
    @RequestMapping(value = "/berita/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateBerita(@PathVariable("id") String id, @RequestBody @Valid Berita b) {
        b.setId(id);
        bd.save(b);
    }

    @RequestMapping(value = "/berita/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Berita> cariBeritaById(@PathVariable("id") String id) {
        Berita hasil = bd.findById("ba001").get();
        if (hasil == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(hasil, HttpStatus.OK);
    }
    
    @RequestMapping("/berita")
    @ResponseBody
    public Map<String, Object> haloRest(
            @RequestParam(value = "nama", required = false) String nama) {
        Map<String, Object> hasil = new HashMap<>();
        hasil.put("nama", nama);
        hasil.put("waktu", new Date());
        return hasil;
    }

}
