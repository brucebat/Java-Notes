package apis;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import utils.GsonUtils;

import java.io.IOException;

/**
 * 外部api接口测试类
 *
 * @author brucebat
 * @version 1.0
 * @since Created at 2022/3/10 3:03 PM
 */
public class ApiTest {

    public static void main(String[] args) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://movie.douban.com").addConverterFactory(GsonConverterFactory.create()).build();
        DoubanApiService doubanApiService = retrofit.create(DoubanApiService.class);
        try {
            DoubanSubject doubanSubject = doubanApiService.getHotMovies("movie", "热门", 1, 20).execute().body();
            System.out.println(GsonUtils.toJsonString(doubanSubject));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
