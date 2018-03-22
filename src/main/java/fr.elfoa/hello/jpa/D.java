package fr.elfoa.hello.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

/**
 * Testing Transiant
 */

@Entity
public class D {
  @Id
  @GeneratedValue
  private Integer id;

  private String d_1;

  private Integer d_2;

  private Integer d_3;

  @ManyToOne
  private C_D c_d;

  @Transient
  private Integer d_4;

  public D() {

  }

  public Integer getId() {
    return id;
  }

  public String getD_1() {
    return d_1;
  }

  public void setD_1(String d_1) {
    this.d_1 = d_1;
  }

  public Integer getD_2() {
    return d_2;
  }

  public void setD_2(Integer d_2) {
    this.d_2 = d_2;
  }

  public Integer getD_3() {
    return d_3;
  }

  public void setD_3(Integer d_3) {
    this.d_3 = d_3;
  }

  public Integer getD_4() {
    return d_4;
  }

  public void setD_4(Integer d_4) {
    this.d_4 = d_4;
  }

  public C_D getC_d() {
    return c_d;
  }

  public void setC_d(C_D c_d) {
    this.c_d = c_d;
  }
}
