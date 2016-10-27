package Java;

import org.junit.Test;

import java.util.List;

/**
 * Desc:
 * Author: Yehu
 * Created by kachesiji on 2016/10/27.
 */
public class City_test {

    @Test
    public void testCity(){
        City city = new City();
        List<City.CityListBean> cityList = city.getCityList();
        cityList.get(0);
    }
}
