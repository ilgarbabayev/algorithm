package com.company.FAANG.interview.unittest;

import java.math.BigDecimal;

public class CheckingAccount implements Account{

  private BigDecimal balance = BigDecimal.valueOf(0);

  @Override
  public BigDecimal currentBalance() {
    return balance;
  }

  @Override
  public void deposit(BigDecimal amount) {
    if (!isNegative(amount)) {
      balance = balance.add(amount);
    } else {
      throw new RuntimeException("Deposit amount can not be negative");
    }
  }

  @Override
  public void withdraw(BigDecimal amount) {
    if (isNegative(amount)) {
      throw new RuntimeException("Withdraw amount can not be negative");
    } else if (balance.compareTo(amount) <= -1) {
      throw new RuntimeException("Withdraw amount can not be greater than balance");
    } else {
      balance = balance.subtract(amount);
    }
  }

  private boolean isNegative(BigDecimal amount) {
    return amount.compareTo(BigDecimal.valueOf(0)) <= -1;
  }
}
