package kr.hkit.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.hkit.domain.BoardDTO;
import kr.hkit.domain.Criteria;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {

	@Setter(onMethod_ = {@Autowired} )
	private BoardService service;
	
	//@Test
	public void testModify() {
		BoardDTO board = service.get(6L);
		
		if(board==null) return;
		
		board.setTitle("제목 수정합니다.");
		log.info("****Modify :"+ service.modify(board));
	}
	
	//@Test
	public void testRemove() {
		log.info("****Remove : " + service.remove(8L));
	}
	
	//@Test
	public void testGet() {
		BoardDTO board = service.get(7L);
		log.info("****"+board);
	}
	
	@Test
	public void testGetAll() {
		for(BoardDTO board : service.getAll(new Criteria(2,10))) {
			log.info(board.getBno());
		}
	}
	
	
	//@Test
	public void testRegister() {
		BoardDTO board = new BoardDTO();
		board.setTitle("new2");
		board.setContent("HELLO WORLD2");
		board.setWriter("shin");
		
		service.register(board);
		
		log.info("*****생성된 게시물번호 :" +  board);
	}
	
	
	//@Test
	public void testExist() {
		log.info("****" + service);
		assertNotNull(service);
	}

}
