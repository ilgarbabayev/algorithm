//package com.company.FAANG.interview.unittest;
//
//import java.math.BigDecimal;
//
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class CheckingAccountTest {
//
//  @Test
//  void testCurrentBalance() {
//    Account account = new CheckingAccount();
//    BigDecimal toAdd = BigDecimal.valueOf(10.5);
//    account.deposit(toAdd);
//    BigDecimal balance = account.currentBalance();
//
//    assertEquals(toAdd, balance);
//  }
//
//  @Test
//  void testNegativeDeposit() {
//    Account account = new CheckingAccount();
//    BigDecimal toAdd = BigDecimal.valueOf(-10.5);
//
//    RuntimeException exception = assertThrows(RuntimeException.class, () -> account.deposit(toAdd));
//
//    String message = exception.getMessage();
//    String expectedMessage = "Deposit amount can not be negative";
//
//    assertEquals(expectedMessage, message);
//  }
//
//  @Test
//  void testPositiveDeposit() {
//    Account account = new CheckingAccount();
//    BigDecimal toAdd = BigDecimal.valueOf(10.5);
//
//    account.deposit(toAdd);
//
//    assertEquals(toAdd, account.currentBalance());
//  }
//
//  @Test
//  void testWithdrawNegativeAmount() {
//    Account account = new CheckingAccount();
//    BigDecimal toWithdraw = BigDecimal.valueOf(-10.5);
//
//    RuntimeException exception = assertThrows(RuntimeException.class, () -> account.withdraw(toWithdraw));
//
//    String message = exception.getMessage();
//    String expectedMessage = "Withdraw amount can not be negative";
//
//    assertEquals(expectedMessage, message);
//  }
//
//  @Test
//  void testWithdrawAmountGreaterThanBalance() {
//    Account account = new CheckingAccount();
//    BigDecimal toWithdraw = BigDecimal.valueOf(10.5);
//    BigDecimal toAdd = BigDecimal.valueOf(5);
//
//    account.deposit(toAdd);
//
//    RuntimeException exception = assertThrows(RuntimeException.class, () -> account.withdraw(toWithdraw));
//
//    String message = exception.getMessage();
//    String expectedMessage = "Withdraw amount can not be greater than balance";
//
//    assertEquals(expectedMessage, message);
//  }
//
//  @Test
//  void testPositiveWithdraw() {
//    Account account = new CheckingAccount();
//    BigDecimal toAdd = BigDecimal.valueOf(10.5);
//    BigDecimal toWithdraw = BigDecimal.valueOf(5.5);
//
//    account.deposit(toAdd);
//    account.withdraw(toWithdraw);
//    BigDecimal currentBalance = account.currentBalance();
//    BigDecimal expected = BigDecimal.valueOf(5.0);
//
//    assertEquals(expected, currentBalance);
//  }
//}