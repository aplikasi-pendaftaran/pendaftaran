package com.projek.prakerin.pendaftaran.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Siswa {
    
    @Id
    private String id; 
    
    @Column(nullable = false, unique = true)
    private int nis;   
    
    @Column(nullable = false)
    private String nama;    
    
    @Column(nullable = false)
    private String alamat;   
    
    @Column(name = "tanggal_lahir", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date tanggalLahir;
    
    @Column(nullable = false)
    private String jenisKelamin; 
    
    @Column(nullable = false)
    private String asalSekolah;  

    @Column(nullable = false)    
    private int nilai;
    
    
    
    
    
}
