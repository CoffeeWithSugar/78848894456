package com.yweiai.controller.wx;

import com.alibaba.fastjson.JSONObject;
import com.yweiai.bean.LoginResponse;
import com.yweiai.bean.OperationResult;
import com.yweiai.bean.WxIndexPageConfig;
import com.yweiai.util.Const;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 微信页面配置
 *
 * @author wj
 */
@RestController
@RequestMapping("/rest")
public class WxPageController {

    private static final Logger logger=Logger.getLogger(WxPageController.class);

    /**
     * 使用@RequestBody映射请求参数
     * 微信首页
     * @param wxappId
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public WxIndexPageConfig getIndexPageConfig(@RequestParam(value = "wxapp_id") String wxappId) {
        System.out.println("wxapp_id:" + wxappId);
        logger.info("微信首页配置index：请求参数：" + wxappId);
        WxIndexPageConfig indexPageConfig = new WxIndexPageConfig();
        indexPageConfig.setNewGoodList(new ArrayList<Map<String, String>>());
        indexPageConfig.setRecommendationsList(new ArrayList<Map<String, String>>());
        logger.info("微信首页配置index：返回结果：" + indexPageConfig.toString());
        return indexPageConfig;
    }

    /**
     * 微信用户登录接口
     *
     * @param param
     * @return
     */
    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public OperationResult userLogin(@RequestBody Map<String, Object> param) {
        LoginResponse response = new LoginResponse();
        System.out.println(param);
        response.setToken("SDTGU&*^$%HFHD");
        response.setUser_id("ywai_12334884");
        OperationResult result = new OperationResult(Const.SUCCESS, response, "登录成功");
        System.out.println("微信用户登录接口返回报文：" + result.toString());
        return result;
    }

    @RequestMapping(value="/test",method = RequestMethod.GET)
    public void testRequest(HttpServletRequest request){
        Map<String,String[]> params=request.getParameterMap();
        Map<String,Object> t=new HashMap<>();
        for(Map.Entry<String,String[]> p : params.entrySet()){
            String name=p.getKey();
            String[] value=p.getValue();
            if(value!=null && value.length>0){
                t.put(name,value[0]);
            }
        }
        t.put("userId","root");
        String str= JSONObject.toJSONString(t);
        System.out.println(str);
    }

}
