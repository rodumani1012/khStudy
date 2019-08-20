package com.toy.project.dao;

import java.util.List;
import java.util.Map;

import com.toy.project.dto.prj_info_dto;

public interface project_dao {
	
	public int prj_new(String prj_name, int user_num);
	
	public List<prj_info_dto> prj_list(int user_num);
	
	public List<prj_info_dto> prj_board(int prj_num);
	
	public int board_new(Map<String, String> map);
	
}
