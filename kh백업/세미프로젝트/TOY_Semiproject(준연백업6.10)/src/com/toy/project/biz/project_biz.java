package com.toy.project.biz;

import java.util.List;

import com.toy.project.dto.prj_info_dto;

public interface project_biz {
	
	public int prj_new(String prj_name, String prj_invite1, String prj_invite2, int user_num);
	
	public List<prj_info_dto> prj_list(int user_num);
	
	public List<prj_info_dto> prj_board(int prj_num);

}
