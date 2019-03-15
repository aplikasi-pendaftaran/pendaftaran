package com.projek.prakerin.pendaftaran.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

@Entity
public class Siswa {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getAsalSekolah() {
        return asalSekolah;
    }

    public void setAsalSekolah(String asalSekolah) {
        this.asalSekolah = asalSekolah;
    }

    public int getNilai() {
        return nilai;
    }

    public void setNilai(int nilai) {
        this.nilai = nilai;
    }
    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public int getNis() {
        return nis;
    }

    public void setNis(int nis) {
        this.nis = nis;
    }
  
    @Column(nullable = false, unique = true)
    @NotNull
    @NotEmpty
    @Range(min=0, max=90)
    private int nis;

    @Column(nullable = false)
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 150)
    private String nama;

    @Column(nullable = false)
    private String alamat;
    
    @Column(nullable = false)
    @NotNull 
    private String agama;

     @Column(name = "tanggal_lahir", nullable = false)
    @Temporal(TemporalType.DATE)
    @Past
    @NotNull
    private Date tanggalLahir;

    @Column(nullable = false)
    @NotNull
    private String jenisKelamin;

    @Column(nullable = false)
    @NotNull
    private String asalSekolah;

    @Column(nullable = false)
    @NotNull
    private int nilai;

}
