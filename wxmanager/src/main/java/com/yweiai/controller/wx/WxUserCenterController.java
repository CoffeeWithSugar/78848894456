package com.yweiai.controller.wx;

import com.yweiai.bean.OperationResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微信个人中心
 * @author wj
 */
@RestController
@RequestMapping("/rest")
public class WxUserCenterController {

    /**
     * 个人中心首页
     * @param userId
     * @param token
     * @return
     */
    @RequestMapping(value = "user.index/detail",method = RequestMethod.GET)
    public OperationResult getUserIndexPageInfo(@RequestParam(value = "user_id") String userId,
                                                @RequestParam(value = "token") String token){
        OperationResult result=new OperationResult();
        System.out.println("个人中心首页。。。。");
        result.setMsg("用户未登录");
        return result;
    }


    /**
     * 个人中心，我的帮助
     * @param wxappId
     * @param token
     * @param userId
     * @return
     */
    @RequestMapping(value = "/wxapp/help", method = RequestMethod.GET)
    public OperationResult getMyHelp(@RequestParam(value = "wxapp_id") String wxappId,
                                     @RequestParam(value = "token") String token,
                                     @RequestParam(value = "user_id") String userId) {
        OperationResult result=new OperationResult();
        System.out.println("个人中心--我的帮助:" + wxappId);
        return result;
    }
}
