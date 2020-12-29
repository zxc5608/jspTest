package kr.or.ddit.servlet.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class factorial {
	private static final Logger logger = LoggerFactory.getLogger(factorial.class);

	public static void main(String[] args) {
		factorial factorial = new factorial();

		int result = factorial.calculate(5);

		if (result == 120) {
			logger.debug("success");
		} else {
			logger.debug("fail");
		}
		
		
		result = factorial.calculate(0);
		if (result == 1) {
			logger.debug("success");
		} else {
			logger.debug("fail");
		}
		
		result = factorial.calculate(3);
		if (result == 6) {
			logger.debug("success");
		} else {
			logger.debug("fail");
		}
	
	}

	/**
	 * 
	 * Method : calculate 작성자 : PC25-PC 변경이력 :
	 * 
	 * @param n
	 * @return Method 설명 : 인자로 들어온 n값을 이용하여 팩토리얼을 계산
	 */
	public int calculate(int n) {
		/*
		 * int res = 1;
		 * 
		 * for (int i = 1; i <= n; i++) {
		 *  res *= i; 
		 *  } 
		 *  return res;
		 */
		//재귀함수 
		if(n <= 1)
			return 1;
		else
			return n * calculate(--n);
	}
}
