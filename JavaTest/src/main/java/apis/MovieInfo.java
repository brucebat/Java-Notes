package apis;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author brucebat
 * @version 1.0
 * @since Created at 2022/3/10 3:43 PM
 */
@Data
public class MovieInfo implements Serializable {
    /**
     * id
     */
    private Long id;
    /**
     * 剧集信息
     */
    @SerializedName("episodes_info")
    private String episodesInfo;
    /**
     * 热度
     */
    private Double rate;
    /**
     * 封面坐标x
     */
    @SerializedName("cover_x")
    private Double coverX;
    /**
     * 封面坐标y
     */
    @SerializedName("cover_y")
    private Double coverY;
    /**
     * 标题
     */
    private String title;
    /**
     * 豆瓣剧集详情地址
     */
    private String url;
    /**
     * 是否可以播放
     */
    private Boolean playable;
    /**
     * 封面地址
     */
    private String cover;
    /**
     * 是否新上映
     */
    @SerializedName("is_new")
    private Boolean isNew;
}
