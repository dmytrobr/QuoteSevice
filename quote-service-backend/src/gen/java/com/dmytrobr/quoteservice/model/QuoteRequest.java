package com.dmytrobr.quoteservice.model;

import java.util.Objects;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;




@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaResteasyServerCodegen", date = "2016-12-10T15:01:10.616-05:00")
public class QuoteRequest   {
  

  /**
   * Either buy or sell
   */
  public enum ActionEnum {
    BUY("buy"),

        SELL("sell");
    private String value;

    ActionEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }
  }

  private ActionEnum action = null;
  private String baseCurrency = null;
  private String quoteCurrency = null;
  private String amount = null;

  /**
   * Either buy or sell
   **/
  
  @JsonProperty("action")
  public ActionEnum getAction() {
    return action;
  }
  public void setAction(ActionEnum action) {
    this.action = action;
  }

  /**
   * The currency to be bought or sold
   **/
  
  @JsonProperty("base_currency")
  public String getBaseCurrency() {
    return baseCurrency;
  }
  public void setBaseCurrency(String baseCurrency) {
    this.baseCurrency = baseCurrency;
  }

  /**
   * The currency to quote the price in
   **/
  
  @JsonProperty("quote_currency")
  public String getQuoteCurrency() {
    return quoteCurrency;
  }
  public void setQuoteCurrency(String quoteCurrency) {
    this.quoteCurrency = quoteCurrency;
  }

  /**
   * The amount of the base currency to be traded
   **/
  
  @JsonProperty("amount")
  public String getAmount() {
    return amount;
  }
  public void setAmount(String amount) {
    this.amount = amount;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QuoteRequest quoteRequest = (QuoteRequest) o;
    return Objects.equals(action, quoteRequest.action) &&
        Objects.equals(baseCurrency, quoteRequest.baseCurrency) &&
        Objects.equals(quoteCurrency, quoteRequest.quoteCurrency) &&
        Objects.equals(amount, quoteRequest.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(action, baseCurrency, quoteCurrency, amount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QuoteRequest {\n");
    
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
    sb.append("    baseCurrency: ").append(toIndentedString(baseCurrency)).append("\n");
    sb.append("    quoteCurrency: ").append(toIndentedString(quoteCurrency)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

