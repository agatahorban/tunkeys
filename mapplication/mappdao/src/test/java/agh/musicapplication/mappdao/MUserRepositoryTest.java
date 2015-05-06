/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package agh.musicapplication.mappdao;

import agh.musicapplication.mappdao.interfaces.MUserRepositoryInterface;
import agh.musicapplication.mappmodel.MUser;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.assertj.core.api.Assertions.*;
/**
 *
 * @author ag
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
@Transactional
public class MUserRepositoryTest {
    
    @Inject
    private MUserRepositoryInterface sut;
    
    private MUser testUser;
    
    public MUserRepositoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        testUser = new MUser("test","test","testn","testsur",null,null,"test user");
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void shouldFindOneUserByLogin() {
       sut.insert(testUser);
       MUser u = sut.findUserByLogin("test");
       Assert.assertNotNull(u);
    }
    
    @Test
    public void shouldNotFindOneUserByLoginAndReturnNull(){
        MUser u = sut.findUserByLogin("test");
        assertThat(u)
                .isNull();
    }

    
}
