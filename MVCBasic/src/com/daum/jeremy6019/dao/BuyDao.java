package com.daum.jeremy6019.dao;

import java.util.List;

import com.daum.jeremy6019.domain.Buy;

public interface BuyDao {

   //데이터를 삽입하는 메소드 
	public int insertBuy(Buy buy);
	
 	//데이터를 수정하는 메소드 
	public int updateBuy(Buy buy);
	
	//데이터를 삭제하는 메소드 
	public int deleteBuy(int buycode);
	
	//전체 데이터를 조회하는 메소드 
	public List<Buy>getListAll();
	
	//기본키를 가지고 조회하는 메소드 
	public Buy listBuy(int buycode);
	
}
