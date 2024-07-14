package com.partner.model;

import java.util.*;
import java.sql.*;

public class PartnerJDBCDAO implements PartnerDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/tia102_g5?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "123456";

	private static final String INSERT_STMT = 
		"INSERT INTO emp2 (ename,job,hiredate,sal,comm,deptno) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT empno,ename,job,hiredate,sal,comm,deptno FROM emp2 order by empno";
	private static final String GET_ONE_STMT = 
		"SELECT empno,ename,job,hiredate,sal,comm,deptno FROM emp2 where empno = ?";
	private static final String DELETE = 
		"DELETE FROM emp2 where empno = ?";
	private static final String UPDATE = 
		"UPDATE emp2 set ename=?, job=?, hiredate=?, sal=?, comm=?, deptno=? where empno = ?";

	@Override
	public void insert(PartnerVO partnerVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, partnerVO.getTaxID());
			pstmt.setString(2, partnerVO.getPartnerName());
			pstmt.setString(3, partnerVO.getPartnerHeading());
			pstmt.setString(4, partnerVO.getPartnerAddress());
			pstmt.setString(5, partnerVO.getPartnerPhone());
			pstmt.setString(6, partnerVO.getPartnerPassword());
			pstmt.setString(7, partnerVO.getPartnerEmail());
			pstmt.setTimestamp(8, partnerVO.getPartnerCreateTime());
			pstmt.setInt(9, partnerVO.getPartnerAccountStatus());

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
	public void update(PartnerVO partnerVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, partnerVO.getTaxID());
			pstmt.setString(2, partnerVO.getPartnerName());
			pstmt.setString(3, partnerVO.getPartnerHeading());
			pstmt.setString(4, partnerVO.getPartnerAddress());
			pstmt.setString(5, partnerVO.getPartnerPhone());
			pstmt.setString(6, partnerVO.getPartnerContactPerson());
			pstmt.setString(7, partnerVO.getPartnerPassword());
			pstmt.setString(8, partnerVO.getPartnerEmail());
			pstmt.setTimestamp(9, partnerVO.getPartnerCreateTime());
			pstmt.setInt(10, partnerVO.getPartnerAccountStatus());

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
	public void delete(Integer partnerID) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, partnerID);

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
	public PartnerVO findByPrimaryKey(Integer partnerID) {

		PartnerVO partnerVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, partnerID);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				partnerVO = new PartnerVO();
				partnerVO.setTaxID(rs.getString("taxID"));
				partnerVO.setPartnerName(rs.getString("partnerName"));
				partnerVO.setPartnerHeading(rs.getString("partnerHeading"));
				partnerVO.setPartnerAddress(rs.getString("partnerAddress"));
				partnerVO.setPartnerPhone(rs.getString("partnerPhone"));
				partnerVO.setPartnerContactPerson(rs.getString("partnerContactPerson"));
				partnerVO.setPartnerPassword(rs.getString("partnerPassword"));
				partnerVO.setPartnerEmail(rs.getString("partnerEmail"));
				partnerVO.setPartnerCreateTime(rs.getTimestamp("partnerCreateTime"));
				partnerVO.setPartnerAccountStatus(rs.getInt("partnerAccountStatus"));
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
		return partnerVO;
	}

	@Override
	public List<PartnerVO> getAll() {
		List<PartnerVO> list = new ArrayList<PartnerVO>();
		PartnerVO partnerVO = null;

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
				partnerVO = new PartnerVO();
				partnerVO.setPartnerID(rs.getInt("partnerID"));
				partnerVO.setTaxID(rs.getString("taxID"));
				partnerVO.setPartnerName(rs.getString("partnerName"));
				partnerVO.setPartnerAddress(rs.getString("partnerAddress"));
				partnerVO.setPartnerPhone(rs.getString("partnerPhone"));
				partnerVO.setPartnerContactPerson(rs.getString("partnerContactPerson"));
				partnerVO.setPartnerPassword(rs.getString("partnerPassword"));
				partnerVO.setPartnerEmail(rs.getString("partnerEmail"));
				partnerVO.setPartnerCreateTime(rs.getTimestamp("partnerCreateTime"));
				partnerVO.setPartnerAccountStatus(rs.getInt("partnerAccountStatus"));
				list.add(partnerVO); // Store the row in the list
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

		PartnerJDBCDAO dao = new PartnerJDBCDAO();

		// 新增
		PartnerVO partnerVO1 = new PartnerVO();
		partnerVO1.setTaxID("16086448");
		partnerVO1.setPartnerName("高薪勝利");
		partnerVO1.setPartnerHeading("高薪勝利(股)有限公司");
		partnerVO1.setPartnerAddress("新北市樹林區");
		partnerVO1.setPartnerPhone("0912283746");
		partnerVO1.setPartnerContactPerson("王小明");
		partnerVO1.setPartnerPassword("QAXWSX12345");
		partnerVO1.setPartnerEmail("QAXWSX12345");
		partnerVO1.setPartnerCreateTime(java.sql.Timestamp.valueOf("2005-01-01 12:00:00"));
		partnerVO1.setPartnerAccountStatus(0);
		dao.insert(partnerVO1);

		// 修改
//		EmpVO empVO2 = new EmpVO();
//		empVO2.setEmpno(7001);
//		empVO2.setEname("吳永志2");
//		empVO2.setJob("MANAGER2");
//		empVO2.setHiredate(java.sql.Date.valueOf("2002-01-01"));
//		empVO2.setSal(new Double(20000));
//		empVO2.setComm(new Double(200));
//		empVO2.setDeptno(20);
//		dao.update(empVO2);

		// 刪除
//		dao.delete(7014);

		// 查詢
//		PartnerVO empVO3 = dao.findByPrimaryKey(7001);
//		System.out.print(empVO3.getEmpno() + ",");
//		System.out.print(empVO3.getEname() + ",");
//		System.out.print(empVO3.getJob() + ",");
//		System.out.print(empVO3.getHiredate() + ",");
//		System.out.print(empVO3.getSal() + ",");
//		System.out.print(empVO3.getComm() + ",");
//		System.out.println(empVO3.getDeptno());
//		System.out.println("---------------------");

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