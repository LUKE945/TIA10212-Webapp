package com.member.model;

import java.util.*;
import java.sql.*;

public class MemberJDBCDAO implements MemberDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/tia102_g5?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "123456";

	private static final String INSERT_STMT = "INSERT INTO generalMember (memberAccount,memberPassword,memberName,memberPhone,memberNickName,memberStatus,memberCreateTime,memberPicture,birthday,memberAddress,gender,nationalID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT memberID,memberAccount,memberPassword,memberName,memberPhone,memberNickName,memberStatus,memberCreateTime,memberPicture,birthday,memberAddress,gender,nationalID FROM GeneralMember order by memberID";
	private static final String GET_ONE_STMT = "SELECT memberID,memberAccount,memberPassword,memberName,memberPhone,memberNickName,memberStatus,memberCreateTime,memberPicture,birthday,memberAddress,gender,nationalID FROM GeneralMember where memberID = ?";
	private static final String DELETE = "DELETE FROM generalMember where memberID = ?";
	private static final String UPDATE = "UPDATE generalMember set memberName = ? ,memberPhone = ? ,memberPicture = ? where memberID = ?";

	@Override
	public void insert(MemberVO memberVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, memberVO.getMemberAccount());
			pstmt.setString(2, memberVO.getMemberPassword());
			pstmt.setString(3, memberVO.getMemberName());
			pstmt.setString(4, memberVO.getMemberPhone());
			pstmt.setString(5, memberVO.getMemberNickName());
			pstmt.setInt(6, memberVO.getMemberStatus());
			pstmt.setTimestamp(7, memberVO.getMemberCreateTime());
			pstmt.setBytes(8, memberVO.getMemberPicture());
			pstmt.setDate(9, memberVO.getBirthday());
			pstmt.setString(10, memberVO.getMemberAddress());
			pstmt.setString(11, memberVO.getGender());
			pstmt.setString(12, memberVO.getNationalID());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void update(MemberVO memberVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

//			pstmt.setString(1, memberVO.getMemberAccount());
//			pstmt.setString(2, memberVO.getMemberPassword());
			pstmt.setString(1, memberVO.getMemberName());
			pstmt.setString(2, memberVO.getMemberPhone());
//			pstmt.setString(, memberVO.getMemberNickName());
//			pstmt.setInt(6, memberVO.getMemberStatus());
//			pstmt.setTimestamp(7, memberVO.getMemberCreateTime());
			pstmt.setBytes(3, memberVO.getMemberPicture());
			pstmt.setInt(4, memberVO.getMemberID());
//			pstmt.setDate(9, memberVO.getBirthday());
//			pstmt.setString(10, memberVO.getMemberAddress());
//			pstmt.setString(11, memberVO.getGender());
//			pstmt.setString(12, memberVO.getNationalID());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void delete(Integer memberID) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, memberID);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public MemberVO findByPrimaryKey(Integer memberID) {

		MemberVO memberVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, memberID);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// memberVO 也稱為 Domain objects
				memberVO = new MemberVO();
				memberVO.setMemberID(rs.getInt("memberID"));
				memberVO.setMemberAccount(rs.getString("memberAccount"));
				memberVO.setMemberPassword(rs.getString("memberPassword"));
				memberVO.setMemberName(rs.getString("memberName"));
				memberVO.setMemberPhone(rs.getString("memberPhone"));
				memberVO.setMemberNickName(rs.getString("memberNickName"));
				memberVO.setMemberStatus(rs.getInt("memberStatus"));
				memberVO.setMemberCreateTime(rs.getTimestamp("memberCreateTime"));
				memberVO.setMemberPicture(rs.getBytes("memberPicture"));
				memberVO.setBirthday(rs.getDate("birthday"));
				memberVO.setMemberAddress(rs.getString("memberAddress"));
				memberVO.setGender(rs.getString("gender"));
				memberVO.setNationalID(rs.getString("nationalID"));
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return memberVO;
	}

	@Override
	public List<MemberVO> getAll() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		MemberVO memberVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				memberVO = new MemberVO();
				memberVO.setMemberID(rs.getInt("memberID"));
				memberVO.setMemberAccount(rs.getString("memberAccount"));
				memberVO.setMemberPassword(rs.getString("memberPassword"));
				memberVO.setMemberName(rs.getString("memberName"));
				memberVO.setMemberPhone(rs.getString("memberPhone"));
				memberVO.setMemberNickName(rs.getString("memberNickName"));
				memberVO.setMemberStatus(rs.getInt("memberStatus"));
				memberVO.setMemberCreateTime(rs.getTimestamp("memberCreateTime"));
				memberVO.setMemberPicture(rs.getBytes("memberPicture"));
				memberVO.setBirthday(rs.getDate("birthday"));
				memberVO.setMemberAddress(rs.getString("memberAddress"));
				memberVO.setGender(rs.getString("gender"));
				memberVO.setNationalID(rs.getString("nationalID"));
				list.add(memberVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {

		MemberJDBCDAO dao = new MemberJDBCDAO();

		// 新增
//		MemberVO memberVO1 = new MemberVO();
//		memberVO1.setMemberAccount("qwe123@gmail.com");
//		memberVO1.setMemberPassword("asd112233");
//		memberVO1.setMemberName("劉德華");
//		memberVO1.setMemberPhone("0922222222");
//		memberVO1.setMemberNickName("華仔");
//		memberVO1.setMemberStatus(1);
//		memberVO1.setMemberCreateTime(java.sql.Timestamp.valueOf("2024-07-07 12:49:55"));
//		memberVO1.setMemberPicture(null);
//		memberVO1.setBirthday(java.sql.Date.valueOf("2005-03-01"));
//		memberVO1.setMemberAddress("台中市");
//		memberVO1.setGender("男");
//		memberVO1.setNationalID("S123323322");
//		dao.insert(memberVO1);
		
		// 查詢
//		MemberVO mbVO2 = dao.findByPrimaryKey(1);
//		System.out.print(mbVO2.getMemberAccount() + ",");
//		System.out.print(mbVO2.getMemberPassword() + ",");
//		System.out.print(mbVO2.getMemberName() + ",");
//		System.out.print(mbVO2.getMemberPhone() + ",");
//		System.out.print(mbVO2.getMemberNickName() + ",");
//		System.out.print(mbVO2.getMemberStatus() + ",");
//		System.out.print(mbVO2.getMemberCreateTime()+ ",");
//		System.out.print(mbVO2.getMemberPicture()+ ",");
//		System.out.print(mbVO2.getBirthday()+ ",");
//		System.out.print(mbVO2.getMemberAddress()+ ",");
//		System.out.print(mbVO2.getGender()+ ",");
//		System.out.print(mbVO2.getNationalID()+ ",");
//		System.out.println("---------------------");

		// 修改
//		MemberVO memberVO1 = new MemberVO();
		
//		memberVO1.setMemberID(3);
//		memberVO1.setMemberAccount("我是帳號2");
//		memberVO1.setMemberPassword("我是密碼2");
//		memberVO1.setMemberName("周杰倫");
//		memberVO1.setMemberPhone("0999999999");
//		memberVO1.setMemberNickName("我是暱稱1");
//		memberVO1.setMemberStatus(1);
//		memberVO1.setMemberCreateTime(java.sql.Timestamp.valueOf("2024-07-07 12:49:55"));
//		memberVO1.setMemberPicture(null);
//		memberVO1.setBirthday(java.sql.Date.valueOf("2005-03-01"));
//		memberVO1.setMemberAddress("我是地址1");
//		memberVO1.setGender("我是性別2");
//		memberVO1.setNationalID("我是身份證字號1");
//		dao.update(memberVO1);

		// 刪除
//		dao.delete(1);


		// 查詢
//		List<EmpVO> list = dao.getAll();
//		for (EmpVO aEmp : list) {
//			System.out.print(aEmp.getEmpno() + ",");
//			System.out.print(aEmp.getEname() + ",");
//			System.out.print(aEmp.getJob() + ",");
//			System.out.print(aEmp.getHiredate() + ",");
//			System.out.print(aEmp.getSal() + ",");
//			System.out.print(aEmp.getComm() + ",");
//			System.out.print(aEmp.getDeptno());
//			System.out.println();
//		}
	}
}
