package com.dmytrobr.quoteservice.model;

import java.util.Objects;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;




@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaResteasyServerCodegen", date = "2016-12-11T18:36:41.285-05:00")
public class QuoteResponse   {
  
  private String price = null;
  private String total = null;
  private String currency = null;

  /**
   * The per-unit cost of the base currency
   **/
  
  @JsonProperty("price")
  public String getPrice() {
    return price;
  }
  public void setPrice(String price) {
    this.price = price;
  }

  /**
   * Total quantity of quote currency
   **/
  
  @JsonProperty("total")
  public String getTotal() {
    return total;
  }
  public void setTotal(String total) {
    this.total = total;
  }

  /**
   * The quote currency
   **/
  
  @JsonProperty("currency")
  public String getCurrency() {
    return currency;
  }
  public void setCurrency(String currency) {
    this.currency = currency;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QuoteResponse quoteResponse = (QuoteResponse) o;
    return Objects.equals(price, quoteResponse.price) &&
        Objects.equals(total, quoteResponse.total) &&
        Objects.equals(currency, quoteResponse.currency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(price, total, currency);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QuoteResponse {\n");
    
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
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

