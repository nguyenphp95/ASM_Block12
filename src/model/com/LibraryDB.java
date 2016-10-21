package model.com;

public class LibraryDB {
	private int ID;
	private String TheLoai,TenSach,TenTacGia,NXB,Link;
	
	public LibraryDB() {

	}
	public LibraryDB( String theLoai, String tenSach, String tenTacGia, String nXB, String link) {
		super();
		TheLoai = theLoai;
		TenSach = tenSach;
		TenTacGia = tenTacGia;
		NXB = nXB;
		Link = link;
	}
	public LibraryDB(int iD, String theLoai, String tenSach, String tenTacGia, String nXB, String link) {
		super();
		ID = iD;
		TheLoai = theLoai;
		TenSach = tenSach;
		TenTacGia = tenTacGia;
		NXB = nXB;
		Link = link;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getTheLoai() {
		return TheLoai;
	}
	public void setTheLoai(String theLoai) {
		TheLoai = theLoai;
	}
	public String getTenSach() {
		return TenSach;
	}
	public void setTenSach(String tenSach) {
		TenSach = tenSach;
	}
	public String getTenTacGia() {
		return TenTacGia;
	}
	public void setTenTacGia(String tenTacGia) {
		TenTacGia = tenTacGia;
	}
	public String getNXB() {
		return NXB;
	}
	public void setNXB(String nXB) {
		NXB = nXB;
	}
	public String getLink() {
		return Link;
	}
	public void setLink(String link) {
		Link = link;
	}
	


}
