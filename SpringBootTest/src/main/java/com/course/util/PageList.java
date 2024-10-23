package com.course.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class PageList<T> extends ArrayList<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer total;
    private Boolean hasPre;
    private Boolean hasNext;
    private Integer current;
    private Integer pages;
    private Integer size;

    public PageList() {
    }

    public PageList(int size) {
        super(size);
    }

    public PageList(Collection<? extends T> c) {
        super(c);
    }

    public static long getSerialVersionUID() {
        return 1L;
    }

    public Integer getTotal() {
        return this.total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getCurrent() {
        return this.current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getPages() {
        return this.pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getSize() {
        return this.size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Boolean getHasPre() {
        return this.hasPre;
    }

    public void setHasPre(Boolean hasPre) {
        this.hasPre = hasPre;
    }

    public Boolean getHasNext() {
        return this.hasNext;
    }

    public void setHasNext(Boolean hasNext) {
        this.hasNext = hasNext;
    }
}