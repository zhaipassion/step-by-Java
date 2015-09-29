package com.smart4j.chapter02.service;

import com.smart4j.chapter02.model.Customer;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Bob on 2015/9/29.
 */
public class CustomerServiceTest extends TestCase {

    private final CustomerService customerService;

    public CustomerServiceTest() {
        customerService = new CustomerService();
    }

    @Before
    public void init() {
        // TODO 初始化数据库
    }

    @Test
    public void testGetCustomerList() throws Exception {
        List<Customer> customerList = customerService.getCustomerList();
        assertEquals(2, customerList);
    }

    @Test
    public void testGetCustomer() throws Exception {
        Long id = 1l;
        Customer customer = customerService.getCustomer(id);
        assertNotNull(customer);
    }

    @Test
    public void testCreateCustomer() throws Exception {
        Map<String, Object> filedMap = new HashMap<String, Object>();
        filedMap.put("name", "customer100");
        filedMap.put("contact", "John");
        filedMap.put("telephone", "13890909090");
        Boolean result = customerService.createCustomer(filedMap);
        assertTrue(result);
    }

    @Test
    public void testUpdateCustomer() throws Exception {
        Long id = 1l;
        Map<String, Object> filedMap = new HashMap<String, Object>();
        filedMap.put("contact", "Eric");
        Boolean result = customerService.updateCustomer(id, filedMap);
        assertTrue(result);
    }

    @Test
    public void testDeleteCustomer() throws Exception {
        Long id = 1l;
        Boolean result = customerService.deleteCustomer(id);
        assertTrue(result);
    }
}