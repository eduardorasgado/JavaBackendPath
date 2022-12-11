package com.eduardorasgado.app;

import com.eduardorasgado.app.exceptions.NotEnoughMoneyException;
import com.eduardorasgado.app.models.Account;
import com.eduardorasgado.app.models.Bank;
import com.eduardorasgado.app.repositories.IAccountRepository;
import com.eduardorasgado.app.repositories.IBankRepository;
import com.eduardorasgado.app.services.AccountService;
import com.eduardorasgado.app.services.IAccountService;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SpringbootMockitoTestApplicationTests {

//	@Mock
	@MockBean
	private IAccountRepository accountRepository;

//	@Mock
	@MockBean
	private IBankRepository bankRepository;

	// whithout mock annotation
	//private IAccountService accountService;
	// with mock annotation
	//@InjectMocks
	//private AccountService accountService;
	// to be able to auto-wire this service, we need to annotate service class as @Service
	// also in this case, spring does autowire your AccountService implementation automatically so we can
	// use the abstraction/interface instead
	@Autowired
	private IAccountService accountService;

	@BeforeEach
	void setUp() {
		/*accountRepository = mock(IAccountRepository.class);
		bankRepository = mock(IBankRepository.class);

		accountService = new AccountService(accountRepository, bankRepository);*/
	}

	@DisplayName("Account Balance Testing")
	@Order(1)
	@Test
	void testAccountBalance() {
		when(accountRepository.findById(1L)).thenReturn(AccountTestData.getNewAccount001());
		when(accountRepository.findById(2L)).thenReturn(AccountTestData.getNewAccount002());
		when(bankRepository.findById(1L)).thenReturn(AccountTestData.getNewBank());

		BigDecimal originBalance = accountService.getBalanceById(1L);
		BigDecimal destinationBalance = accountService.getBalanceById(2L);

		assertEquals("1000", originBalance.toPlainString());
		assertEquals("2000", destinationBalance.toPlainString());
	}

	@DisplayName("Account Transfer Testing")
	@Order(2)
	@Test
	void testAccountTransfer() {
		when(accountRepository.findById(1L)).thenReturn(AccountTestData.getNewAccount001());
		when(accountRepository.findById(2L)).thenReturn(AccountTestData.getNewAccount002());
		when(bankRepository.findById(1L)).thenReturn(AccountTestData.getNewBank());

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

	@DisplayName("Account Transfer without enough money testing")
	@Order(3)
	@Test
	void testAccountTransferNotEnoughMoney() {
		when(accountRepository.findById(1L)).thenReturn(AccountTestData.getNewAccount001());
		when(accountRepository.findById(2L)).thenReturn(AccountTestData.getNewAccount002());
		when(bankRepository.findById(1L)).thenReturn(AccountTestData.getNewBank());

		BigDecimal originBalance = accountService.getBalanceById(1L);
		BigDecimal destinationBalance = accountService.getBalanceById(2L);

		assertEquals("1000", originBalance.toPlainString());
		assertEquals("2000", destinationBalance.toPlainString());

		Exception ex = assertThrows(NotEnoughMoneyException.class,
				() -> accountService.transfer(1L, 2L, 1L, new BigDecimal("1100")),
				() -> "NotEnoughMoneyException should be thrown after trying to get more money out of balance");

		assertEquals(ex.getMessage(), "Not enough money to withdraw");

		originBalance = accountService.getBalanceById(1L);
		destinationBalance = accountService.getBalanceById(2L);

		assertEquals("1000", originBalance.toPlainString());
		assertEquals("2000", destinationBalance.toPlainString());

		int totalTransfer = accountService.getTotalTransfersByBankId(1L);
		assertEquals(0, totalTransfer, "Total transfer count should be 0");

		verify(bankRepository, times(2)).findById(1L);
		verify(bankRepository, never()).update(any(Bank.class));

		verify(accountRepository, times(3)).findById(1L);
		verify(accountRepository, times(3)).findById(2L);
		verify(accountRepository, never()).update(any(Account.class));

		verify(accountRepository, times(6)).findById(anyLong());
		verify(accountRepository, never()).findAll();
	}

	@Test
	void testAssertSame() {
		when(accountRepository.findById(1L)).thenReturn(AccountTestData.getNewAccount001());

		Account account1 = accountService.findById(1L);
		Account  account2 = accountService.findById(1L);

		// both does same thing
		assertSame(account1, account2);
		assertTrue(account1 == account2);
		assertEquals("Adam Smith", account1.getName());
		assertEquals("Adam Smith", account2.getName());

		verify(accountRepository, times(2)).findById(1L);
	}
}
