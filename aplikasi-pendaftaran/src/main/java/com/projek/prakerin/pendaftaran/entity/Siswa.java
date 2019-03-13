package com.projek.prakerin.pendaftaran.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Siswa {
    
    @Id
    private String id;    
    private String nama;      
    private String alamat;        
    private String jenisKelamin;     
    private String agama;       
    private String asalSekolah;      
    private int nilai;
    
    
    
    
    
}
