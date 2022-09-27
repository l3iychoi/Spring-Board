package kr.hkit.mapper;

import java.util.List;

import kr.hkit.domain.*;

public interface BoardMapper {
	//@Select("select * from tbl_board where bno > 0")
	public List<BoardDTO> getList();
	public List<BoardDTO> getListWithPaging(Criteria cri);
	
	public void insert(BoardDTO board);
	public BoardDTO read(Long bno);
	public int delete(Long bno);
	public int update(BoardDTO board);
	public int getTotalCount(Criteria cri);
	
}
