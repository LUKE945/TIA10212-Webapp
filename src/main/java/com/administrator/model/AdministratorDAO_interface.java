package com.administrator.model;

import java.util.*;

public interface AdministratorDAO_interface {
	public void insert(AdministratorVO administratorVO);
    public void update(AdministratorVO administratorVO);
    public void delete(Integer administratorID); // 一般資料庫不會做刪除
    public AdministratorVO findByPrimaryKey(Integer administratorID);
    public List<AdministratorVO> getAll();
  //萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<EmpVO> getAll(Map<String, String[]> map);
}