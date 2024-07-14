package com.administrator.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdministratorJDBCDAO implements AdministratorDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/tia102_g5?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "123456";

	private static final String INSERT_STMT = "INSERT INTO administrator (administratorAccount,administratorPassword,administratorCreateTime,administratorStatus) VALUES (?, ?, ?, ?,)";
	private static final String GET_ALL_STMT = "SELECT administratorID,administratorAccount,administratorPassword,administratorCreateTime,administratorStatus FROM Administrator order by administratorID";
	private static final String GET_ONE_STMT = "SELECT administratorID,administratorAccount,administratorPassword,administratorCreateTime,administratorStatus FROM Administrator where administratorID = ?";
	private static final String DELETE = "DELETE FROM administratorID where administratorID = ?";
	private static final String UPDATE = "UPDATE administrator set administratorAccount=?, administratorPassword=?, administratorCreateTime=?, administratorStatus=? where administratorID = ?";

	@Override
	public void insert(AdministratorVO administratorVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, administratorVO.getAdministratorAccount());
			pstmt.setString(2, administratorVO.getAdministratorPassword());
			pstmt.setTimestamp(3, administratorVO.getAdministratorCreateTime());
			pstmt.setInt(4, administratorVO.getAdministratorStatus());

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
	public void update(AdministratorVO administratorVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, administratorVO.getAdministratorAccount());
			pstmt.setString(2, administratorVO.getAdministratorPassword());
			pstmt.setTimestamp(3, administratorVO.getAdministratorCreateTime());
			pstmt.setInt(4, administratorVO.getAdministratorStatus());

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
	public void delete(Integer administratorID) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, administratorID);

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
	public AdministratorVO findByPrimaryKey(Integer administratorID) {

		AdministratorVO administratorVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, administratorID);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				administratorVO = new AdministratorVO();
				administratorVO.setAdministratorID(rs.getInt("administratorID"));
				administratorVO.setAdministratorAccount(rs.getString("administratorAccount"));
				administratorVO.setAdministratorPassword(rs.getString("administratorPassword"));
				administratorVO.setAdministratorCreateTime(rs.getTimestamp("administratorCreateTime"));
				administratorVO.setAdministratorStatus(rs.getInt("administratorStatus"));
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
		return administratorVO;
	}

	@Override
	public List<AdministratorVO> getAll() {
		List<AdministratorVO> list = new ArrayList<AdministratorVO>();
		AdministratorVO administratorVO = null;

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
				administratorVO = new AdministratorVO();
				administratorVO.setAdministratorID(rs.getInt("administratorID"));
				administratorVO.setAdministratorAccount(rs.getString("administratorAccount"));
				administratorVO.setAdministratorPassword(rs.getString("administratorPassword"));
				administratorVO.setAdministratorCreateTime(rs.getTimestamp("administratorCreateTime"));
				administratorVO.setAdministratorStatus(rs.getInt("administratorStatus"));
				list.add(administratorVO); // Store the row in the list
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

		AdministratorJDBCDAO dao = new AdministratorJDBCDAO();

		// 新增
		AdministratorVO administratorVO01 = new AdministratorVO();
		administratorVO01.setAdministratorAccount("我是廠商帳號");
		administratorVO01.setAdministratorPassword("我是廠商密碼");
		administratorVO01.setAdministratorCreateTime(java.sql.Timestamp.valueOf("2024-01-01 12:00:21"));
		administratorVO01.setAdministratorStatus(1);
		dao.insert(administratorVO01);

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
//		EmpVO empVO3 = dao.findByPrimaryKey(7001);
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
