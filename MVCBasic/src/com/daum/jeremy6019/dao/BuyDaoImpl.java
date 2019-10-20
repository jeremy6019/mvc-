package com.daum.jeremy6019.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.daum.jeremy6019.domain.Buy;

public class BuyDaoImpl implements BuyDao {
     // 싱글톤 패턴 구현을 위한 코드 
	private BuyDaoImpl() {}
	
	private static BuyDao buyDao;
	
	public static BuyDao getInstance() {
		if(buyDao == null) {
			buyDao = new BuyDaoImpl();
		}
		return buyDao;
	}
	
	 static {
	    	try {
	    		Class.forName(
	    				"oracle.jdbc.driver.OracleDriver");
	    	} catch(Exception e) {
	    		System.out.printf("클래스 로드 예외%s\n",
	    				e.getMessage());
	    		e.printStackTrace();
	    	}
	 }
    
	 Connection con;
	 PreparedStatement pstmt;
	 ResultSet rs;
	
	
	@Override
	public int insertBuy(Buy buy) {
		int result = -1;
		
		try {
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:ORCL",
					"system","jeremy94");
			pstmt = con.prepareStatement(
					"insert into buy( "
					+ "buycode, itemname, ctmid, count) "
					+"values(buyseq.nextval,?,?,?) ");
			pstmt.setString(1, buy.getItemname());
			pstmt.setString(2, buy.getCtmid());
			pstmt.setInt(3, buy.getCount());			
			result = pstmt.executeUpdate();
			pstmt.close();
			con.close();			
		} catch (Exception e) {
			System.out.printf("데이터삽입 예외:%s\n",
					e.getMessage());
			e.printStackTrace();
		}		
		return result;
	}
   
	@Override
	public int updateBuy(Buy buy) {
	    int result = -1;
		try {
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:ORCL",
					"system","jeremy94");
			pstmt = con.prepareStatement(
					"update buy "
					+ "set itemname=?, ctmid=?, count=? "
					+ "where buycode=? ");
			pstmt.setString(1, buy.getItemname());
			pstmt.setString(2, buy.getCtmid());
			pstmt.setInt(3, buy.getCount());
			pstmt.setInt(4, buy.getBuycode());		
			result = pstmt.executeUpdate();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			System.out.printf("데이터 수정 예외:%s\n",
					e.getMessage());
			e.printStackTrace();
		}		
		return result;
	}
	
	
	@Override
	public int deleteBuy(int buycode) {
		int result = -1;
		try {
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:ORCL",
					"system","jeremy94");
			pstmt = con.prepareStatement(
					"delete from buy where buycode=? ");
			pstmt.setInt(1, buycode);		
			result = pstmt.executeUpdate();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			System.out.printf("데이터 삭제 예외:%s\n",
					e.getMessage());
			e.printStackTrace();
		}				
		return result;
	}

	@Override
	public List<Buy> getListAll() {
		    List<Buy>list = new ArrayList<Buy>();
			try {
				con = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:ORCL",
						"system","jeremy94");
				pstmt = con.prepareStatement(
						"select * from buy ");	
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Buy buy = new Buy();
					buy.setBuycode(
							rs.getInt("buycode"));
					buy.setItemname(
							rs.getString("itemname"));
					buy.setCtmid(
							rs.getString("ctmid"));
					buy.setCount(
							rs.getInt("count"));
					buy.setBuydate(
							rs.getDate("buydate"));
					
					list.add(buy);
					
				}
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e) {
				System.out.printf("데이터 읽기 예외:%s\n",
						e.getMessage());
				e.printStackTrace();
			}			
		    return list;
	}

	@Override
	public Buy listBuy(int buycode) {
		Buy buy = null;
		try {
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:ORCL",
					"system","jeremy94");
			pstmt = con.prepareStatement(
					"select * from buy where buycode= ? ");
			pstmt.setInt(1, buycode);		
			rs = pstmt.executeQuery();
			if(rs.next()) {
				buy = new Buy();
				buy.setBuycode(
						rs.getInt("buycode"));
				buy.setItemname(
						rs.getString("itemname"));
				buy.setCtmid(
						rs.getString("ctmid"));
				buy.setCount(
						rs.getInt("count"));
				buy.setBuydate(
						rs.getDate("buydate"));
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			System.out.printf("1개 가져오기 예외:%s\n",
					e.getMessage());
			e.printStackTrace();
		}				
		return buy;
	}

}
