package com.projek.prakerin.pendaftaran.dao;

import com.projek.prakerin.pendaftaran.entity.Hasil;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface HasilDao extends PagingAndSortingRepository<Hasil, String> {
    
}
