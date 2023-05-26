package com.se.spring.services.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.se.spring.model.TacPham;
import com.se.spring.repositories.TacPhamReporsitory;
import com.se.spring.services.TacPhamService;

@Service
public class TacPhamServiceImpl implements TacPhamService {

	private final TacPhamReporsitory tacPhamReporsitory;

	public TacPhamServiceImpl(TacPhamReporsitory tacPhamReporsitory) {
		this.tacPhamReporsitory = tacPhamReporsitory;
	}

	@Override
	public void save(TacPham tacPham) {
		tacPhamReporsitory.save(tacPham);
	}

	@Override
	public List<TacPham> findAll() {
		return tacPhamReporsitory.findAll();
	}

	@Override
	public Optional<TacPham> findById(long id) {
		// TODO Auto-generated method stub
		return tacPhamReporsitory.findById(id);
	}

	@Override
	public void delete(TacPham tacPham) {
		tacPhamReporsitory.delete(tacPham);

	}

	@Override
	public boolean delete(long id) {
		Optional<TacPham> op = tacPhamReporsitory.findById(id);
		if (op.isPresent()) {
			TacPham tp = op.get();
			delete(tp);
			return true;
		}
		return false;
	}

}
