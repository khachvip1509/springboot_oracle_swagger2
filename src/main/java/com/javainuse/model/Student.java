package com.javainuse.model;

public class Student {
	
	private Long sv_id;
	private int id_lop;
	private String ten_sv;
	private int tuoi;
	private String diachi;
	
	public Student() {
	}
	
	public Long getSv_id() {
		return sv_id;
	}
	public void setSv_id(Long sv_id) {
		this.sv_id = sv_id;
	}
	public int getId_lop() {
		return id_lop;
	}
	public void setId_lop(int id_lop) {
		this.id_lop = id_lop;
	}
	public String getTen_sv() {
		return ten_sv;
	}
	public void setTen_sv(String ten_sv) {
		this.ten_sv = ten_sv;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	
	@Override
	public String toString() {
		return "Student [sv_id=" + sv_id + ", id_lop=" + id_lop + ", ten_sv=" + ten_sv + ", tuoi=" + tuoi + ", diachi="
				+ diachi + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;

		if (sv_id == null) {
			if (other.sv_id != null)
				return false;
		} else if (!sv_id.equals(other.sv_id))
			return false;	
			
		return true;
	}

	

}
