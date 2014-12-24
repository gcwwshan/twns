package org.nightschool.model;

/**
 * Created by gc on 2014/12/6.
 */
public class Disk {
    private String name;
    private String imgUrl;
    private String desc;
    private double price;


    public Disk(String name,String imgUrl,String desc,double price) {
        this.name = name;
        this.imgUrl = imgUrl;
        this.desc = desc;
        this.price = price;
    }

   public Disk() {                          //重载无参构造函数
    }

    public String getName() {
        return name;
    }
    public String getImgUrl() {
        return imgUrl;
    }

    public String getDesc() {
        return desc;
    }

    public double getPrice() {
        return price;
    }

}