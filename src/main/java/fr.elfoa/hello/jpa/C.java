package fr.elfoa.hello.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;
import javax.persistence.ManyToOne;

/**
 * @author Pierre Colomb
 */
@Entity
public class C {

    @Id
    @GeneratedValue
    private Integer id;

    private String c_1;

    private String c_2;

    @ManyToOne
    private C_D c_d;

    public C(){
    }

    public C(String c_1, String c_2) {
        this.c_1 = c_1;
        this.c_2 = c_2;
    }



    public Integer getId() {
        return id;
    }



    public void setId(Integer id) {
        this.id = id;
    }



    public String getC_1() {
        return c_1;
    }



    public void setC_1(String c_1) {
        this.c_1 = c_1;
    }



    public String getC_2() {
        return c_2;
    }



    public void setC_2(String c_2) {
        this.c_2 = c_2;
    }

    public C_D getC_d() {
        return c_d;
    }

    public void setC_d(C_D c_d) {
        this.c_d = c_d;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof C))
            return false;
        C c = (C) o;
        return Objects.equals(id, c.id) &&
               Objects.equals(c_1, c.c_1) &&
               Objects.equals(c_2, c.c_2);
    }



    @Override
    public int hashCode() {
        return Objects.hash(id, c_1, c_2);
    }
}
