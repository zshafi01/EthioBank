package com.simplilearn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.domain.Account;
import com.simplilearn.domain.Customer;
import com.simplilearn.domain.Transfer;
import com.simplilearn.domain.User;
import com.simplilearn.repository.TransferRepository;

@Service
public class TransferServiceImpl implements TransferService {

	@Autowired
	private TransferRepository transferRepository;
	@Autowired
	private UserService userService;

	@Autowired
	private AccountService accountService;

	@Autowired
	private CustomerService customerService;

	@Override
	public List<Transfer> findAll() {
		return (List<Transfer>) transferRepository.findAll();
	}

	@Override
	public Transfer save(Transfer transfer, String userId) throws Exception {
		Optional<Customer> customerOptional = customerService.getById(Long.parseLong(userId));
		if (customerOptional.isPresent()) {
			Customer savedCustomer = customerOptional.get();
			if (savedCustomer != null) {
				List<Account> fromAccounts = this.accountService.getAccountByUserId(Long.parseLong(userId));
				List<Account> toAccounts = this.accountService
						.getAccountByUserId(Long.parseLong(transfer.getTransferTo()));

				Account fromAccount = fromAccounts.get(0);
				Account toAccount = toAccounts.get(0);
				if (fromAccount != null && toAccount != null) {
					this.accountService.withdrawl(fromAccount.getId(), transfer.getAmount());
					this.accountService.deposit(toAccount.getId(), transfer.getAmount());
					transfer.setCustomerid(savedCustomer.getId() + "");
					Transfer savedTransfer = transferRepository.save(transfer);
					return savedTransfer;
				}

			}

		}
		return null;
	}

	@Override
	public void updateTransfer(Transfer transfer, long id) {
		transferRepository.save(transfer);
	}

	@Override
	public void deleteTransfer(long id) {
		transferRepository.deleteById(id);
	}

	@Override
	public Optional<Transfer> getById(long id) {
		return transferRepository.findById(id);
	}

}
