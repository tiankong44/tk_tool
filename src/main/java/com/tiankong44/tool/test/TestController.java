package com.tiankong44.tool.test;

import com.tiankong44.tool.base.entity.BaseRes;
import com.tiankong44.tool.mapper.slave.TestMapper;
import com.tiankong44.tool.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description :
 * @Author zhanghao_SMEICS
 * @Date 2022/10/21  13:42
 **/
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService testService;

    @PostMapping("/test")
    @ResponseBody
    public BaseRes test(@RequestBody String msg) {
        System.out.println("===============");
        int test = testService.test();

        return BaseRes.success(test);
    }
}
