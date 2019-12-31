package student.models;

public class CNode {
	private String Cno;
	private int Cunit;
	private int Cmark;
	private CNode next;
	public String getCno() {
		return Cno;
	}
	public void setCno(String cno) {
		Cno = cno;
	}
	public int getCunit() {
		return Cunit;
	}
	public void setCunit(int cunit) {
		Cunit = cunit;
	}
	public int getCmark() {
		return Cmark;
	}
	public void setCmark(int cmark) {
		Cmark = cmark;
	}
	public CNode getNext() {
		return next;
	}
	public void setNext(CNode next) {
		this.next = next;
	}
	

}
