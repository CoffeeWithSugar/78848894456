package com.yweiai.controller.wx;

import com.yweiai.bean.OperationResult;
import com.yweiai.bean.OrderCartResponse;
import com.yweiai.util.Const;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 微信订单相关接口
 * @author wj
 */
@RestController
@RequestMapping("/rest")
public class WxOrderController {
    /**
     * 购物车跳转结算页面接口
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/order/cart", method = RequestMethod.GET)
    public OperationResult getUserShopCart(HttpServletRequest request,
                                           @RequestParam(value = "token") String token,
                                           @RequestParam(value = "user_id") String userId) {
        OperationResult result = new OperationResult();
        OrderCartResponse data = new OrderCartResponse("广东省番禺区大石街道", true);
        System.out.println("获取购物车商品接口user_id：" + request.getSession().getId());
        System.out.println("token:" + token + "---user_id:" + userId);
        result.setCode(Const.SUCCESS);
        result.setData(data);
        result.setMsg("接口请求成功。。。。");
        return result;
    }

    /**
     * 立即购买接口
     *
     * @return
     */
    @RequestMapping(value = "/order/buynow", method = RequestMethod.POST)
    public OperationResult shopCartBuyNow(@RequestBody Map<String,Object> param) {
        System.out.println("立即购买提交订单："+param);
        OperationResult result = new OperationResult();
        result.setCode(Const.SUCCESS);
        return result;
    }

    /**
     * 购物车提交订单接口
     *
     * @return
     */
    @RequestMapping(value = "/order/cart", method = RequestMethod.POST)
    public OperationResult shopCartSubmitOrder(@RequestBody Map<String,Object> param) {
        System.out.println("购物车提交订单："+param);
        OperationResult result = new OperationResult();
        result.setCode(Const.SUCCESS);
        return result;
    }

    /**
     * 获取订单详情
     * @param orderId 订单号
     * @return
     */
    @RequestMapping(value = "user.order/detail",method = RequestMethod.GET)
    public OperationResult getOrderDetail(@RequestParam(value = "order_id") String orderId){
        System.out.println("获取订单详情："+orderId);
        OperationResult result = new OperationResult();
        result.setCode(Const.SUCCESS);
        return result;
    }

    /**
     * 个人中心获取订单列表
     * @param userId
     * @param token
     * @return
     */
    @RequestMapping(value = "user.order/lists",method = RequestMethod.GET)
    public OperationResult getUserOrderList(@RequestParam(value = "user_id") String userId,
                                            @RequestParam(value = "token") String token,
                                            @RequestParam(value = "dataType") String dataType){
        OperationResult result=new OperationResult();
        System.out.println("个人中心订单列表。。。。"+dataType+"--"+userId+"---"+token);
        result.setMsg("用户未登录");
        return result;
    }

    /**
     * 取消订单
     * @param param
     * @return
     */
    @RequestMapping(value = "user.order/cancel",method = RequestMethod.POST)
    public OperationResult cancelOrder(@RequestBody Map<String,Object> param){
        OperationResult result=new OperationResult();
        System.out.println("取消订单"+param);
        result.setMsg("用户未登录");
        return result;
    }

    /**
     * 确认收货
     * @param param
     * @return
     */
    @RequestMapping(value = "user.order/receipt",method = RequestMethod.POST)
    public OperationResult cancelReceipt(@RequestBody Map<String,Object> param){
        OperationResult result=new OperationResult();
        System.out.println("确认收货："+param);
        result.setMsg("用户未登录");
        return result;
    }

}
