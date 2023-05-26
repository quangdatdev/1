package com.se.spring.services.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.se.spring.model.TacGia;
import com.se.spring.repositories.TacGiaRepository;
import com.se.spring.services.TacGiaService;

@Service
public class TacGiacServiceImpl implements TacGiaService {

	private final TacGiaRepository tacGiaRepository;

	public TacGiacServiceImpl(TacGiaRepository tacGiaRepository) {
		this.tacGiaRepository = tacGiaRepository;
	}

	@Override
	public void save(TacGia tacgia) {
		tacGiaRepository.save(tacgia);
	}

	@Override
	public List<TacGia> findAll() {
		return tacGiaRepository.findAll();
	}

	@Override
	public Optional<TacGia> findById(long id) {
		return tacGiaRepository.findById(id);
	}

	@Override
	public void delete(TacGia tacgia) {

		tacGiaRepository.delete(tacgia);
	}

	@Override
	public boolean delete(long id) {
		Optional<TacGia> op = tacGiaRepository.findById(id);
		if (op.isPresent()) {
			TacGia tg = op.get();
			delete(tg);
			return true;
		}
		return false;
	}

}
