package com.tcloudata.domain;

public class GoodDO {
    private Long id;

    private String goodName;

    private Integer size;

    private Double price;

    private String desc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "GoodDO{" +
                "id=" + id +
                ", goodName='" + goodName + '\'' +
                ", size=" + size +
                ", price=" + price +
                ", desc='" + desc + '\'' +
                '}';
    }
}
