package com.projek.prakerin.pendaftaran.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Siswa {
    @Id
    private String id;
    private String nis;
    private String nama;
    private String tanggalLahir;
    private String jenisKelamin;
    private String alamat;
    private String agama;
    private String nilai;
    
}
