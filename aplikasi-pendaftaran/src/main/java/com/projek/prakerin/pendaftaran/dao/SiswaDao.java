package com.projek.prakerin.pendaftaran.dao;

import com.projek.prakerin.pendaftaran.entity.Siswa;
import java.awt.print.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SiswaDao extends PagingAndSortingRepository<Siswa, String> {
    
//    @Query("select * from siswa order by nilai DESC")
//    public Page<Siswa> urutNilaiDesc(Siswa s, Pageable page );
    
}
