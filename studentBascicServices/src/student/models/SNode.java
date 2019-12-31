package student.models;

import java.util.List;

public class SNode {
	
	private int Sno;
	private String Sname;
	private String Sdept;
	private int Sunit;
	private boolean Sgradute;
	private List<CNode> link;
	
	
	public int getSno() {
		return Sno;
	}
	public void setSno(int sno) {
		Sno = sno;
	}
	public String getSname() {
		return Sname;
	}
	public void setSname(String sname) {
		Sname = sname;
	}
	public String getSdept() {
		return Sdept;
	}
	public void setSdept(String sdept) {
		Sdept = sdept;
	}
	public int getSunit() {
		return Sunit;
	}
	public void setSunit(int sunit) {
		Sunit = sunit;
	}
	public boolean isSgradute() {
		return Sgradute;
	}
	public void setSgradute(boolean sgradute) {
		Sgradute = sgradute;
	}
	public List<CNode> getLink() {
		return link;
	}
	public void setLink(List<CNode> link) {
		this.link = link;
	}
	
	
	

}
