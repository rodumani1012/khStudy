package com.toy.project.controller;

import java.io.IOException;


import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.toy.home.dto.user_info_dto;
import com.toy.project.biz.project_biz;
import com.toy.project.biz.project_bizimpl;
import com.toy.project.dto.prj_info_dto;
import com.toy.project.dto.prj_issue_dto;
import com.toy.project.email.send_email_link;

@WebServlet("/prj_controller")
public class project_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public project_controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String command = request.getParameter("command");

		project_biz biz = new project_bizimpl();

		if (command.equals("project_new")) {
			
			String prj_name = request.getParameter("prj_name");
			String prj_invite_nick = request.getParameter("prj_invite_nick").trim();
			int user_num = Integer.parseInt(request.getParameter("user_num"));
			String prj_loc = request.getParameter("prj_loc");
			
			System.out.println(prj_name+" "+prj_invite_nick+" "+user_num);

			if(prj_invite_nick == null || prj_invite_nick == "") {
				int res = biz.prj_new_empty(prj_name, user_num, prj_loc);
				if (res > 0) {
					this.jsResponse("프로젝트 생성 성공",
							"project.do?command=project_list&user_num=" + request.getParameter("user_num"), response);
				} else {
					this.jsResponse("프로젝트 생성 실패",
							"project.do?command=project_list&user_num=" + request.getParameter("user_num"), response);
				}
			}else {
				int res = biz.prj_new(prj_name, prj_invite_nick, user_num, prj_loc);
				if (res > 0) {
					this.jsResponse("프로젝트 생성 성공",
							"project.do?command=project_list&user_num=" + request.getParameter("user_num"), response);
					if(prj_invite_nick == null || prj_invite_nick == "") {
						System.out.println();
					}else {
						String user_nick = biz.bring_nick(user_num).getUser_nickname();
						String email = biz.bring_email(prj_invite_nick).getUser_email();
						int prjno = biz.bring_prj(prj_name, user_num).getPrj_num();
						int inviteno = biz.bring_num(prj_invite_nick).getUser_num();
						
						System.out.println("프로젝트번호:"+prjno);
						send_email_link.sendPassward(prj_name, prjno, prj_invite_nick, email, user_nick, user_num);
					}
				} else {
					this.jsResponse("프로젝트 생성 실패",
							"project.do?command=project_list&user_num=" + request.getParameter("user_num"), response);
				}
			}

		} else if (command.equals("project_list")) {

			List<prj_info_dto> list = biz.prj_list(Integer.parseInt(request.getParameter("user_num")));
			request.setAttribute("project_list", list);
			this.dispatch(request, response, "/project/project_list.jsp");

		} else if (command.equals("project_board")) {

			List<prj_info_dto> board_list = biz.prj_board(Integer.parseInt(request.getParameter("prj_num")));
			request.getSession().setMaxInactiveInterval(-1);
	        request.getSession().setAttribute("prj_num_session", request.getParameter("prj_num"));
			request.setAttribute("project_board", board_list);
			List<prj_issue_dto> issue_list = biz.prj_issue_list(Integer.parseInt(request.getParameter("prj_num")));
			request.setAttribute("issue_list", issue_list);
			
			this.dispatch(request, response, "/project/dashboard/project_dash_board.jsp");

		
		} else if (command.equals("issue_new")) {
			
			Map<String, String> map = new HashMap<String, String>();
			map.put("prj_num", request.getParameter("prj_num"));
			map.put("board_num", request.getParameter("board_num"));
			int res = biz.issue_new(map);
			
//			if(res>0) {
//				out.println("issue_datail.jsp");
//			}
			//response.sendRedirect("project/dashboard/issue_insert.jsp?board_num=" + board_num + "&prj_num=" + prj_num);

		} else if (command.equals("issue_insert")) {
			
			user_info_dto user_info_dto = new user_info_dto();
			user_info_dto = (user_info_dto)request.getSession().getAttribute("user_info_dto");
						
			String obj = request.getParameter("obj");
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(obj);
			
			String issue_priority = element.getAsJsonObject().get("issue_priority").getAsString(); 
			//String user_nickname = element.getAsJsonObject().get("user_nickname").getAsString(); 
			String issue_title = element.getAsJsonObject().get("issue_title").getAsString(); 
			String issue_content = element.getAsJsonObject().get("issue_content").getAsString(); 
			int issue_require = element.getAsJsonObject().get("issue_require").getAsInt(); 
			String issue_charge = element.getAsJsonObject().get("issue_charge").getAsString(); 
			String issue_deadline = element.getAsJsonObject().get("issue_deadline").getAsString(); 
			
			int prj_num = element.getAsJsonObject().get("prj_num").getAsInt();
			int board_num = element.getAsJsonObject().get("board_num").getAsInt();
			
			prj_issue_dto dto = new prj_issue_dto(0, prj_num, board_num,  issue_title, issue_content, issue_require, issue_charge, issue_priority,"", 0,"", "", "N");
			//user_nickname은 파라미터 따로
			int res = biz.prj_issue_insert(dto);
			
//			if (res > 0) {
//				out.println();
//			}
			
		}else if(command.equals("issue_detail")) {
			int issue_num = Integer.parseInt(request.getParameter("issue_num"));
			
			List<prj_info_dto> list = biz.prj_board(Integer.parseInt(request.getParameter("prj_num")));
			request.getSession().setMaxInactiveInterval(-1);
			request.getSession().setAttribute("prj_num_session", request.getParameter("prj_num"));
			request.setAttribute("project_board", list);
			this.dispatch(request, response, "/project/dashboard/project_dash_board.jsp");

		} else if(command.equals("project_detail")) {
			List<prj_info_dto> list = biz.prj_list(Integer.parseInt(request.getParameter("user_num")));
			request.setAttribute("project_list", list);
			this.dispatch(request, response, "/project/project_list.jsp");
		
		} else if(command.equals("prj_name_chk")) {
			String prj_name = request.getParameter("prj_name");
			int user_num = Integer.parseInt(request.getParameter("user_num"));
			if(biz.bring_prj(prj_name, user_num) != null) {
				System.out.println("중복된 프로젝트명");
				response.getWriter().write("");
			}else {
				System.out.println("사용가능한 프로젝트명");
				response.getWriter().write(prj_name);
			}
		
		} else if(command.equals("insert_user")) {
			int prj_num = Integer.parseInt(request.getParameter("prj_num"));
			int user_num = Integer.parseInt(request.getParameter("user_num"));
			System.out.println(prj_num +" "+user_num);
			if(biz.insert_user(prj_num, user_num)>0) {
				response.sendRedirect("home.jsp");				
			}else {
				System.out.println("사용자 추가 실패");
			}
			
		} else if (command.equals("board_new")) {

			Map<String, String> map = new HashMap<String, String>();
			map.put("title", request.getParameter("title"));
			map.put("prj_num", request.getParameter("prj_num"));
			
			biz.board_new(map);

		} else if (command.equals("board_move")) {
			
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("prj_num", Integer.parseInt((String) request.getSession().getAttribute("prj_num_session")));
			map.put("after_board", Integer.parseInt(request.getParameter("after_board")) + 1);
			map.put("before_board", Integer.parseInt(request.getParameter("before_board")) + 1);
			map.put("before_num", Integer.parseInt(request.getParameter("before_num")));
			
			biz.board_move(map);
			
		} else if(command.equals("nick_chk")) {
			String nickname = request.getParameter("nickname");
			if(biz.nick_check(nickname)==null) {
				System.out.println("존재하지 않는 닉네임");
			}else {
				System.out.println("닉네임 확인 완료");
				response.getWriter().write(nickname);
			}
		}
		

	}

	public void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {

		String res = "<script type=\"text/javascript\">\r\n" + "		alert('" + msg + "');\r\n"
				+ "		location.href = '" + url + "'\r\n</script>";

		PrintWriter out = response.getWriter();
		out.println(res);

	}

	public void dispatch(HttpServletRequest request, HttpServletResponse response, String url)
			throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(url);
		dispatch.forward(request, response);
	}

}
