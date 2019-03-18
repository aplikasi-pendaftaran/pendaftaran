package com.projek.prakerin.pendaftaran.entity;

import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import org.hibernate.annotations.GenericGenerator;

@Entity
public class Siswa {
    
    @Id
    private String id;
    
    //@Column(nullable = false)
    private String nama;
    
    //@Column(nullable = false)
    private String alamat;
    
    //@Column(nullable = false)
    private String jenisKelamin; 
    
    //@Column(nullable = false)
    private String agama;
    
    //@Column(nullable = false)
    private String asalSekolah;
    
    //@Column(nullable = false)
    private int nilai;
    
    
    
    
    
}
