package com.yweiai.controller.wx;

import com.yweiai.bean.OperationResult;
import com.yweiai.util.Const;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 微信地址管理
 * @author wj
 */
@RestController
@RequestMapping("/rest")
public class WxAddressController {

    /**
     * 收货地址新增接口
     *
     * @param param
     * @return
     */
    @RequestMapping(value = "/address/add", method = RequestMethod.POST)
    public OperationResult addressAdd(@RequestBody Map<String, Object> param) {
        OperationResult result = new OperationResult();
        System.out.println("新增地址接口。。。。" + param);
        result.setCode(Const.SUCCESS);
        result.setMsg("新增收货地址成功");
        return result;
    }

    /**
     * 获取收货地址列表
     * @param userId
     * @param token
     * @return
     */
    @RequestMapping(value = "/address/lists",method=RequestMethod.GET)
    public OperationResult getAddressList(@RequestParam(value="user_id")String userId,
                                          @RequestParam(value="token")String token){
        OperationResult result=new OperationResult();
        result.setCode(1);
        return result;
    }

    /**
     * 获取收货地址详情
     * @param userId
     * @param token
     * @return
     */
    @RequestMapping(value = "/address/detail",method=RequestMethod.GET)
    public OperationResult getAddressDetail(@RequestParam(value="user_id")String userId,
                                            @RequestParam(value="token")String token,
                                            @RequestParam(value = "address_id")String addressId){
        OperationResult result=new OperationResult();
        result.setCode(1);
        return result;
    }

    /**
     * 收货地址删除
     * @param addressId
     * @return
     */
    @RequestMapping(value = "/address/delete",method = RequestMethod.POST)
    public OperationResult deleteAddress(@RequestBody String addressId){
        OperationResult result=new OperationResult();
        result.setCode(1);
        return result;
    }

    /**
     * 收货地址编辑
     * @param address
     * @return
     */
    @RequestMapping(value = "/address/edit",method = RequestMethod.POST)
    public OperationResult deleteAddress(@RequestBody Map<String,Object> address){
        OperationResult result=new OperationResult();
        result.setCode(1);
        return result;
    }
}
