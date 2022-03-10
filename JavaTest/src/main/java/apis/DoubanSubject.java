package apis;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 豆瓣剧集详情
 *
 * @author brucebat
 * @version 1.0
 * @since Created at 2022/3/10 3:54 PM
 */
@Data
public class DoubanSubject implements Serializable {

    private List<MovieInfo> subjects;
}
