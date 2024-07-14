package com.memberCoupon.model;

import java.util.List;

public interface MemberCouponDAO_interface {
	public void insert(MemberCouponVO memberCouponVO);
    public void update(MemberCouponVO memberCouponVO);
    public void delete(Integer memberCouponID); // 一般資料庫不會做刪除
    public MemberCouponVO findByPrimaryKey(Integer empno);
    public List<MemberCouponVO> getAll();
  //萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<EmpVO> getAll(Map<String, String[]> map);
}
