package board.model;

import java.util.Date;

public class BoardVO {
	private Integer board_seq;
	private Integer pboard_seq;
	private Integer bp_seq;
	private Integer group_seq;
	private String title;
	private String content;
	private Date reg_dt;
	private String del_yn;
	private String mem_id;
	
	
	public Integer getBoard_seq() {
		return board_seq;
	}

	public void setBoard_seq(Integer board_seq) {
		this.board_seq = board_seq;
	}

	public Integer getPboard_seq() {
		return pboard_seq;
	}

	public void setPboard_seq(Integer pboard_seq) {
		this.pboard_seq = pboard_seq;
	}

	public Integer getBp_seq() {
		return bp_seq;
	}

	public void setBp_seq(Integer bp_seq) {
		this.bp_seq = bp_seq;
	}

	public Integer getGroup_seq() {
		return group_seq;
	}

	public void setGroup_seq(Integer group_seq) {
		this.group_seq = group_seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getReg_dt() {
		return reg_dt;
	}

	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
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

	public BoardVO(){
		
	}
	
	public BoardVO(Integer board_seq, Integer pboard_seq, Integer bp_seq, Integer group_seq,
			String title, String content, String mem_id) {
		super();
		this.board_seq = board_seq;
		this.pboard_seq = pboard_seq;
		this.bp_seq = bp_seq;
		this.group_seq = group_seq;
		this.title = title;
		this.content = content;
		this.mem_id= mem_id;
	}

	@Override
	public String toString() {
		return "BoardVO [board_seq=" + board_seq + ", pboard_seq=" + pboard_seq
				+ ", bp_seq=" + bp_seq + ", group_seq=" + group_seq
				+ ", title=" + title + ", content=" + content + ", reg_dt="
				+ reg_dt + ", del_yn=" + del_yn + ", mem_id=" + mem_id + "]";
	}
	
	
	
}
