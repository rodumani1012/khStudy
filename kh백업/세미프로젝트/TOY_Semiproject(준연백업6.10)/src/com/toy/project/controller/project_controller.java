package com.toy.project.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toy.project.biz.project_biz;
import com.toy.project.biz.project_bizimpl;
import com.toy.project.dto.prj_info_dto;

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

			int res = biz.prj_new(request.getParameter("prj_name"), request.getParameter("prj_invite1"),
					request.getParameter("prj_invite2"), Integer.parseInt(request.getParameter("user_num")));
			if (res > 0) {
				this.jsResponse("프로젝트 생성 성공",
						"project.do?command=project_list&user_num=" + request.getParameter("user_num"), response);
			} else {
				this.jsResponse("프로젝트 생성 실패",
						"project.do?command=project_list&user_num=" + request.getParameter("user_num"), response);
			}

		} else if (command.equals("project_list")) {

			List<prj_info_dto> list = biz.prj_list(Integer.parseInt(request.getParameter("user_num")));
			request.setAttribute("project_list", list);
			this.dispatch(request, response, "/project/project_list.jsp");

		} else if (command.equals("project_board")) {

			List<prj_info_dto> list = biz.prj_board(Integer.parseInt(request.getParameter("prj_num")));
			request.setAttribute("project_board", list);
			this.dispatch(request, response, "/project/dashboard/project_dash_board.jsp");

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
