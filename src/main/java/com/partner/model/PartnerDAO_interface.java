package com.partner.model;

import java.util.*;

public interface PartnerDAO_interface {
          public void insert(PartnerVO partnerVO);
          public void update(PartnerVO partnerVO);
          public void delete(Integer partnerID); // 一般資料庫不會做刪除
          public PartnerVO findByPrimaryKey(Integer empno);
          public List<PartnerVO> getAll();
        //萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<EmpVO> getAll(Map<String, String[]> map); 
}
