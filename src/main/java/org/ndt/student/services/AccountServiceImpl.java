package org.ndt.student.services;

import org.ndt.student.db.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AccountServiceImpl  implements AccountService
{
	@Autowired
	private AccountDao accountDao;
	
	
	public AccountDao getAccountDao() {
		return accountDao;
	}


	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}


	@Transactional
	public void uploadAccountInfo(MultipartFile file) 
	{
		accountDao.uploadAccountInfo(file);
	}

}
