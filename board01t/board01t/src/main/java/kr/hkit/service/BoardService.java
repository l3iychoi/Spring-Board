package kr.hkit.service;

import java.util.List;

import kr.hkit.domain.BoardDTO;
import kr.hkit.domain.Criteria;

public interface BoardService {
	public void register(BoardDTO board);
	public BoardDTO get(Long bno);
	public boolean modify(BoardDTO board);
	public boolean remove(Long bno);
	//public List<BoardDTO> getAll();
	public List<BoardDTO> getAll(Criteria cri);
	public int getTotal(Criteria cri);
}
