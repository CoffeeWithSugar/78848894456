package com.yweiai.controller;

import com.github.pagehelper.PageInfo;
import com.yweiai.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
/**
* @Description:    框架测试controller
* @Author:         wujian
* @CreateDate:     2018-11-13 9:35
* @Version:        1.0
*/
@RestController
@RequestMapping("/test")
public class TestController {
    //private static final Logger log=Logger.getLogger(TestController.class);
    Logger log=LoggerFactory.getLogger(TestController.class);

    /**
     * 变量描述
     */
    @Autowired
    private TestService service;
    
    
    /**
    * @Description:    请输入方法描述方法描述
    * @Author:         wujian
    * @Param:          
    * @Return:         
    * @Exception:      
    * @CreateDate:     2018-11-13 9:42
    * @UpdateUser:     update by
    * @UpdateDate:     2018-11-13 9:42
    * @UpdateRemark:   
    * @Version:        1.0
    */
    @RequestMapping("/getLoginLog")
    public void test(){
        System.out.println(service.getLoginLog());
        System.out.println("mapper"+service.getLoginLogFromMapper());
        System.out.println("mapper id=148c77894c6145868c832711d5e67fc3"
                +service.getLoginLogByIdFromMapper("148c77894c6145868c832711d5e67fc3"));
        log.info("mapper id=148c77894c6145868c832711d5e67fc3");
        log.info(service.getLoginLogByIdFromMapper("148c77894c6145868c832711d5e67fc3").toString());
    }

    /**
    * @Description:    请输入方法描述方法描述
    * @Author:         wujian
    * @Param:          pageIndex:页码
    * @Return:         
    * @Exception:      
    * @CreateDate:     2018-11-13 9:43
    * @UpdateUser:     update by
    * @UpdateDate:     2018-11-13 9:43
    * @UpdateRemark:   
    * @Version:        1.0
    */
    @RequestMapping("/page")
    @ResponseBody
    public PageInfo<Map<String,Object>> loginLogPageQuery(@RequestParam(value = "pageIndex") int pageIndex){
        return service.getLoginLogPage(pageIndex);
    }
}
