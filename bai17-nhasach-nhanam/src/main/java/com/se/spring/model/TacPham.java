package com.se.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "TACPHAM")
public class TacPham {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long maTP;
	private String tenTP;
	private String loaiTP;
	private int soTrang;
	private double gia;
	private String tomTat;
	private String hinh;
	
	@ManyToOne
	@JoinColumn(name = "MATG")
	private TacGia tacGia;
	
	public TacPham() {
		// TODO Auto-generated constructor stub
	}

	public TacPham(long maTP, String tenTP, String loaiTP, int soTrang, double gia, String tomTat, String hinh) {
		super();
		this.maTP = maTP;
		this.tenTP = tenTP;
		this.loaiTP = loaiTP;
		this.soTrang = soTrang;
		this.gia = gia;
		this.tomTat = tomTat;
		this.hinh = hinh;
	}

	public long getMaTP() {
		return maTP;
	}

	public void setMaTP(long maTP) {
		this.maTP = maTP;
	}

	public String getTenTP() {
		return tenTP;
	}

	public void setTenTP(String tenTP) {
		this.tenTP = tenTP;
	}

	public String getLoaiTP() {
		return loaiTP;
	}

	public void setLoaiTP(String loaiTP) {
		this.loaiTP = loaiTP;
	}

	public int getSoTrang() {
		return soTrang;
	}

	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public String getTomTat() {
		return tomTat;
	}

	public void setTomTat(String tomTat) {
		this.tomTat = tomTat;
	}

	public String getHinh() {
		return hinh;
	}

	public void setHinh(String hinh) {
		this.hinh = hinh;
	}

	public TacGia getTacGia() {
		return tacGia;
	}

	public void setTacGia(TacGia tacGia) {
		this.tacGia = tacGia;
	}

	@Override
	public String toString() {
		return "TacPham [maTP=" + maTP + ", tenTP=" + tenTP + ", loaiTP=" + loaiTP + ", soTrang=" + soTrang + ", gia="
				+ gia + ", tomTat=" + tomTat + ", hinh=" + hinh + ", tacGia=" + tacGia + "]";
	}
	
	
}
