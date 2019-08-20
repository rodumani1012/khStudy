package com.toy.project.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.toy.project.biz.project_biz;
import com.toy.project.biz.project_bizimpl;
import com.toy.project.dto.prj_info_dto;
import com.toy.project.dto.prj_issue_dto;
import com.toy.project.email.send_email_link;
import com.toy.project.email.wannabe_invited_prj;

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
			String prj_invite_nick01 = request.getParameter("prj_invite_nick01").trim();
			String prj_invite_nick02 = request.getParameter("prj_invite_nick02").trim();
			String prj_invite_nick03 = request.getParameter("prj_invite_nick03").trim();
			String prj_invite_nick04 = request.getParameter("prj_invite_nick04").trim();
			String prj_invite_nick05 = request.getParameter("prj_invite_nick05").trim();
			int user_num = Integer.parseInt(request.getParameter("user_num"));
			String prj_loc = request.getParameter("prj_loc");
			String user_nickname = request.getParameter("user_nickname");
			List<String> list = new ArrayList<String>();
			list.add(prj_invite_nick01);
			list.add(prj_invite_nick02);
			list.add(prj_invite_nick03);
			list.add(prj_invite_nick04);
			list.add(prj_invite_nick05);

			for (int i = 0; i < 5; i++) {
				list.remove(null);
				list.remove("");
			}

			int res = biz.prj_new(prj_name, user_num, prj_loc, user_nickname);
			if (res > 0) {
				this.jsResponse("프로젝트 생성 성공",
						"project.do?command=project_list&user_num=" + request.getParameter("user_num"), response);

				Iterator<String> itr = list.iterator();
				String user_nick = biz.bring_nick(user_num).getUser_nickname();
				int prjno = biz.bring_prj(prj_name, user_num).getPrj_num();
				while (itr.hasNext()) {
					String invite_nick = itr.next();
					System.out.println("초대할 닉네임 : " + invite_nick);
					String email = biz.bring_email(invite_nick).getUser_email();
					System.out.println("초대할 분의 이메일 : " + email);
					send_email_link.sendPassward(prj_name, prjno, invite_nick, email, user_nick, user_num);
					System.out.println(email);
				}
			} else {
				this.jsResponse("프로젝트 생성 실패",
						"project.do?command=project_list&user_num=" + request.getParameter("user_num"), response);
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
			map.put("issue_title", request.getParameter("issue_title"));
			biz.issue_new(map);

		} else if (command.equals("issue_detail")) {

			int issue_num = Integer.parseInt(request.getParameter("issue_num"));
			Map<String, String> map = biz.issue_one(issue_num);

			Gson gson = new Gson();
			String json = gson.toJson(map);
			PrintWriter out = response.getWriter();
			out.println(json);

		} else if (command.equals("project_detail")) {
			List<prj_info_dto> list = biz.prj_list(Integer.parseInt(request.getParameter("user_num")));
			request.setAttribute("project_list", list);
			this.dispatch(request, response, "/project/project_list.jsp");

		} else if (command.equals("prj_name_chk")) {
			String prj_name = request.getParameter("prj_name");
			int user_num = Integer.parseInt(request.getParameter("user_num"));
			if (biz.bring_prj(prj_name, user_num) != null) {
				System.out.println("중복된 프로젝트명");
				response.getWriter().write("");
			} else {
				System.out.println("사용가능한 프로젝트명");
				response.getWriter().write(prj_name);
			}

		} else if(command.equals("insert_user")) {
	         int prj_num = Integer.parseInt(request.getParameter("prj_num"));
	         int user_num = Integer.parseInt(request.getParameter("user_num"));
	         System.out.println(prj_num +" "+user_num);
	         if(biz.pick_user(prj_num, user_num) == null) {
		         if(biz.insert_user(prj_num, user_num)>0) {
		            System.out.println(user_num+"번 사용자 추가 완료");
		            response.sendRedirect("home.jsp");            
		         }else {
		            System.out.println("사용자 추가 실패");
		         }
	         }else {
	        	 System.out.println("이미 추가되어있음");
	        	 jsResponse("이미 참여된 프로젝트 입니다.", "home.jsp", response);
	         }
	         
	      } else if (command.equals("board_new")) {
		} else if(command.equals("project_show")){
			int prj_num = Integer.parseInt(request.getParameter("prj_num"));
			prj_info_dto dto = biz.prj_selectOne(prj_num);
			request.setAttribute("prj_info_dto", dto);
			
			dispatch(request, response, "/project/project_show.jsp");
			
		} else if(command.equals("project_updateform")){
			int prj_num = Integer.parseInt(request.getParameter("prj_num"));
			prj_info_dto dto = biz.prj_selectOne(prj_num);
			
			request.setAttribute("prj_info_dto", dto);
			dispatch(request, response, "project/project_update.jsp");
		
		} else if(command.equals("project_update")){
			int prj_num = Integer.parseInt(request.getParameter("prj_num"));
			String prj_name = request.getParameter("prj_name");
			String prj_loc = request.getParameter("prj_loc");
			String user_nickname = request.getParameter("user_nickname");
			
			prj_info_dto dto = new prj_info_dto();
			
			dto.setPrj_num(prj_num);
			dto.setPrj_name(prj_name);
			dto.setPrj_loc(prj_loc);
			dto.setUser_nickname(user_nickname);
			
			int res = biz.prj_update(dto);
			
			if(res>0) {
				jsResponse("프로젝트 수정 성공", "project.do?command=project_show&prj_num=" + prj_num, response);
			}else {
				jsResponse("프로젝트 수정 실패", "project.do?command=project_update&prj_num=" + prj_num, response);
			}
			
		} else if(command.equals("project_delete")){
			int prj_num = Integer.parseInt(request.getParameter("prj_num"));
			
			int res = biz.prj_delete(prj_num);
			if(res>0) {
				jsResponse("프로젝트 삭제 성공", "project/project_list.jsp" , response);
			}else {
				jsResponse("프로젝트 삭제 실패", "project.do?command=project_show&prj_num=" + prj_num, response);
			}
			
		} else if(command.equals("insert_user")) {
			int prj_num = Integer.parseInt(request.getParameter("prj_num"));
			int user_num = Integer.parseInt(request.getParameter("user_num"));
			System.out.println(prj_num +" "+user_num);
			if(biz.insert_user(prj_num, user_num)>0) {
				System.out.println(user_num+"번 사용자 추가 완료");
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

		} else if (command.equals("nick_chk")) {
			String nickname = request.getParameter("nickname");
			if (biz.nick_check(nickname) == null) {
				System.out.println("존재하지 않는 닉네임");
			} else {
				System.out.println("닉네임 확인 완료");
				response.getWriter().write(nickname);
			}
		} else if (command.equals("issue_update")) {

			String json = request.getParameter("issue_update");

			Map<String, String> map = new HashMap<String, String>();

			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(json);

			String issue_num = element.getAsJsonObject().get("issue_num").getAsString();
			String column = element.getAsJsonObject().get("column").getAsString();
			String content = element.getAsJsonObject().get("content").getAsString();

			if (column.equals("deadline")) {
				String startline = element.getAsJsonObject().get("startline").getAsString();
				map.put("startline", startline);
			}
			
			map.put("issue_num", issue_num);
			map.put("column", column);
			map.put("content", content);

			biz.issue_update(map);

		} else if (command.equals("issue_del")) {

			int issue_num = Integer.parseInt(request.getParameter("issue_num"));

			biz.issue_del(issue_num);

		} else if (command.equals("room_meeting")) {

			this.dispatch(request, response, "/project/meeting/meeting_room.jsp");

		} else if(command.equals("bring_user")) {
		
			List<String> list = biz.bring_user(Integer.parseInt(request.getParameter("prj_num")));
			
			Gson gson = new Gson();
			String json = gson.toJson(list);
			PrintWriter out = response.getWriter();
			out.println(json);
			
		}else if(command.equals("issue_move"))

	{

		String issue_num = request.getParameter("issue_num");
		String board_num = request.getParameter("board_num");

		Map<String, String> map = new HashMap<String, String>();
		map.put("issue_num", issue_num);
		map.put("board_num", board_num);

		biz.issue_move(map);

	}else if(command.equals("board_update"))
	{

		Map<String, String> map = new HashMap<String, String>();
		map.put("to_title", request.getParameter("to_title"));
		map.put("board_num", request.getParameter("board_num"));

		biz.board_update(map);

	}else if(command.equals("dash_insert_user"))
	{
		int prj_num = Integer.parseInt(request.getParameter("prj_num"));
		int user_num = Integer.parseInt(request.getParameter("user_num"));
		System.out.println("프로젝트 번호 : " + prj_num + " | 사용자 번호 : " + user_num);

		dispatch(request, response, "project/add_new_user.jsp");
	}else if(command.equals("new_add_user"))
	{
		String prj_invite_nick01 = request.getParameter("prj_invite_nick01").trim();
		String prj_invite_nick02 = request.getParameter("prj_invite_nick02").trim();
		String prj_invite_nick03 = request.getParameter("prj_invite_nick03").trim();
		String prj_invite_nick04 = request.getParameter("prj_invite_nick04").trim();
		String prj_invite_nick05 = request.getParameter("prj_invite_nick05").trim();

		List<String> new_add = new ArrayList<String>();
		new_add.add(prj_invite_nick01);
		new_add.add(prj_invite_nick02);
		new_add.add(prj_invite_nick03);
		new_add.add(prj_invite_nick04);
		new_add.add(prj_invite_nick05);

		for (int i = 0; i < 5; i++) {
			new_add.remove(null);
			new_add.remove("");
		}

		int prj_num = Integer.parseInt(request.getParameter("prj_num"));
		System.out.println("프로젝트번호 : " + prj_num);
		int user_num = Integer.parseInt(request.getParameter("user_num"));
		System.out.println("본인 회원 번호" + user_num);
		String prj_name = biz.bring_prj_name(prj_num, user_num).getPrj_name();
		String user_nick = biz.bring_nick(user_num).getUser_nickname();

		Iterator<String> iter = new_add.iterator();
		while (iter.hasNext()) {
			String invite_nick = iter.next();
			System.out.println("초대할 닉네임 : " + invite_nick);
			String email = biz.bring_email(invite_nick).getUser_email();
			System.out.println("초대할 분의 이메일 : " + email);
			send_email_link.sendPassward(prj_name, prj_num, invite_nick, email, user_nick, user_num);
			System.out.println(email);
		}

		jsResponse("초대메일을 보냈습니다.", "project.do?command=project_list&user_num=" + user_num, response);

	}else if(command.equals("pick"))
	{
		PrintWriter out = response.getWriter();
		int user_num = Integer.parseInt(request.getParameter("user_num"));
		int prj_num = Integer.parseInt(request.getParameter("prj_num"));
		if (biz.pick_user(prj_num, user_num) == null) {
			System.out.println("해당프로젝트에 참여하지 않음");
		} else {
			System.out.println("이미 참여");
			out.println(user_num);
		}
	}else if(command.equals("pick_email"))
	{
		int login_num = Integer.parseInt(request.getParameter("user_num")); // 로그인 유저
		int prj_num = Integer.parseInt(request.getParameter("prj_num")); // 프로젝트 번호

		String prj_user_nick = biz.pick_user_nick(prj_num).getUser_nickname(); // 프로젝트 작성자 닉네임
		String login_nick = biz.bring_nick(login_num).getUser_nickname(); // 로그인 유저의 닉네임
		int prj_user_num = biz.bring_num(prj_user_nick).getUser_num(); // 프로젝트 작성자 번호
		String prj_name = biz.bring_prj_name(prj_num, prj_user_num).getPrj_name(); // 프로젝트 이름
		String email = biz.bring_email(prj_user_nick).getUser_email(); // 프로젝트 작성자 이메일

		wannabe_invited_prj.want_invite(login_nick, prj_user_nick, prj_name, email, prj_num, login_num);
		jsResponse("이메일 전송 완료", "project.do?command=project_show&prj_num=" + prj_num, response);

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
