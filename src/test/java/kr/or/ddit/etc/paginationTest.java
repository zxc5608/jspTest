package kr.or.ddit.etc;

import static org.junit.Assert.*;

import org.junit.Test;

public class paginationTest {

	@Test
	public void test() {
		/***Given***/
		int userTotCnt = 32;
		int pagesize = 5;
		

		/***When***/
		int pagination=(int)Math.ceil((double)userTotCnt/pagesize);
		
		

		/***Then***/
		assertEquals(7, pagination);

	}

}
