package cn.chainof.micro.controller;

import cn.chainof.micro.model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lisen on 2017/12/27.
 */
@RestController
public class UserBatchController {

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<Customer> batchUser(@RequestParam(value = "ids")String ids) {
        System.out.println("ids===:" + ids);
        List<Customer> lists = new ArrayList<>();
        lists.add(new Customer(1l, "小明"));
        lists.add(new Customer(2l, "小红"));
        lists.add(new Customer(3l, "小张"));
        lists.add(new Customer(4l, "小王"));
        lists.add(new Customer(5l, "小李"));

        return lists;
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public Customer singleUser(@PathVariable("id") String id) {
        Customer user = new Customer(100L, "大王");
        return user;
    }

}
