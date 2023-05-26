package com.se.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.se.spring.model.TacGia;

@Repository
public interface TacGiaRepository extends JpaRepository<TacGia, Long>{

}
