package org.rooman.student.services;

import org.rooman.student.db.AccountDao;
import org.rooman.student.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService
{
	@Autowired
	private AccountDao accountDao;

	@Override
	public boolean updateAccountInfo(Account account)
	{
		return accountDao.updateAccountInfo(account);
	} 
}
