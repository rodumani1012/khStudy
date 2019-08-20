package com.toy.project.biz;

import java.util.List;

import com.toy.project.dao.calendar_dao;
import com.toy.project.dao.calendar_daoimpl;
import com.toy.project.dto.calendar_dto;

public class calendar_bizimpl implements calendar_biz {

	calendar_dao dao = new calendar_daoimpl();
	
	@Override
	public int insert(calendar_dto dto) {
		return dao.insert(dto);
	}

	@Override
	public List<calendar_dto> selectList(String prj_num) {
		return dao.selectList(prj_num);
	}

}
