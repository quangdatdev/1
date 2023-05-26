package com.se.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.se.spring.model.TacPham;

@Repository
public interface TacPhamReporsitory extends JpaRepository<TacPham, Long>{

}
