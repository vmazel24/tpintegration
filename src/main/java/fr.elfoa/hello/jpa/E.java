package fr.elfoa.hello.jpa;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class E {
  @Id
  @GeneratedValue
  private Integer id;

  @OneToMany(mappedBy = "e")
  private List<A> E_A;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public List<A> getE_A() {
    return E_A;
  }

  public void setE_A(List<A> e_A) {
    E_A = e_A;
  }
}
