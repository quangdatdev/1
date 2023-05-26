package com.se.spring.services;

import java.util.List;
import java.util.Optional;

import com.se.spring.model.TacPham;

public interface TacPhamService {

	void save(TacPham tacPham);
	
	List<TacPham> findAll();
	
	Optional<TacPham> findById(long id);
	
	void delete(TacPham tacPham);
	/**
	 * 
	 * @param id
	 * @return Trả về true nếu như xóa thành công
	 */
	boolean delete(long id);
}
