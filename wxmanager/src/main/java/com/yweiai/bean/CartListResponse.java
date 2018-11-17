package com.yweiai.bean;

import com.fasterxml.jackson.databind.ser.Serializers;

import java.util.List;
import java.util.Map;

/**
 * 购物车列表
 * @author wj
 */
public class CartListResponse extends BaseBean {

    /**
     * goods_list: [
     *     {
     *         txtStyle:'',
     *                 goods_id:'123',
     *             goods_name:'雪碧',
     *             goods_price:'5.5',
     *             image: [{ file_path:'/images/user.png'}],
     *         spec_type:20, //多规格商品标识
     *                 goods_spec_id:'11-21', //商品规格id
     *             goods_sku: { goods_attr:'200ml-红色'},//规格中文描述
     *         total_num:'2' , //商品购买数量
     *     }
     *     ],
     *     order_total_num: 2,
     *     order_total_price: 267
     */
    private List<GoodInfo> goods_list;
    private int order_total_num;
    private double order_total_price;

    public CartListResponse() {
    }

    public List<GoodInfo> getGoods_list() {
        return goods_list;
    }

    public void setGoods_list(List<GoodInfo> goods_list) {
        this.goods_list = goods_list;
    }

    public int getOrder_total_num() {
        return order_total_num;
    }

    public void setOrder_total_num(int order_total_num) {
        this.order_total_num = order_total_num;
    }

    public double getOrder_total_price() {
        return order_total_price;
    }

    public void setOrder_total_price(double order_total_price) {
        this.order_total_price = order_total_price;
    }

    @Override
    public String toString() {
        return "CartListResponse{" +
                "goods_list=" + goods_list +
                ", order_total_num=" + order_total_num +
                ", order_total_price=" + order_total_price +
                '}';
    }
}
