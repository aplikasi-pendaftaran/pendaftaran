package com.projek.prakerin.pendaftaran.dao;

import com.projek.prakerin.pendaftaran.entity.Siswa;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SiswaDao extends PagingAndSortingRepository<Siswa, String> {
    
    
}
