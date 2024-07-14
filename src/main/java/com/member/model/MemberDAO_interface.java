package com.member.model;

import java.util.List;

public interface MemberDAO_interface {
	public void insert(MemberVO memberVO);
	public void update(MemberVO memberVO);
	public void delete(Integer memberID); // 一般資料庫不會做刪除
	public MemberVO findByPrimaryKey(Integer memberID);
	public List<MemberVO> getAll();
	// 萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<EmpVO> getAll(Map<String, String[]> map); 
	
}
