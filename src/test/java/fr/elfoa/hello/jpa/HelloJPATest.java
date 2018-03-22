package fr.elfoa.hello.jpa;



import javax.persistence.ForeignKey;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


/**
 * @author Pierre Colomb
 */
public class HelloJPATest {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-database");
    private EntityManager em;
    private EntityTransaction tx;


    @Before
    public void initEntityManager() throws Exception {
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }


    @After
    public void closeEntityManager() throws Exception {
       if (em != null) {
           em.close();
       }
    }

    @Test
    public void test(){


        A a = new A("A1","A1");

        tx.begin();
        em.persist(a);
        tx.commit();

        Assert.assertEquals(1,a.getId().intValue());

    }

    @Test
    public void test2(){

        C c = new C("C1","C1");
        B b = new B("B1","B1",c);

        tx.begin();
        em.persist(b);
        tx.commit();

        Assert.assertEquals(2,b.getId().intValue());
        Assert.assertEquals(3,b.getC().getId().intValue());

    }


    @Test
    public void test3(){


        A a = em.find(A.class,1000);

        Assert.assertEquals(1000,a.getId().intValue());
        Assert.assertEquals("A1-1000",a.getA_1());
        Assert.assertEquals("A2-1000",a.getA_2());


        tx.begin();
        a.setA_2("BUMP");
        tx.commit();

        a = em.find(A.class,1000);

        Assert.assertEquals("BUMP",a.getA_2());
    }



    @Test
    public void test4(){


        A a = em.find(A.class,1001);

        em.detach(a);

        a.setA_1("FOO");
        a.setA_2("BAR");

        A freshA = em.find(A.class,1001);

        Assert.assertEquals(1001,a.getId().intValue());
        Assert.assertEquals("A1-1001",freshA.getA_1());
        Assert.assertEquals("A2-1001",freshA.getA_2());


        tx.begin();
        em.merge(a);
        tx.commit();

        a = em.find(A.class,1001);

        Assert.assertEquals("FOO",a.getA_1());
        Assert.assertEquals("BAR",a.getA_2());
    }


    @Test
    public void test5(){


        B b = em.find(B.class,1000);

        Assert.assertEquals(1000,b.getId().intValue());
        Assert.assertEquals("B1-1000",b.getB_1());
        Assert.assertEquals("B2-1000",b.getB_2());

        Assert.assertEquals("B2-1000",b.getB_2());


    }

    //Transiant null
    @Test
    public void test6(){
        D d = em.find(D.class, 1000);

        Assert.assertEquals(1000, d.getId().intValue());
        Assert.assertEquals("D1-1000", d.getD_1());
        Assert.assertEquals(null, d.getD_4());
    }

    //OneToMany
    @Test
    public void test7(){
        E e = em.find(E.class, 1000);

        Assert.assertEquals(1000, e.getId().intValue());
        Assert.assertEquals(1,e.getE_A().size());
        Assert.assertEquals("A1-1002",e.getE_A().get(0).getA_1());
    }

    //ManyToMany + Good Practice
    @Test
    public void test8(){
        C C0 = em.find(C.class, 1000);
        C C1 = em.find(C.class, 1001);
        C C2 = em.find(C.class, 1002);
        C C3 = em.find(C.class, 1003);

        D D0 = em.find(D.class, 1000);
        D D1 = em.find(D.class, 1001);
        D D2 = em.find(D.class, 1002);

        C_D c_d = em.find(C_D.class, 1000);

        //C side
        Assert.assertEquals(2, C0.getC_d().getDs().size());
        Assert.assertEquals(1, C1.getC_d().getDs().size());
        Assert.assertEquals(3, C2.getC_d().getDs().size());
        Assert.assertEquals(0, C3.getC_d().getDs().size());

        //D side
        Assert.assertEquals(2, D0.getC_d().getCs().size());
        Assert.assertEquals(2, D1.getC_d().getCs().size());
        Assert.assertEquals(2, D2.getC_d().getCs().size());
    }

}