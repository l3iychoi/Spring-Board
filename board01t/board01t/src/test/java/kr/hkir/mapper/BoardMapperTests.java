package kr.hkir.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.hkit.domain.BoardDTO;
import kr.hkit.domain.Criteria;
import kr.hkit.mapper.BoardMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Setter(onMethod_ = {@Autowired})
	private BoardMapper mapper;
	
	//@Test
	public void testUpdate() {
		BoardDTO board = new BoardDTO();
		board.setBno(1L);
		board.setTitle("수정된제목");
		board.setContent("수정된내용");
		board.setWriter("user55");
		
		log.info("****Update cnt : "+ mapper.update(board));
		
	}
	
	//@Test
	public void testDelete() {
		log.info("****Delete cnt : " + mapper.delete(1L));
	}
	
	
	//@Test
	public void testRead() {
		BoardDTO board = mapper.read(7L);
		log.info(board);
	}
	
	//@Test
	public void testInsert() {
		BoardDTO board = new BoardDTO();
		board.setTitle("new1");
		board.setContent("HELLO WORLD!");
		board.setWriter("user07");
		
		mapper.insert(board);
		
		log.info(board);
	}
	
	//@Test
	public void testGetList() {
		for(BoardDTO board : mapper.getList()) {
			log.info(board);
		}
	}
	@Test
		public void testPaging() {
			Criteria cri = new Criteria();
			cri.setPageNum(1);
			cri.setAmount(20);
			
			List<BoardDTO> list = mapper.getListWithPaging(cri);
			
			list.forEach(board->log.info(board.getBno()));
		}

}
