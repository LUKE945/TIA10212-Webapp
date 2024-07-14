package com.member.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.member.model.MemberService;
import com.member.model.MemberVO;
@MultipartConfig
public class MemberServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String str = req.getParameter("memberID");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入會員編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/member/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			Integer memberID = null;
			try {
				memberID = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("會員編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/member/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始查詢資料 *****************************************/
			MemberService memberSvc = new MemberService();
			MemberVO memberVO = memberSvc.getOneMember(memberID);
			if (memberVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/member/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("memberVO", memberVO); // 資料庫取出的empVO物件,存入req
			String url = "/member/listOneMember.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);
		}
		if ("getOne_For_Update".equals(action)) { // 來自listAllMember.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer memberID = Integer.valueOf(req.getParameter("memberID"));

			/*************************** 2.開始查詢資料 ****************************************/
			MemberService memberSvc = new MemberService();
			MemberVO memberVO = memberSvc.getOneMember(memberID);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			req.setAttribute("memberVO", memberVO); // 資料庫取出的empVO物件,存入req
			String url = "/member/update_member_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_member_input.jsp
			successView.forward(req, res);
		}
		/*********************** 修改 *************************/
		if ("update".equals(action)) { // 來自update_member_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			Part filePart = req.getPart("memberPicture");
	        byte[] memberPicture = null;
	        if (filePart != null && filePart.getSize() > 0) {
	            InputStream inputStream = filePart.getInputStream();
	            memberPicture = inputStream.readAllBytes();
	        }

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer memberID = Integer.valueOf(req.getParameter("memberID").trim());

			String memberName = req.getParameter("memberName");
			String memberNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (memberName == null || memberName.trim().length() == 0) {
				errorMsgs.add("會員姓名: 請勿空白");
			} else if (!memberName.trim().matches(memberNameReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("會員姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
			}

			String memberPhone = req.getParameter("memberPhone");
			System.out.println("-----------------------------");
			System.out.println(memberPhone==null);
			System.out.println(memberPhone);
			System.out.println("-----------------------------");
			if (memberPhone == null || memberPhone.trim().length() == 0) {
				errorMsgs.add("電話:請勿空白");
			}
			
			MemberVO memberVO = new MemberVO();
			memberVO.setMemberID(memberID);
			memberVO.setMemberName(memberName);
			memberVO.setMemberPhone(memberPhone);
			memberVO.setMemberPicture(memberPicture);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("memberVO", memberVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/member/update_member_input.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/
			MemberService memberSvc = new MemberService();
			memberVO = memberSvc.updateMember(memberID,memberName, memberPhone,memberPicture);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("memberVO", memberVO); // 資料庫update成功後,正確的的memberVO物件,存入req
			String url = "/member/listOneMember.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneMember.jsp
			successView.forward(req, res);
		}
		/*********************** 新增 *************************/
			if ("insert".equals(action)) { // 來自addMember.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			Part filePart = req.getPart("memberPicture");
	        byte[] memberPicture = null;
	        if (filePart != null && filePart.getSize() > 0) {
	            InputStream inputStream = filePart.getInputStream();
	            memberPicture = inputStream.readAllBytes();
	        }
			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			String memberName = req.getParameter("memberName").trim();
			String memberNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (memberName == null || memberName.trim().length() == 0) {
				errorMsgs.add("員工姓名: 請勿空白");
			} else if (!memberName.trim().matches(memberNameReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("員工姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
			}
			
			String memberPhone = req.getParameter("memberPhone").trim();
			if (memberPhone == null || memberPhone.trim().length() == 0) {
				errorMsgs.add("電話:請勿空白");
			}
			
			MemberVO memberVO = new MemberVO();
			memberVO.setMemberAccount(null);
			memberVO.setMemberPassword(null);
			memberVO.setMemberName(memberName);
			memberVO.setMemberPhone(memberPhone);
			memberVO.setMemberNickName(null);
			memberVO.setMemberStatus(1);
			memberVO.setMemberCreateTime(null);
			memberVO.setMemberPicture(memberPicture);
			memberVO.setBirthday(null);
			memberVO.setMemberAddress(null);
			memberVO.setGender(null);
			memberVO.setNationalID(null);
			
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("memberVO", memberVO); // 含有輸入格式錯誤的memberVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/member/addMember.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/
			MemberService memberSvc = new MemberService();
			memberVO = memberSvc.addMember(null, null, memberName, memberPhone, null, null, null, memberPicture, null, null, null, null);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/member/listAllMember.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);
		}
		
		if ("delete".equals(action)) { // 來自listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
	
				/***************************1.接收請求參數***************************************/
				Integer memberID = Integer.valueOf(req.getParameter("memberID"));
				
				/***************************2.開始刪除資料***************************************/
				MemberService memberSvc = new MemberService();
				memberSvc.deleteMember(memberID);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				String url = "/member/listAllMember.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);
		}
	}
}
