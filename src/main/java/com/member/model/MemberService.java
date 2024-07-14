package com.member.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class MemberService {

	private MemberDAO_interface dao;

	public MemberService() {
		dao = new MemberJDBCDAO();
	}

	public MemberVO addMember(String memberAccount,String memberPassword,String memberName, String memberPhone
			,String memberNickName, Integer memberStatus, Timestamp memberCreateTime,byte[] memberPicture,Date birthday,String memberAddress
			,String gender,String nationalID) {

		MemberVO memberVO = new MemberVO();
		memberVO.setMemberAccount("");
		memberVO.setMemberPassword("");
		memberVO.setMemberName(memberName);
		memberVO.setMemberPhone(memberPhone);
		memberVO.setMemberNickName("");
		memberVO.setMemberStatus(1);
		memberVO.setMemberCreateTime(java.sql.Timestamp.valueOf("2024-07-07 12:49:55"));
		memberVO.setMemberPicture(memberPicture);
		memberVO.setBirthday(java.sql.Date.valueOf("2005-03-01"));
		memberVO.setMemberAddress("");
		memberVO.setGender("");
		memberVO.setNationalID("");
		dao.insert(memberVO);
		return memberVO;
	}

	public MemberVO updateMember(Integer memberID, String memberName,String memberPhone,byte[] memberPicture) {

		MemberVO memberVO = new MemberVO();
		memberVO.setMemberID(memberID);
		memberVO.setMemberName(memberName);
		memberVO.setMemberPhone(memberPhone);
		memberVO.setMemberPicture(memberPicture);
		dao.update(memberVO);

		return memberVO;
	}

	public void deleteMember(Integer memberID) {
		dao.delete(memberID);
	}

	public MemberVO getOneMember(Integer memberID) {
		return dao.findByPrimaryKey(memberID);
	}

	public List<MemberVO> getAll() {
		return dao.getAll();
	}
}
