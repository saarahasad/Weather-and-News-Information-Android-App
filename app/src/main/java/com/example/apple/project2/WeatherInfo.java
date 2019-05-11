package com.example.apple.project2;

public class WeatherInfo {

    public  final Cloud cloud;
    public final Coord coord;
    public final Sys sys;
    public final Weather[] weather;
    public final Main main;
    public final Wind wind;
    public final String name;
    public final long visibility;
    public final String base;
    public final double dt;
    public final double id;
    public final double cod;



    public WeatherInfo(double cod, double id, Cloud cloud, long visibility, Coord coord, Sys sys, Weather[] weather, Main main, Wind wind, String name, String base, double dt) {
        this.cloud=cloud;
        this.name = name;
        this.visibility=visibility;
        this.sys = sys;
        this.weather = weather;
        this.coord = coord;
        this.base=base;
        this.dt=dt;
        this.main = main;
        this.id=id;
        this.wind = wind;
        this.cod=cod;

    }

    class Cloud{

        public final double all;

        Cloud(double all)
        {
            this.all=all;
        }

    }

    class Coord {
        public final double lon;
        public final double lat;

        Coord(double lon, double lat) {
            this.lon = lon;
            this.lat = lat;
        }
    }

    class Sys {
        public final String country;
        public final double sunset;
        public final double message;
        public final double type;
        public final double id;
        public final double sunrise;

        Sys(String country,double sunset,double message,double type,double id,double sunrise) {
            this.country = country;
            this.sunset=sunset;
            this.message=message;
            this.type=type;
            this.id=id;
            this.sunrise=sunrise;
        }
    }

    class Weather {
        public final String main;
        public final double id;
        public final String icon;
        public final String description;

        Weather(String main,double id,String icon,String description) {
            this.main=main;
            this.id=id;
            this.icon=icon;
            this.description = description;
        }
    }

    class Main {
        public final double temp;
        public final double pressure;

        public final double humidity;
        public final double temp_min;
        public final double temp_max;

        Main(double pressure,double temp, double humidity, double temp_min, double temp_max) {
          this.pressure=pressure;
            this.temp_min = temp_min;
            this.temp_max = temp_max;
            this.temp = temp;
            this.humidity = humidity;

        }
    }

    class Wind {
        public final double speed;
        public final double deg;

        Wind(double speed,double deg) {
            this.speed = speed;
            this.deg=deg;
        }
    }
}
