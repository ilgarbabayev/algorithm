package com.company.FAANG.interview.unittest;

import java.math.BigDecimal;

public interface Account {

  BigDecimal currentBalance();

  void deposit(BigDecimal amount);

  void withdraw(BigDecimal amount);
}
