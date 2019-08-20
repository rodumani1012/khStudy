package com.toy.project.biz;

import java.util.List;

import com.toy.project.dao.project_dao;
import com.toy.project.dao.project_daoimpl;
import com.toy.project.dto.prj_info_dto;

public class project_bizimpl implements project_biz {

	project_dao dao = new project_daoimpl();

	@Override
	public int prj_new(String prj_name, String prj_invite1, String prj_invite2, int user_num) {

		// invite 1, 2 이메일 전송 기능 이용해야 함

		return dao.prj_new(prj_name, user_num);
	}

	@Override
	public List<prj_info_dto> prj_list(int user_num) {

		return dao.prj_list(user_num);
	}

	@Override
	public List<prj_info_dto> prj_board(int prj_num) {
		return dao.prj_board(prj_num);
	}

}
