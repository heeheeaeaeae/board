package board.model;

import java.util.Date;

public class BoardPanVO {
	private int bp_seq  ;
    private String mem_id	;
    private String bp_name	;
    private String del_yn	;
    private Date reg_dt	;
    
	public int getBp_seq() {
		return bp_seq;
	}
	public void setBp_seq(int bp_seq) {
		this.bp_seq = bp_seq;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getBp_name() {
		return bp_name;
	}
	public void setBp_name(String bp_name) {
		this.bp_name = bp_name;
	}
	public String getDel_yn() {
		return del_yn;
	}
	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
	}
	public Date getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}
	@Override
	public String toString() {
		return "BoardPanVO [bp_seq=" + bp_seq + ", mem_id=" + mem_id
				+ ", bp_name=" + bp_name + ", del_yn=" + del_yn + ", reg_dt="
				+ reg_dt + "]";
	}
	
	public BoardPanVO( String mem_id, String bp_name, String del_yn) {
		super();
		this.mem_id = mem_id;
		this.bp_name = bp_name;
		this.del_yn = del_yn;
	}
	
	public BoardPanVO(){
		
	}
    
}
