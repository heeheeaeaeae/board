package board.model;

public class FileVO {
	private int file_seq  ;
    private int board_seq     ; 
	private String file_path	;
	
	
	public int getFile_seq() {
		return file_seq;
	}
	public void setFile_seq(int file_seq) {
		this.file_seq = file_seq;
	}
	public int getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	@Override
	public String toString() {
		return "FileVO [file_seq=" + file_seq + ", board_seq=" + board_seq
				+ ", file_path=" + file_path + "]";
	}

	
}
