package board.model;

import java.util.Date;

public class RepleVO {
	private int re_seq	;
    private int board_seq; 
    private String re_content	;
    private Date re_dt	;
    private String del_yn	;
    private String mem_id	;
    
    
	public int getRe_seq() {
		return re_seq;
	}
	public void setRe_seq(int re_seq) {
		this.re_seq = re_seq;
	}
	public int getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}
	public String getRe_content() {
		return re_content;
	}
	public void setRe_content(String re_content) {
		this.re_content = re_content;
	}
	public Date getRe_dt() {
		return re_dt;
	}
	public void setRe_dt(Date re_dt) {
		this.re_dt = re_dt;
	}
	public String getDel_yn() {
		return del_yn;
	}
	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	@Override
	public String toString() {
		return "RepleVO [re_seq=" + re_seq + ", board_seq=" + board_seq
				+ ", re_content=" + re_content + ", re_dt=" + re_dt
				+ ", del_yn=" + del_yn + ", mem_id=" + mem_id + "]";
	}
    
    
    
    
}
