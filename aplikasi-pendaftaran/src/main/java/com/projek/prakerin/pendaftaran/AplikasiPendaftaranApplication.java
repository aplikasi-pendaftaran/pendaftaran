package com.projek.prakerin.pendaftaran;

import com.projek.prakerin.pendaftaran.entity.Siswa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.thymeleaf.dialect.springdata.SpringDataDialect;

@SpringBootApplication
public class AplikasiPendaftaranApplication {

	public static void main(String[] args) {
		SpringApplication.run(AplikasiPendaftaranApplication.class, args);
	}
        
        @Bean
        public SpringDataDialect springDataDialect() {
        return new SpringDataDialect();
    }
 
}
