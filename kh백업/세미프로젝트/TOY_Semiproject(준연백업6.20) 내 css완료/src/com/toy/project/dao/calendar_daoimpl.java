package com.toy.project.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.toy.db.sql_map_config;
import com.toy.project.dto.calendar_dto;
import com.toy.project.dto.prj_board_dto;

public class calendar_daoimpl extends sql_map_config implements calendar_dao {

	String namespace = "calendar.mapper.";
	
	@Override
	public List<calendar_dto> selectList(String prj_num, String yyyyMM) {
		
		SqlSession session = null;
		
		session = getSqlSessionFactory().openSession();
		Map<String, String> map = new HashMap<String, String>();
		map.put("prj_num", prj_num);
		map.put("yyyyMM", yyyyMM);
		
		List<calendar_dto> list = session.selectList(namespace + "calendar_list", map);
		
		return list;
	}

	@Override
	public List<prj_board_dto> selectList(String prj_num) {
		
		SqlSession session = null;
		
		session = getSqlSessionFactory().openSession();
		Map<String, String> map = new HashMap<String, String>();
		map.put("prj_num", prj_num);
		
		List<prj_board_dto> list = session.selectList(namespace + "prj_board_list", map);
		
		return list;
	}

	@Override
	public prj_board_dto board_num(String category) {
		prj_board_dto dto = new prj_board_dto();
		
		SqlSession session = null;
		
		session = getSqlSessionFactory().openSession();
		Map<String, String> map = new HashMap<String, String>();
		map.put("category", category);
		
		dto = session.selectOne(namespace + "board_num", map);
		
		return dto;
	}

	@Override
	public int issue_insert(calendar_dto dto) {
		int res = 0;
		
		SqlSession session = null;
		
		session = getSqlSessionFactory().openSession(false);
		
		res = session.insert(namespace + "issue_insert", dto);
		
		if(res > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		return res;
	}

	@Override
	public List<calendar_dto> issue_list(String prj_num, String yyyyMMdd) {
		
		SqlSession session = null;
		
		session = getSqlSessionFactory().openSession();
		Map<String, String> map = new HashMap<String, String>();
		map.put("prj_num", prj_num);
		map.put("yyyyMMdd", yyyyMMdd);
		
		List<calendar_dto> list = session.selectList(namespace + "issue_list", map);
		
		return list;
	}

	@Override
	public calendar_dto board_select_one(String issue_num, String board_num) {
		calendar_dto dto = new calendar_dto();
		
		SqlSession session = null;
		
		session = getSqlSessionFactory().openSession();
		Map<String, String> map = new HashMap<String, String>();
		map.put("issue_num", issue_num);
		map.put("board_num", board_num);
		
		dto = session.selectOne(namespace + "board_select_one", map);
		
		return dto;
	}

	@Override
	public int issue_update(String issue_num, String origin_board_num, calendar_dto dto) {
		int res = 0;
		
		SqlSession session = null;
		
		session = getSqlSessionFactory().openSession(false);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("issue_num", issue_num);
		map.put("origin_board_num", origin_board_num);
		map.put("dto", dto);
		
		res = session.update(namespace + "issue_update", map);
		if(res > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		return res;
	}

	@Override
	public int issue_delete(calendar_dto dto) {
		int res = 0;
		
		SqlSession session = null;
		
		session = getSqlSessionFactory().openSession(false);
		
		res = session.delete(namespace + "issue_delete", dto);
		
		if(res > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		return res;
	}

}
