package com.hackaton.repository;

import com.hackaton.entity.Medico;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

    Page<Medico> findAllByAtivoTrue(Pageable paginacao);

    Optional<Medico> findByIdAndAtivoTrue(Long id);

    @Bean
    Optional<Medico> findById(Long id);

}


