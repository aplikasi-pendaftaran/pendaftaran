package com.projek.prakerin.pendaftaran.dao;

import com.projek.prakerin.pendaftaran.entity.Siswa;
import java.util.List;
import javax.persistence.OrderBy;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SiswaDao extends PagingAndSortingRepository<Siswa, String> {
    
}
