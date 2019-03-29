package com.projek.prakerin.pendaftaran.controller;

import com.projek.prakerin.pendaftaran.dao.BeritaDao;
import com.projek.prakerin.pendaftaran.entity.Berita;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/berita")
public class BeritaHtmlController {
    
    @Autowired
    private BeritaDao bd;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String tampilkanIndex(@RequestParam(value = "id", required = false) String id,
            Model m) {

        //defaultnya isi dengan object baru
        m.addAttribute("berita", new Berita());

        if (id != null && !id.isEmpty()) {
            Berita s = bd.findById(id).get();
            if (s != null) {
                m.addAttribute("berita", s);
            }
        }
        return "/berita/index";
    }   
}
