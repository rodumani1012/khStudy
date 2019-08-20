package com.toy.project.biz;

import java.util.List;
import java.util.Map;

import com.toy.home.dto.user_info_dto;
import com.toy.project.dto.prj_info_dto;
import com.toy.project.dto.prj_issue_dto;

public interface project_biz {

	public int prj_new(String prj_name, int user_num, String prj_loc);

	public List<prj_info_dto> prj_list(int user_num);

	public List<prj_info_dto> prj_board(int prj_num);

	public user_info_dto nick_check(String nickname);

	public user_info_dto bring_email(String nickname);

	public user_info_dto bring_nick(int user_num);

	public user_info_dto bring_num(String nickname);

	public prj_info_dto bring_prj(String prj_name, int user_num);

	public int insert_user(int prj_num, int invite_num);

	public int board_new(Map<String, String> map);

	public int board_move(Map<String, Integer> map);

	public int issue_new(Map<String, String> map);

	public List<prj_issue_dto> prj_issue_list(int prj_num);
	
	public Map<String, String> issue_one(int issue_num);
	
	public int issue_update(Map<String, String> map);
	
	public int issue_del(int issue_num);

}
