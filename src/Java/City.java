package Java;


import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * Created by kachesiji on 2016/10/26.
 */

public class City {
    private static String city_file_name = "city.json";
    /**
     * p : 河南
     * c : [{"n":"石家庄","a":[{"s":"晋州市"},{"s":"新乐市"},{"s":"鹿泉市"}]},{"n":"唐山","a":[{"s":"遵化市"},{"s":"迁安市"}]}]
     */

    private List<CityListBean> cityList;

    public List<CityListBean> getCityList() {
        return cityList;
    }

    public void setCityList(List<CityListBean> cityList) {
        this.cityList = cityList;
    }

    public static class CityListBean {
        private String p;
        /**
         * n : 石家庄
         * a : [{"s":"晋州市"},{"s":"新乐市"},{"s":"鹿泉市"}]
         */

        private List<CBean> c;

        public String getP() {
            return p;
        }

        public void setP(String p) {
            this.p = p;
        }

        public List<CBean> getC() {
            return c;
        }

        public void setC(List<CBean> c) {
            this.c = c;
        }

        public static class CBean {
            private String n;
            /**
             * s : 晋州市
             */

            private List<ABean> a;

            public String getN() {
                return n;
            }

            public void setN(String n) {
                this.n = n;
            }

            public List<ABean> getA() {
                return a;
            }

            public void setA(List<ABean> a) {
                this.a = a;
            }

            public static class ABean {
                private String s;

                public String getS() {
                    return s;
                }

                public void setS(String s) {
                    this.s = s;
                }
            }
        }
    }

    public void parseCity() {
        City bean = JSON.parseObject(city_json, City.class);
        this.setCityList(bean.getCityList());

    }

    private String city_json = "";

}
