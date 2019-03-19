package com.projek.prakerin.pendaftaran.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Siswa {
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @Column(unique = true)
    private String nis;
    
    @Column(nullable = false)
    private String nama;
    
    @Column(name = "tanggal_lahir", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date tanggalLahir;
    
    @Column(unique = true)
    private String jenisKelamin;
    
    @Column(nullable = false)
    private String alamat;
    
    @Column(nullable = false)
    private String agama;
    
    @Column(nullable = false)
    private String nilai;
    
}
