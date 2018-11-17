package com.yweiai.bean;

import java.util.List;
import java.util.Map;

/**
 * 微信小程序首页配置实体类
 *
 * @author wj
 */
public class WxIndexPageConfig {

    private List<Map<String, String>> newGoodList;
    private List<Map<String, String>> recommendationsList;

    public WxIndexPageConfig(List<Map<String, String>> newGoodList, List<Map<String, String>> recommendationsList) {
        this.newGoodList = newGoodList;
        this.recommendationsList = recommendationsList;
    }

    @Override
    public String toString() {
        return "WxIndexPageConfig{" +
                "newGoodList=" + newGoodList +
                ", recommendationsList=" + recommendationsList +
                '}';
    }

    public WxIndexPageConfig() {

    }

    public List<Map<String, String>> getNewGoodList() {
        return newGoodList;
    }

    public void setNewGoodList(List<Map<String, String>> newGoodList) {
        this.newGoodList = newGoodList;
    }

    public List<Map<String, String>> getRecommendationsList() {
        return recommendationsList;
    }

    public void setRecommendationsList(List<Map<String, String>> recommendationsList) {
        this.recommendationsList = recommendationsList;
    }
}

