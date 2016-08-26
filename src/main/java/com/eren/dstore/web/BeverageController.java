package com.eren.assignment.sahibinden.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eren.assignment.sahibinden.entity.Beverage;
import com.eren.assignment.sahibinden.exception.ServiceResponse;
import com.eren.assignment.sahibinden.service.BeverageService;

@RestController
public class BeverageController extends BaseController {
  @Autowired
  BeverageService beverageService;

  @RequestMapping(value = "/beverages", method = RequestMethod.GET)
  public List<Beverage> getAllBeverages() {
    List<Beverage> beverages = beverageService.getAllBeverages();
    return beverages;
  }

  @RequestMapping(value = "/beverages/{id}", method = RequestMethod.GET)
  public Beverage getBeverage(@PathVariable int id) {
    return beverageService.getBeverage(id);
  }

  @RequestMapping(value = "/beverages", method = RequestMethod.POST)
  public ServiceResponse createNewBeverage(@RequestBody Beverage beverage) {
    return beverageService.createNewBeverage(beverage);
  }

  @RequestMapping(value = "/beverages/{id}", method = RequestMethod.PUT)
  public ServiceResponse updateBeverage(@PathVariable int id, @RequestBody Beverage beverage) {
    return beverageService.updateBeverage(beverage);
  }

  @RequestMapping(value = "/beverages/{id}", method = RequestMethod.DELETE)
  public ServiceResponse removeBeverage(@PathVariable int id) {
    return beverageService.removeBeverage(id);
  }

}
