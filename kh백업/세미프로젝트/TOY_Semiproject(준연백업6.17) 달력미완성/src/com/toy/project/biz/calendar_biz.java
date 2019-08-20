package com.toy.project.biz;

import java.util.List;

import com.toy.project.dto.calendar_dto;

public interface calendar_biz {

	public int insert(calendar_dto dto);
	public List<calendar_dto> selectList(String board_num, String yyyyMMdd);
}
