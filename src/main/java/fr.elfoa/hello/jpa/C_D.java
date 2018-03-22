package fr.elfoa.hello.jpa;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class C_D {

  @Id
  @GeneratedValue
  private Integer id;

  @OneToMany(mappedBy = "c_d")
  private List<C> Cs;

  @OneToMany(mappedBy = "c_d")
  private List<D> Ds;

  public C_D() {
  }

  public List<C> getCs() {
    return Cs;
  }

  public void setCs(List<C> cs) {
    Cs = cs;
  }

  public List<D> getDs() {
    return Ds;
  }

  public void setDs(List<D> ds) {
    Ds = ds;
  }
}
