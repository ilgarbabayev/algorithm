package com.company;

import java.math.BigDecimal;
import java.util.List;

public class UBS {

}

class Item {
  private BigDecimal price;

  public BigDecimal getPrice() {
    return this.price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }
}

class ShoppingCart {
  private List<Item> items;


}
