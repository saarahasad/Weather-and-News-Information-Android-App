package com.example.apple.project2;

import java.util.List;

/**
 * Created by apple on 19/04/17.
 */

public class ForecastInformation {
    /**
     * city : {"id":6940463,"name":"Altstadt","coord":{"lon":11.5752,"lat":48.137},"country":"DE","population":0}
     * cod : 200
     * message : 0.2918285
     * cnt : 7
     * list : [{"dt":1492599600,"temp":{"day":276.8,"min":271.65,"max":276.8,"night":271.65,"eve":274.3,"morn":276.56},"pressure":968.91,"humidity":96,"weather":[{"id":601,"main":"Snow","description":"snow","icon":"w13d"}],"speed":3.36,"deg":8,"clouds":76,"snow":2.01},{"dt":1492686000,"temp":{"day":275.25,"min":266.57,"max":276,"night":266.57,"eve":274.07,"morn":271.15},"pressure":974.19,"humidity":96,"weather":[{"id":600,"main":"Snow","description":"light snow","icon":"w13d"}],"speed":1.67,"deg":21,"clouds":64,"snow":0.52},{"dt":1492772400,"temp":{"day":280.1,"min":269.22,"max":280.79,"night":278.21,"eve":278.39,"morn":269.22},"pressure":972.71,"humidity":78,"weather":[{"id":800,"main":"Clear","description":"sky is clear","icon":"w01d"}],"speed":2.11,"deg":270,"clouds":0},{"dt":1492858800,"temp":{"day":278.81,"min":275.48,"max":278.81,"night":275.48,"eve":277.31,"morn":277.88},"pressure":945.03,"humidity":0,"weather":[{"id":600,"main":"Snow","description":"light snow","icon":"w13d"}],"speed":5.14,"deg":294,"clouds":89,"rain":15.05,"snow":0.52},{"dt":1492945200,"temp":{"day":279.72,"min":272.53,"max":279.72,"night":272.53,"eve":278.07,"morn":275.25},"pressure":945.45,"humidity":0,"weather":[{"id":600,"main":"Snow","description":"light snow","icon":"w13d"}],"speed":3.16,"deg":285,"clouds":40,"rain":1.56,"snow":0.4},{"dt":1493031600,"temp":{"day":288.8,"min":275.9,"max":288.8,"night":278.18,"eve":284.81,"morn":275.9},"pressure":933.54,"humidity":0,"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"w10d"}],"speed":2.1,"deg":251,"clouds":49,"rain":0.58},{"dt":1493118000,"temp":{"day":280.54,"min":275.1,"max":280.54,"night":275.1,"eve":280.45,"morn":278.37},"pressure":927.45,"humidity":0,"weather":[{"id":502,"main":"Rain","description":"heavy intensity rain","icon":"w10d"}],"speed":2.84,"deg":276,"clouds":73,"rain":21.96}]
     */

    private CityBean city;
    private int cod;
    private double message;
    private int cnt;
    private List<ListBean> list;

    public CityBean getCity() {
        return city;
    }

    public void setCity(CityBean city) {
        this.city = city;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public double getMessage() {
        return message;
    }

    public void setMessage(double message) {
        this.message = message;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class CityBean {
        /**
         * id : 6940463
         * name : Altstadt
         * coord : {"lon":11.5752,"lat":48.137}
         * country : DE
         * population : 0
         */

        private int id;
        private String name;
        private CoordBean coord;
        private String country;
        private int population;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public CoordBean getCoord() {
            return coord;
        }

        public void setCoord(CoordBean coord) {
            this.coord = coord;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public int getPopulation() {
            return population;
        }

        public void setPopulation(int population) {
            this.population = population;
        }

        public static class CoordBean {
            /**
             * lon : 11.5752
             * lat : 48.137
             */

            private double lon;
            private double lat;

            public double getLon() {
                return lon;
            }

            public void setLon(double lon) {
                this.lon = lon;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }
        }
    }

    public static class ListBean {
        /**
         * dt : 1492599600
         * temp : {"day":276.8,"min":271.65,"max":276.8,"night":271.65,"eve":274.3,"morn":276.56}
         * pressure : 968.91
         * humidity : 96
         * weather : [{"id":601,"main":"Snow","description":"snow","icon":"w13d"}]
         * speed : 3.36
         * deg : 8
         * clouds : 76
         * snow : 2.01
         * rain : 15.05
         */

        private int dt;
        private TempBean temp;
        private double pressure;
        private int humidity;
        private double speed;
        private int deg;
        private int clouds;
        private double snow;
        private double rain;
        private List<WeatherBean> weather;

        public int getDt() {
            return dt;
        }

        public void setDt(int dt) {
            this.dt = dt;
        }

        public TempBean getTemp() {
            return temp;
        }

        public void setTemp(TempBean temp) {
            this.temp = temp;
        }

        public double getPressure() {
            return pressure;
        }

        public void setPressure(double pressure) {
            this.pressure = pressure;
        }

        public int getHumidity() {
            return humidity;
        }

        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }

        public double getSpeed() {
            return speed;
        }

        public void setSpeed(double speed) {
            this.speed = speed;
        }

        public int getDeg() {
            return deg;
        }

        public void setDeg(int deg) {
            this.deg = deg;
        }

        public int getClouds() {
            return clouds;
        }

        public void setClouds(int clouds) {
            this.clouds = clouds;
        }

        public double getSnow() {
            return snow;
        }

        public void setSnow(double snow) {
            this.snow = snow;
        }

        public double getRain() {
            return rain;
        }

        public void setRain(double rain) {
            this.rain = rain;
        }

        public List<WeatherBean> getWeather() {
            return weather;
        }

        public void setWeather(List<WeatherBean> weather) {
            this.weather = weather;
        }

        public static class TempBean {
            /**
             * day : 276.8
             * min : 271.65
             * max : 276.8
             * night : 271.65
             * eve : 274.3
             * morn : 276.56
             */

            private double day;
            private double min;
            private double max;
            private double night;
            private double eve;
            private double morn;

            public double getDay() {
                return day;
            }

            public void setDay(double day) {
                this.day = day;
            }

            public double getMin() {
                return min;
            }

            public void setMin(double min) {
                this.min = min;
            }

            public double getMax() {
                return max;
            }

            public void setMax(double max) {
                this.max = max;
            }

            public double getNight() {
                return night;
            }

            public void setNight(double night) {
                this.night = night;
            }

            public double getEve() {
                return eve;
            }

            public void setEve(double eve) {
                this.eve = eve;
            }

            public double getMorn() {
                return morn;
            }

            public void setMorn(double morn) {
                this.morn = morn;
            }
        }

        public static class WeatherBean {
            /**
             * id : 601
             * main : Snow
             * description : snow
             * icon : w13d
             */

            private int id;
            private String main;
            private String description;
            private String icon;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getMain() {
                return main;
            }

            public void setMain(String main) {
                this.main = main;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }
        }
    }
}
