package com.projek.prakerin.pendaftaran.entity;

import java.sql.Blob;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Berita {
    
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public Date getTanggalUpdate() {
        return tanggalUpdate;
    }

    public void setTanggalUpdate(Date tanggalUpdate) {
        this.tanggalUpdate = tanggalUpdate;
    }

    public Blob getFoto() {
        return foto;
    }

    public void setFoto(Blob foto) {
        this.foto = foto;
    }
    
    
    @Column(nullable = false)
    @NotNull
    private String judul;
    @Column(nullable = false)
    @NotNull
    private String isi;
    
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @Past
    @NotNull
    private Date tanggalUpdate;
    @Column(nullable = false)
    @NotBlank
    private Blob foto;
    
}
