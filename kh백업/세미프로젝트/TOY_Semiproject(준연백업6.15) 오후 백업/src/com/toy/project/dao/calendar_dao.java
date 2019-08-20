package com.toy.project.dao;

import java.util.List;

import com.toy.project.dto.calendar_dto;

public interface calendar_dao {

	public int insert(calendar_dto dto);
	public List<calendar_dto> selectList(String board_num, String yyyyMMdd);
}
