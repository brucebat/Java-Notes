package apis;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author brucebat
 * @version 1.0
 * @since Created at 2022/3/10 2:57 PM
 */
public interface DoubanApiService {

    /**
     * 分页获取豆瓣热门电影
     *
     * @param type      类型
     * @param tag       标签
     * @param pageStart 分页开始
     * @param pageLimit 分页大小
     * @return 分页查询结果
     */
    @GET("/j/search_subjects")
    Call<DoubanSubject> getHotMovies(@Query("type") String type, @Query("tag") String tag, @Query("page_start") Integer pageStart, @Query("page_limit") Integer pageLimit);
}
