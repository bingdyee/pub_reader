package cn.scifi.pubreader.infrastructure.common.web;


import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * 分页返回参数
 *
 * @author Bing D. Yee
 * @since 2022/01/12
 */
@Getter
@Setter
public class Paging<E> implements Iterable<E>{

    public static final int MAX_PAGE = 99;

    private int total;
    private int current;
    private int size;
    private List<E> records;

    public Paging() {
        this(Collections.emptyList(), 0, 10, 0);
    }

    public Paging(int page, int size) {
        this(Collections.emptyList(), page, size, 0);
    }

    public Paging(int page, int size, int sortBy) {
        this(Collections.emptyList(), page, size, 0);
    }

    public Paging(List<E> content, int page, int size, int totalElements) {
        this.records = Collections.unmodifiableList(content);
        this.total = totalElements;
        this.current = page;
        this.size = size;
    }

    public static <T> Paging<T> of(List<T> content, int page, int size, int totalElements) {
        return new Paging<>(content, page, size, totalElements);
    }

    public static <T> Paging<T> of(int page, int size) {
        return new Paging<>(page, size);
    }

    public static <T> Paging<T> of(int page, int size, int sortBy) {
        return new Paging<>(page, size, sortBy);
    }

    public static <T> Paging<T> empty() {
        return new Paging<>();
    }

    public Integer getTotalPages() {
        int totalPages = this.getSize() == 0 ? 1 : (int) Math.ceil((double) this.total / (double) getSize());
        return Math.min(totalPages, MAX_PAGE);
    }

    @NonNull
    @Override
    public Iterator<E> iterator() {
        return this.records.iterator();
    }

}
