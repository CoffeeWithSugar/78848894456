package com.yweiai.controller.wx;

import com.yweiai.bean.CartListResponse;
import com.yweiai.bean.GoodInfo;
import com.yweiai.bean.OperationResult;
import com.yweiai.util.Const;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 微信购物车相关
 * @author wj
 */
@RestController
@RequestMapping("/rest")
public class WxShopCartController {

    /**
     * 获取购物车列表
     */
    @RequestMapping(value = "/cart/list", method = RequestMethod.GET)
    public OperationResult getCartList(@RequestParam(value = "user_id") String userId,
                                       @RequestParam(value = "token") String token) {
        System.out.println("获取购物车列表："+userId+"---"+token);
        OperationResult result = new OperationResult();
        CartListResponse data=new CartListResponse();
        List<GoodInfo> goods=new ArrayList<>();
        GoodInfo good=new GoodInfo();
        good.setGoods_id("123");
        good.setGoods_name("老干妈");
        good.setGoods_price(10.5);

        Map<String,String> goodSku=new HashMap<>();
        goodSku.put("goods_attr","200ml-红色");
        good.setGoods_sku(goodSku);

        good.setGoods_spec_type("11-12");
        good.setTotal_num(2);
        good.setTxtStyle("");

        List<Map<String,String>> image=new ArrayList<>();
        Map<String,String> t=new HashMap<>();
        t.put("file_path","/images/user.png");
        image.add(t);
        good.setImage(image);
        goods.add(good);
        data.setGoods_list(goods);

        data.setGoods_list(goods);
        data.setOrder_total_num(1);
        data.setOrder_total_price(21);

        result.setData(data);
        result.setMsg("请求成功");
        result.setCode(Const.SUCCESS);
        System.out.println(result);
        return result;
    }

}
