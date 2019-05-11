package com.example.apple.project2;

public class ForecastModel {

    String name;
    String min;
    String max;
    int id_;
    String iconweather;
    String desc;

    public ForecastModel(String name, String min, String max,int id_,String iconweather,String desc) {
        this.name = name;
        this.min = min;
        this.max=max;
        this.id_ = id_;
        this.iconweather=iconweather;
        this.desc=desc;
    }

    public String getName() {
        return name;
    }

    public String getMin() {
        return min;
    }

  /* public int getImage() {
        return image;
    }*/
    public String getICon(){
        return iconweather;
    }
    public String getMax() {
        return max;
    }
    public String getDesc() {
        return desc;
    }
}