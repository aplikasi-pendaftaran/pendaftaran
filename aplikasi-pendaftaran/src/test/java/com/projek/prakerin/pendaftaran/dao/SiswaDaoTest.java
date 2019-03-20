package com.projek.prakerin.pendaftaran.dao;

import com.projek.prakerin.pendaftaran.entity.Siswa;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.sql.DataSource;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
        scripts ="/data/siswa.sql"
)
public class SiswaDaoTest {
    
    @Autowired
    private SiswaDao sd;
    
    @Autowired 
    private DataSource ds;
    
    @After
    public void hapusData() throws Exception{
        String sql = "delete from siswa where nis = '100002'";
        try (Connection c = ds.getConnection()) {
            c.createStatement().executeUpdate(sql);
        }
    }
    
    
    @Test        
    public void testInsert() throws SQLException{
        Siswa s = new Siswa();
        s.setId("siswa001");
        s.setNis(112233);
        s.setNama("putri");
        s.setAlamat("bekasi");
        s.setTanggalLahir(new Date());
        s.setJenisKelamin("perempuan");
        s.setAsalSekolah("smp");
        s.setNilai(60);
        
        sd.save(s);
   
        
        String sql ="select count(*) as jumlah "
                + "from siswa "
                + "where nis = '112233'";
        
        try (Connection c = ds.getConnection()) {
            ResultSet rs = c.createStatement().executeQuery(sql);
            Assert.assertTrue(rs.next());
            
            Long jumlahRow = rs .getLong("jumlah");
            Assert.assertEquals(1L, jumlahRow.longValue());
        }
        
    }
        
        @Test
    public void testHitung(){
        Long jumlah = sd.count();
        Assert.assertEquals(2L, jumlah.longValue());
        
    }
    
    @Test
    public void testCariById(){
        Siswa s = sd.findById("sw001").get();
        Assert.assertNotNull(s);
        Assert.assertEquals("alya", s.getNama());
        Assert.assertEquals("bekasi", s.getAlamat());
        
    }
        
    }
            
       
    
    
    

