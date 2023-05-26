package com.se.spring.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "TACGIA")
public class TacGia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long maTacGia;
	private String hoTen;
	private String linhVu;
	private String tieuSu;
	
	@OneToMany(mappedBy = "tacGia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TacPham> tacPhamList;
	
	
	public TacGia() {
		// TODO Auto-generated constructor stub
	}
	public TacGia(long maTacGia, String hoTen, String linhVu, String tieuSu) {
		super();
		this.maTacGia = maTacGia;
		this.hoTen = hoTen;
		this.linhVu = linhVu;
		this.tieuSu = tieuSu;
	}
	public long getMaTacGia() {
		return maTacGia;
	}
	public void setMaTacGia(long maTacGia) {
		this.maTacGia = maTacGia;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getLinhVu() {
		return linhVu;
	}
	public void setLinhVu(String linhVu) {
		this.linhVu = linhVu;
	}
	public String getTieuSu() {
		return tieuSu;
	}
	public void setTieuSu(String tieuSu) {
		this.tieuSu = tieuSu;
	}
	
	public List<TacPham> getTacPhamList() {
		return tacPhamList;
	}
	public void setTacPhamList(List<TacPham> tacPhamList) {
		this.tacPhamList = tacPhamList;
	}
	@Override
	public String toString() {
		return "TacGia [maTacGia=" + maTacGia + ", hoTen=" + hoTen + ", linhVu=" + linhVu + ", tieuSu=" + tieuSu + "]";
	}
	
}
