package com.toy.project.dao;

import java.util.ArrayList;
import java.util.List;

import com.toy.project.dto.calendar_dto;

public class calendar_daoimpl implements calendar_dao {

	@Override
	public int insert(calendar_dto dto) {
		
		return 0;
	}

	@Override
	public List<calendar_dto> selectList(String prj_num) {
		
		List<calendar_dto> list = new ArrayList<calendar_dto>();
		
		return list;
	}

}
