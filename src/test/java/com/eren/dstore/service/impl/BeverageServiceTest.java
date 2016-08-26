package com.eren.assignment.sahibinden.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eren.assignment.sahibinden.entity.Beverage;
import com.eren.assignment.sahibinden.service.BeverageService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:**/servlet-context.xml")
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
// @SqlGroup({ @Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts =
// "classpath:db/insert-data.sql") })
public class BeverageServiceTest {
  @Autowired
  private BeverageService beverageService;

  @Test
  public void _1testCreateNewBeverage() throws Exception {
    Beverage beverage = new Beverage();
    beverage.setCost(5);
    beverage.setName("tea");
    beverage.setCdate(new Date());

    beverageService.createNewBeverage(beverage);
    assertEquals(6, beverage.getId().longValue());
  }

  @Test
  public void _2testUpdateBeverage() throws Exception {
    Beverage beverage = beverageService.getBeverage(1);
    beverage.setCost(10);
    beverageService.updateBeverage(beverage);
    Beverage beverage2 = beverageService.getBeverage(1);
    assertEquals(10, beverage2.getCost());
  }

  @Test
  public void _3testGetAllBeverages() throws Exception {
    List<Beverage> beverages = beverageService.getAllBeverages();
    assertTrue(!beverages.isEmpty());
  }

  @Test
  public void _4testGetBeverage() throws Exception {
    Beverage beverage = beverageService.getBeverage(1);
    assertEquals(1, beverage.getId().longValue());
  }


}
