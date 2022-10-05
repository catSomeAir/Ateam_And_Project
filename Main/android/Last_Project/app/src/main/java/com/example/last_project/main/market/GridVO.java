package com.example.last_project.main.market;

public class GridVO {
    private int market_imgv_item;
    private String market_tv_menu_brand_name, market_tv_menu_name
                 , market_tv_menu_price1;

    public GridVO(int market_imgv_item, String market_tv_menu_brand_name
                , String market_tv_menu_name, String market_tv_menu_price1) {
        this.market_imgv_item = market_imgv_item;
        this.market_tv_menu_brand_name = market_tv_menu_brand_name;
        this.market_tv_menu_name = market_tv_menu_name;
        this.market_tv_menu_price1 = market_tv_menu_price1;
    }

    public int getMarket_imgv_item() {
        return market_imgv_item;
    }

    public void setMarket_imgv_item(int market_imgv_item) {
        this.market_imgv_item = market_imgv_item;
    }

    public String getMarket_tv_menu_brand_name() {
        return market_tv_menu_brand_name;
    }

    public void setMarket_tv_menu_brand_name(String market_tv_menu_brand_name) {
        this.market_tv_menu_brand_name = market_tv_menu_brand_name;
    }

    public String getMarket_tv_menu_name() {
        return market_tv_menu_name;
    }

    public void setMarket_tv_menu_name(String market_tv_menu_name) {
        this.market_tv_menu_name = market_tv_menu_name;
    }

    public String getMarket_tv_menu_price1() {
        return market_tv_menu_price1;
    }

    public void setMarket_tv_menu_price1(String market_tv_menu_price1) {
        this.market_tv_menu_price1 = market_tv_menu_price1;
    }
}
