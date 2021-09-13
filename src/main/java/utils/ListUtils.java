package utils;

import java.util.List;

/**
 * List subList 工具类
 *
 * @author 林子洋
 * @create 2021-09-13 15:15:23
 */
public class ListUtils {

    public static List startPage(List list, Integer pageNum, Integer pageSize) {
        if(list == null){
            return null;
        }
        if(list.size() == 0){
            return null;
        }
        //记录总数
        int count = list.size();

        //开始索引
        int fromIndex = (pageNum - 1) * pageSize;
        //结束索引
        int toIndex = pageNum * pageSize;
        if (fromIndex + 1 > count) {
            return null;
        }
        if (pageNum * pageSize > count) {
            toIndex = count;
        }
        return list.subList(fromIndex, toIndex);
    }

}
