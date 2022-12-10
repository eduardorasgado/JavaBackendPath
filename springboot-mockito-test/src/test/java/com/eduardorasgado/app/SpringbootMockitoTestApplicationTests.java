package com.eduardorasgado.app;

import com.eduardorasgado.app.models.Account;
import com.eduardorasgado.app.models.Bank;
import com.eduardorasgado.app.repositories.IAccountRepository;
import com.eduardorasgado.app.repositories.IBankRepository;
import com.eduardorasgado.app.services.AccountService;
import com.eduardorasgado.app.services.IAccountService;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SpringbootMockitoTestApplicationTests {

	private IAccountRepository accountRepository;

	private IBankRepository bankRepository;

	private IAccountService accountService;

	@BeforeEach
	void setUp() {
		accountRepository = mock(IAccountRepository.class);
		bankRepository = mock(IBankRepository.class);

		accountService = new AccountService(accountRepository, bankRepository);
	}

	@DisplayName("Account Balance Testing")
	@Order(1)
	@Test
	void testAccountBalance() {
		when(accountRepository.findById(1L)).thenReturn(AccountTestData.ACCOUNT_001);
		when(accountRepository.findById(2L)).thenReturn(AccountTestData.ACCOUNT_002);
		when(bankRepository.findById(1L)).thenReturn(AccountTestData.NU_BANK);

		BigDecimal originBalance = accountService.getBalanceById(1L);
		BigDecimal destinationBalance = accountService.getBalanceById(2L);

		assertEquals("1000", originBalance.toPlainString());
		assertEquals("2000", destinationBalance.toPlainString());
	}

	@DisplayName("Account Transfer Testing")
	@Order(1)
	@Test
	void testAccountTransfer() {
		when(accountRepository.findById(1L)).thenReturn(AccountTestData.ACCOUNT_001);
		when(accountRepository.findById(2L)).thenReturn(AccountTestData.ACCOUNT_002);
		when(bankRepository.findById(1L)).thenReturn(AccountTestData.NU_BANK);

		BigDecimal originBalance = accountService.getBalanceById(1L);
		BigDecimal destinationBalance = accountService.getBalanceById(2L);

		assertEquals("1000", originBalance.toPlainString());
		assertEquals("2000", destinationBalance.toPlainString());

		accountService.transfer(1L, 2L, 1L, new BigDecimal("500"));

		originBalance = accountService.getBalanceById(1L);
		destinationBalance = accountService.getBalanceById(2L);

		assertEquals("500", originBalance.toPlainString());
		assertEquals("2500", destinationBalance.toPlainString());

		int totalTransfer = accountService.getTotalTransfersByBankId(1L);
		assertEquals(1, totalTransfer, "Total transfer count should be 1");

		verify(bankRepository, times(2)).findById(1L);
		verify(bankRepository).update(any(Bank.class));

		verify(accountRepository, times(3)).findById(1L);
		verify(accountRepository, times(3)).findById(2L);
		verify(accountRepository, times(2)).update(any(Account.class));
	}
}
