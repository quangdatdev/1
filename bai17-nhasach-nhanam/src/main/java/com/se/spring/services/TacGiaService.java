package com.se.spring.services;

import java.util.List;
import java.util.Optional;

import com.se.spring.model.TacGia;

public interface TacGiaService {

	void save(TacGia tacgia);
	
	List<TacGia> findAll();
	
	Optional<TacGia> findById(long id);
	
	void delete(TacGia tacgia);
	/**
	 * 
	 * @param id
	 * @return Trả về true nếu như xóa thành công
	 */
	boolean delete(long id);
}
