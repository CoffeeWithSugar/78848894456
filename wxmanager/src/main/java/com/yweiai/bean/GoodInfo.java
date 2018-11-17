package com.yweiai.bean;

import java.util.List;
import java.util.Map;

/**
 * 商品信息
 * @author wj
 */
public class GoodInfo {
   /* txtStyle:'',
    goods_id:'123',
    goods_name:'雪碧',
    goods_price:'5.5',
    image: [{ file_path:'/images/user.png'}],
    spec_type:20, //多规格商品标识
    goods_spec_id:'11-21', //商品规格id
    goods_sku: { goods_attr:'200ml-红色'},//规格中文描述
    total_num:'2' , //商品购买数量*/
   private String txtStyle;
   private String goods_id;
   private String goods_name;
   private double goods_price;
   private List<Map<String,String>> image;
   private String spec_type;
   private String goods_spec_type;
   private Map<String,String> goods_sku;
   private int total_num;

    public GoodInfo() {
    }

    @Override
    public String toString() {
        return "GoodInfo{" +
                "txtStyle='" + txtStyle + '\'' +
                ", goods_id='" + goods_id + '\'' +
                ", goods_name='" + goods_name + '\'' +
                ", goods_price='" + goods_price + '\'' +
                ", image=" + image +
                ", spec_type='" + spec_type + '\'' +
                ", goods_spec_type='" + goods_spec_type + '\'' +
                ", goods_sku=" + goods_sku +
                ", total_num=" + total_num +
                '}';
    }

    public String getTxtStyle() {
        return txtStyle;
    }

    public void setTxtStyle(String txtStyle) {
        this.txtStyle = txtStyle;
    }

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public double getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(double goods_price) {
        this.goods_price = goods_price;
    }

    public List<Map<String, String>> getImage() {
        return image;
    }

    public void setImage(List<Map<String, String>> image) {
        this.image = image;
    }

    public String getSpec_type() {
        return spec_type;
    }

    public void setSpec_type(String spec_type) {
        this.spec_type = spec_type;
    }

    public String getGoods_spec_type() {
        return goods_spec_type;
    }

    public void setGoods_spec_type(String goods_spec_type) {
        this.goods_spec_type = goods_spec_type;
    }

    public Map<String, String> getGoods_sku() {
        return goods_sku;
    }

    public void setGoods_sku(Map<String, String> goods_sku) {
        this.goods_sku = goods_sku;
    }

    public int getTotal_num() {
        return total_num;
    }

    public void setTotal_num(int total_num) {
        this.total_num = total_num;
    }
}
