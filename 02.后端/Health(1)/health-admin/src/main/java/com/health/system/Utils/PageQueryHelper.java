package com.health.system.Utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PageQueryHelper {

    /**
     * 提取指定字段列表（避免重复）
     */
    public static <T, R> Set<R> extractIds(List<T> sourceList, Function<T, R> idExtractor) {
        return sourceList.stream()
                .map(idExtractor)
                .filter(id -> id != null)
                .collect(Collectors.toSet());
    }

    /**
     * 将列表转换为 Map，支持指定主键
     */
    public static <T, R> Map<R, T> listToMap(List<T> list, Function<T, R> keyExtractor) {
        return list.stream().collect(Collectors.toMap(keyExtractor, Function.identity()));
    }

    /**
     * 构建分页结果
     */
    public static <T> Page<T> buildPage(Page<?> originPage, List<T> records) {
        Page<T> page = new Page<>();
        page.setRecords(records);
        page.setTotal(originPage.getTotal());
        page.setSize(originPage.getSize());
        page.setCurrent(originPage.getCurrent());
        return page;
    }
}
