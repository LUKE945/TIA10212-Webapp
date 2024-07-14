package com.memberCoupon.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberCouponJDBCDAO implements MemberCouponDAO_interface{
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/tia102_g5?serverTimezone=Asia/Taipei";
		String userid = "root";
		String passwd = "123456";

		private static final String INSERT_STMT = 
			"INSERT INTO membercoupon (memberID,couponID,memberCouponExpirationDate,memberCoupoStatus,memberCouponCreateTime) VALUES (?, ?, ?, ?, ?)";
		private static final String GET_ALL_STMT = 
			"SELECT memberCouponID,memberID,couponID,memberCouponExpirationDate,memberCoupoStatus,memberCouponCreateTime FROM membercoupon order by memberCouponID";
		private static final String GET_ONE_STMT = 
			"SELECT memberCouponID,memberID,couponID,memberCouponExpirationDate,memberCoupoStatus,memberCouponCreateTime FROM membercoupon where memberCouponID = ?";
		private static final String DELETE = 
			"DELETE FROM membercoupon where memberCouponID = ?";
		private static final String UPDATE = 
			"UPDATE membercoupon set memberID=?, couponID=?, memberCouponExpirationDate=?, memberCoupoStatus=?, memberCouponCreateTime=? where memberCouponID = ?";

		@Override
		public void insert(MemberCouponVO memberCouponVO) {

			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				Class.forName(driver);
				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(INSERT_STMT);

				pstmt.setInt(1, memberCouponVO.getMemberID());
				pstmt.setInt(2, memberCouponVO.getCouponID());
				pstmt.setDate(3, memberCouponVO.getMemberCouponExpirationDate());
				pstmt.setInt(4, memberCouponVO.getMemberCoupoStatus());
				pstmt.setTimestamp(5, memberCouponVO.getMemberCouponCreateTime());
				
				pstmt.executeUpdate();

				// Handle any driver errors
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("Couldn't load database driver. "
						+ e.getMessage());
				// Handle any SQL errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
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
		public void update(MemberCouponVO memberCouponVO) {

			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				Class.forName(driver);
				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(UPDATE);

				pstmt.setInt(1, memberCouponVO.getMemberID());
				pstmt.setInt(2, memberCouponVO.getCouponID());
				pstmt.setDate(3, memberCouponVO.getMemberCouponExpirationDate());
				pstmt.setInt(4, memberCouponVO.getMemberCoupoStatus());
				pstmt.setTimestamp(5, memberCouponVO.getMemberCouponCreateTime());

				pstmt.executeUpdate();

				// Handle any driver errors
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("Couldn't load database driver. "
						+ e.getMessage());
				// Handle any SQL errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
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
		public void delete(Integer memberCouponID) {

			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				Class.forName(driver);
				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(DELETE);

				pstmt.setInt(1, memberCouponID);

				pstmt.executeUpdate();

				// Handle any driver errors
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("Couldn't load database driver. "
						+ e.getMessage());
				// Handle any SQL errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
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
		public MemberCouponVO findByPrimaryKey(Integer memberCouponID) {

			MemberCouponVO memberCouponVO = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				Class.forName(driver);
				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(GET_ONE_STMT);

				pstmt.setInt(1, memberCouponID);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					// empVo 也稱為 Domain objects
					memberCouponVO = new MemberCouponVO();
					memberCouponVO.setMemberCouponID(rs.getInt("memberCouponID"));
					memberCouponVO.setMemberID(rs.getInt("memberID"));
					memberCouponVO.setCouponID(rs.getInt("couponID"));
					memberCouponVO.setMemberCouponExpirationDate(rs.getDate("memberCouponExpirationDate"));
					memberCouponVO.setMemberCoupoStatus(rs.getInt("memberCoupoStatus"));
					memberCouponVO.setMemberCouponCreateTime(rs.getTimestamp("memberCouponCreateTime"));
				}

				// Handle any driver errors
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("Couldn't load database driver. "
						+ e.getMessage());
				// Handle any SQL errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
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
			return memberCouponVO;
		}

		@Override
		public List<MemberCouponVO> getAll() {
			List<MemberCouponVO> list = new ArrayList<MemberCouponVO>();
			MemberCouponVO memberCouponVO = null;

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
					memberCouponVO = new MemberCouponVO();
					memberCouponVO.setMemberCouponID(rs.getInt("memberCouponID"));
					memberCouponVO.setMemberID(rs.getInt("memberID"));
					memberCouponVO.setCouponID(rs.getInt("couponID"));
					memberCouponVO.setMemberCouponExpirationDate(rs.getDate("memberCouponExpirationDate"));
					memberCouponVO.setMemberCoupoStatus(rs.getInt("memberCoupoStatus"));
					memberCouponVO.setMemberCouponCreateTime(rs.getTimestamp("memberCouponCreateTime"));
					list.add(memberCouponVO); // Store the row in the list
				}

				// Handle any driver errors
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("Couldn't load database driver. "
						+ e.getMessage());
				// Handle any SQL errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
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

			MemberCouponJDBCDAO dao = new MemberCouponJDBCDAO();

			// 新增
			MemberCouponVO memberCouponVO1 = new MemberCouponVO();
			memberCouponVO1.setMemberID(1);
			memberCouponVO1.setCouponID(2);
			memberCouponVO1.setMemberCouponExpirationDate(java.sql.Date.valueOf("2005-01-01"));
			memberCouponVO1.setMemberCoupoStatus(0);
			memberCouponVO1.setMemberCouponCreateTime(java.sql.Timestamp.valueOf("2005-01-01 12:00:00"));
			dao.insert(memberCouponVO1);

			// 修改
//			EmpVO empVO2 = new EmpVO();
//			empVO2.setEmpno(7001);
//			empVO2.setEname("吳永志2");
//			empVO2.setJob("MANAGER2");
//			empVO2.setHiredate(java.sql.Date.valueOf("2002-01-01"));
//			empVO2.setSal(new Double(20000));
//			empVO2.setComm(new Double(200));
//			empVO2.setDeptno(20);
//			dao.update(empVO2);

			// 刪除
//			dao.delete(7014);

			// 查詢
//			EmpVO empVO3 = dao.findByPrimaryKey(7001);
//			System.out.print(empVO3.getEmpno() + ",");
//			System.out.print(empVO3.getEname() + ",");
//			System.out.print(empVO3.getJob() + ",");
//			System.out.print(empVO3.getHiredate() + ",");
//			System.out.print(empVO3.getSal() + ",");
//			System.out.print(empVO3.getComm() + ",");
//			System.out.println(empVO3.getDeptno());
//			System.out.println("---------------------");

			// 查詢
//			List<EmpVO> list = dao.getAll();
//			for (EmpVO aEmp : list) {
//				System.out.print(aEmp.getEmpno() + ",");
//				System.out.print(aEmp.getEname() + ",");
//				System.out.print(aEmp.getJob() + ",");
//				System.out.print(aEmp.getHiredate() + ",");
//				System.out.print(aEmp.getSal() + ",");
//				System.out.print(aEmp.getComm() + ",");
//				System.out.print(aEmp.getDeptno());
//				System.out.println();
//			}
		}
}