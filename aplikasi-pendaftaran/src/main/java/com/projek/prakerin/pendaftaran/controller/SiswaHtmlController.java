package com.projek.prakerin.pendaftaran.controller;

import com.projek.prakerin.pendaftaran.dao.SiswaDao;
import com.projek.prakerin.pendaftaran.entity.Siswa;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;


@Controller
@RequestMapping("/siswa")
public class SiswaHtmlController {
    
    @Autowired
    private SiswaDao sd;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping("/list")
    public void daftarSiswa(Model m) {
        m.addAttribute("daftarSiswa", sd.findAll());
        
      

    }

    @GetMapping("/list")
    public ModelMap daftarSiswa(Pageable page) {
        return new ModelMap().addAttribute("daftarSiswa", sd.findAll(page));
    }
    
    @RequestMapping("/view")
    public void detailSiswa(Model m, @RequestParam("id") String id) {
        m.addAttribute("detailSiswa", sd.findById(id).get());

    }

    @GetMapping("/view")
    public ModelMap daftarSiswa(@RequestParam("id") String id) {
        return new ModelMap().addAttribute("detailSiswa", sd.findById(id).get());
    }

    @RequestMapping("/hapus")
    public String hapus(@RequestParam("id") String id) {
        sd.deleteById(id);
        return "redirect:list";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String tampilkanForm(@RequestParam(value = "id", required = false) String id,
            Model m) {

        //defaultnya isi dengan object baru
        m.addAttribute("siswa", new Siswa());

        if (id != null && !id.isEmpty()) {
            Siswa s = sd.findById(id).get();
            if (s != null) {
                m.addAttribute("siswa", s);
            }
        }
        return "/siswa/form";
    }

    @PostMapping("/form")
    public String prosesForm(@ModelAttribute @Valid Siswa s, BindingResult errors, SessionStatus status) {
        if (errors.hasErrors()) {
            return "siswa/form";
        }
        sd.save(s);
        status.setComplete();
        return "redirect:list";
    }
    
}
