package com.daum.jeremy6019.main;

import com.daum.jeremy6019.dao.BuyDao;
import com.daum.jeremy6019.dao.BuyDaoImpl;
import com.daum.jeremy6019.domain.Buy;
import com.daum.jeremy6019.view.BuyView;

public class Main {

	public static void main(String[] args) {
	
		BuyDao dao = BuyDaoImpl.getInstance();
		Buy buy = new Buy();
		
	   new BuyView();


//			System.out.printf("%s\n", 
//					dao.listBuy(24));
	
			
	/*	
			System.out.printf("전체 데이터 조회 성공!! \n");
	        System.out.printf("%s\n", dao.getListAll());
*/
			
			
		
/*		
			buy.setBuycode(26);
			buy.setItemname("모닝");
			buy.setCtmid("gaudi007");
			buy.setCount(3);
*/	

			
//		    int r = dao.insertBuy(buy); //데이터 삽입 확인 

//			int r = dao.updateBuy(buy); //데이터 수정 확인 

/*			
			int r = dao.deleteBuy(21);

			// 데이터 수정, 삽입, 삭제 확인 검증 		
			if( r > 0) {
				System.out.printf("삭제 성공!! \n");
			} else {
				System.out.printf("삭제 실패!! \n");
			}
*/
	

	}

}
