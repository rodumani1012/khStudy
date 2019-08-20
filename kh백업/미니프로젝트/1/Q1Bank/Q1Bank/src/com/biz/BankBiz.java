package com.biz;

import java.util.List;

import com.dao.BankDao;
import com.dto.BankDto;

public class BankBiz {

	BankDao dao = new BankDao();

	public int AccountCreate(BankDto dto) {
		int res = 0;
		if (accountCheck(dto.getAccount()) == false) { // db�� ���°� ������
			res = dao.AccountCreate(dto); // ���� �����ϱ�.
		} else {
			res = 0;
		}
		return res;
	}

	public BankDto login(String account, String password) {
		return dao.login(account, password);
	}

	public BankDto myaccount(String account) {
		return dao.myaccount(account);
	}

	public BankDto BankBalance(String account) {// ���¹�ȣ�� bank���̺� balance�� ��������
		return dao.BankBalance(account);
	}

	public String NoPassbookDeposit(String account, BankDto dto, BankDto trade_listdto) {
		dto = BankBalance(account);
		int asis_balance = dto.getT_balance();
		int tobe_balance = asis_balance + trade_listdto.getInput();
		return dao.NoPassbookDeposit(account, tobe_balance, trade_listdto);
	}

	public boolean transferMoney(BankDto sender, String receiverAccount, int money, String message) {
		int[] resProcess = new int[4];
		String processRes = "";
		int cnt = 0;
		boolean successProcess = false;

		// (1-1) ���¹�ȣ ��ȿ���˻� true
		if (dao.accountCheck(receiverAccount)) {
			System.out.println(">>>>>>>>>> process 1: ��ȿ�� ����!");
			// (1-1-1) ���ΰ��¿� �������ƴ��� Ȯ��
			if (!(sender.getAccount().equals(receiverAccount))) {
				// (2-1) �ܾ���ȿ�� �˻� true
				if (dao.getBalance(sender.getAccount()) >= money) {
					System.out.println(">>>>>>>>>> process 2 : ��ȿ�� ���� �ܾ�!");
					// ���� ������ (3)(4) => 11
					processRes += dao.updateBalance(sender, sender.getAccount(), -money, "");
					System.out.println("3");
					// ������ �� (5)(6) => 11
					processRes += dao.updateBalance(sender, receiverAccount, money, message);
					System.out.println("4");
					// (2-2) �ܾ���ȿ�� �˻� false
				} else {
					successProcess = false;
					System.out.println(">>>>>>>>>> process 2 : error!");
					System.err.println("!!!!�ܾ��� �����մϴ�!!!!\n");
				}
			} else {
				System.err.println("���ΰ��·� �۱��Ͻ� �� �����ϴ�.");
			}
		} else {
			successProcess = false;
			System.out.println(">>>>>>>>>> process1 : error!");
			System.err.println("�ùٸ��� ���� ���¹�ȣ�Դϴ�!");
		}
		if (processRes.equals("22")) {
			successProcess = true;
		}

		return successProcess;
	}

	public String updateBalance(BankDto sender, String receiverAccount, int inputMoney, String message) {
		return dao.updateBalance(sender, receiverAccount, inputMoney, message);
	}

	public BankDto selectOne(String account) {
		return dao.selectOne(account);
	}

	public boolean accountCheck(String account) {
		return dao.accountCheck(account);
	}

	public int Deposit(String account, int input) {
		return dao.Deposit(account, input);
	}

	public int Withdraw(String account, int output) {
		return dao.Withdraw(account, output);
	}

	public int getBalance(String acc) {
		return dao.getBalance(acc);
	}

	// tradeList기간설정추가
	public List<BankDto> tradeListBTW(String account, int WMS, String com) {
		return dao.tradeListBTW(account, WMS, com);
	}

	// tradeListIn,Out삭제 traseList수정
	public List<BankDto> tradeList(String account, int AIO) {
		return dao.tradeList(account, AIO);
	}

	public int Memberupdate(String account, String name, String password) {
		return dao.Memberupdate(account, name, password);
	}

	public int Memberdelete(String account, String password) {
		return dao.Memberdelete(account, password);
	}
}
