package com.yweiai.bean;

/**
 * 购物车跳转结算页面接口返回值
 * @author wj
 */
public class OrderCartResponse extends BaseBean{

    /**
     * 收货地址
     */
    private String address;

    /**
     * 是否在配送区域内
     */
    private boolean intra_region;

    public OrderCartResponse(String address, boolean intra_region) {
        this.address = address;
        this.intra_region = intra_region;
    }

    public OrderCartResponse() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isIntra_region() {
        return intra_region;
    }

    public void setIntra_region(boolean intra_region) {
        this.intra_region = intra_region;
    }

    @Override
    public String toString() {
        return "OrderCartResponse{" +
                "address='" + address + '\'' +
                ", intra_region=" + intra_region +
                '}';
    }
}
