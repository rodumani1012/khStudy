package com.toy.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toy.project.biz.calendar_biz;
import com.toy.project.biz.calendar_bizimpl;
import com.toy.project.dto.calendar_dto;

import net.sf.json.JSONObject;




@WebServlet("/calendar_controller")
public class calendar_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.println("<" + command + ">");
		
		calendar_biz biz = new calendar_bizimpl();
		PrintWriter out = response.getWriter();

		if(command.equals("calendar")) {
			Calendar cal = Calendar.getInstance();
			
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH) + 1; // 월은 0부터 시작
			
			// 년 월을 입력받는 경우 해당 입력 월로 설정
			String param_year = request.getParameter("year");
			String param_month = request.getParameter("month");
			
			if (param_year != null) {
				year = Integer.parseInt(param_year);
			}
			if (param_month != null) {
				month = Integer.parseInt(param_month);
			}
			
			if (month > 12) {
				month = 1;
				year++;
			}
			if (month < 1) {
				month = 12;
				year--;
			}
			
			// year년 month월 1일로 설정
			cal.set(year, month-1, 1);
			
			// 1일의 요일 찾아오기
			int day_of_week = cal.get(Calendar.DAY_OF_WEEK);
			
			// 해당 월의 마지막 일 찾아오기
			int last_day = cal.getActualMaximum(Calendar.DATE);

			// 해당 월의 마지막 요일 찾아오기
			cal.set(Calendar.DATE, last_day);
			int end_day_of_week = cal.get(Calendar.DAY_OF_WEEK);
			
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("year", year);
			map.put("month", month);
			map.put("day_of_week", day_of_week);
			map.put("last_day", last_day);
			map.put("end_day_of_week", end_day_of_week);
			request.getSession().setAttribute("calendar_map", map);
			
			String prj_num = request.getParameter("prj_num");
			List<calendar_dto> list = biz.selectList(prj_num);
			
			
			RequestDispatcher dispatch = request.getRequestDispatcher("project/roadmap/calendar.jsp");
			dispatch.forward(request, response);
			
		} else if(command.equals("new_calendar")) {
			Calendar cal = Calendar.getInstance();
			String button = request.getParameter("button");
			int year = Integer.parseInt(request.getParameter("year"));
			int month = Integer.parseInt(request.getParameter("month"));
			Map<String, Integer> map = new HashMap<String, Integer>();
			System.out.println("버튼 : " + button);
			
			cal.set(year, month-1, 1);
			int day_of_week = cal.get(Calendar.DAY_OF_WEEK);
			int last_day = cal.getActualMaximum(Calendar.DATE);
			cal.set(Calendar.DATE, last_day);
			int end_day_of_week = cal.get(Calendar.DAY_OF_WEEK); 
			int week_of_month = cal.get(Calendar.WEEK_OF_MONTH);


			switch (button) {
			case "year_minus":
				year -= 1;
				cal.set(year, month-1, 1);
				day_of_week = cal.get(Calendar.DAY_OF_WEEK);
				last_day = cal.getActualMaximum(Calendar.DATE);
				cal.set(Calendar.DATE, last_day);
				end_day_of_week = cal.get(Calendar.DAY_OF_WEEK);
				week_of_month = cal.get(Calendar.WEEK_OF_MONTH);
				map.put("year", year);
				map.put("month", month);
				map.put("day_of_week", day_of_week);
				map.put("last_day", last_day);
				map.put("end_day_of_week", end_day_of_week);
				map.put("week_of_month", week_of_month);
				request.getSession().setAttribute("calendar_map", map);
				dispatch("project/roadmap/calendar.jsp", request, response);
				break;
			case "month_minus":
				month -= 1;
				if(month < 1) {
					year -= 1;
					month = 12;
					cal.set(year, month-1, 1);
					day_of_week = cal.get(Calendar.DAY_OF_WEEK);
					last_day = cal.getActualMaximum(Calendar.DATE);
					cal.set(Calendar.DATE, last_day);
					end_day_of_week = cal.get(Calendar.DAY_OF_WEEK);
					week_of_month = cal.get(Calendar.WEEK_OF_MONTH);
					map.put("year", year);
					map.put("month", month);
					map.put("day_of_week", day_of_week);
					map.put("last_day", last_day);
					map.put("end_day_of_week", end_day_of_week);
					map.put("week_of_month", week_of_month);
					request.getSession().setAttribute("calendar_map", map);
					dispatch("project/roadmap/calendar.jsp", request, response);
					break;
				}
				cal.set(year, month-1, 1);
				day_of_week = cal.get(Calendar.DAY_OF_WEEK);
				last_day = cal.getActualMaximum(Calendar.DATE);
				cal.set(Calendar.DATE, last_day);
				end_day_of_week = cal.get(Calendar.DAY_OF_WEEK);
				week_of_month = cal.get(Calendar.WEEK_OF_MONTH);
				map.put("year", year);
				map.put("month", month);
				map.put("day_of_week", day_of_week);
				map.put("last_day", last_day);
				map.put("end_day_of_week", end_day_of_week);
				map.put("week_of_month", week_of_month);
				request.getSession().setAttribute("calendar_map", map);
				dispatch("project/roadmap/calendar.jsp", request, response);
				break;
			case "year_plus":
				year += 1;
				cal.set(year, month-1, 1);
				day_of_week = cal.get(Calendar.DAY_OF_WEEK);
				last_day = cal.getActualMaximum(Calendar.DATE);
				cal.set(Calendar.DATE, last_day);
				end_day_of_week = cal.get(Calendar.DAY_OF_WEEK);
				week_of_month = cal.get(Calendar.WEEK_OF_MONTH);
				map.put("year", year);
				map.put("month", month);
				map.put("day_of_week", day_of_week);
				map.put("last_day", last_day);
				map.put("end_day_of_week", end_day_of_week);
				map.put("week_of_month", week_of_month);
				request.getSession().setAttribute("calendar_map", map);
				dispatch("project/roadmap/calendar.jsp", request, response);
				break;
			case "month_plus":
				month += 1;
				if(month > 12) {
					year += 1;
					month = 1;
					cal.set(year, month-1, 1);
					day_of_week = cal.get(Calendar.DAY_OF_WEEK);
					last_day = cal.getActualMaximum(Calendar.DATE);
					cal.set(Calendar.DATE, last_day);
					end_day_of_week = cal.get(Calendar.DAY_OF_WEEK);
					week_of_month = cal.get(Calendar.WEEK_OF_MONTH);
					map.put("year", year);
					map.put("month", month);
					map.put("day_of_week", day_of_week);
					map.put("last_day", last_day);
					map.put("end_day_of_week", end_day_of_week);
					map.put("week_of_month", week_of_month);
					request.getSession().setAttribute("calendar_map", map);
					dispatch("project/roadmap/calendar.jsp", request, response);
					break;
				}
				cal.set(year, month-1, 1);
				day_of_week = cal.get(Calendar.DAY_OF_WEEK);
				last_day = cal.getActualMaximum(Calendar.DATE);
				cal.set(Calendar.DATE, last_day);
				end_day_of_week = cal.get(Calendar.DAY_OF_WEEK);
				week_of_month = cal.get(Calendar.WEEK_OF_MONTH);
				map.put("year", year);
				map.put("month", month);
				map.put("day_of_week", day_of_week);
				map.put("last_day", last_day);
				map.put("end_day_of_week", end_day_of_week);
				map.put("week_of_month", week_of_month);
				request.getSession().setAttribute("calendar_map", map);
				dispatch("project/roadmap/calendar.jsp", request, response);
				break;
			}
		} else if (command.equals("calendar_list")) {
//			int prj_num = Integer.parseInt(request.getParameter(""));
			
		} else if (command.equals("cal_issue_insert")) {
			
		}
	}

	public void dispatch(String url, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
