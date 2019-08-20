package com.toy.project.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.toy.db.sql_map_config;
import com.toy.project.dto.prj_info_dto;

public class project_daoimpl extends sql_map_config implements project_dao {

	String namespace = "project.mapper.";

	@Override
	public int prj_new(String prj_name, int user_num) {

		int res = 1;

		SqlSession session = null;

		try {
			session = super.getSqlSessionFactory().openSession();

			Map<String, String> map = new HashMap<String, String>();
			map.put("prj_name", prj_name);

			res *= session.insert(namespace + "project_new", map);
			res *= session.insert(namespace + "project_new_in_user", user_num);
			res *= session.insert(namespace + "project_new_board1");
			res *= session.insert(namespace + "project_new_board2");
			res *= session.insert(namespace + "project_new_board3");

		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}

		return res;
	}

	@Override
	public List<prj_info_dto> prj_list(int user_num) {

		SqlSession session = null;

		session = super.getSqlSessionFactory().openSession();

		List<prj_info_dto> list = session.selectList(namespace + "project_list", user_num);

		return list;
	}

	@Override
	public List<prj_info_dto> prj_board(int prj_num) {
		
		SqlSession session = null;
		session = super.getSqlSessionFactory().openSession();
		
		List<prj_info_dto> list = session.selectList(namespace+"project_board",prj_num);
		
		return list;
	}

}
