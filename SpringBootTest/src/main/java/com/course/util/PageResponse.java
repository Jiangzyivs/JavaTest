package com.course.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageResponse<T> {
    private Integer total;
    private Boolean hasPre;
    private Boolean hasNext;
    private Integer current;
    private Integer pages;
    private Integer size;
    private Map<String, Object> extra = new HashMap();
    private static final long serialVersionUID = 1L;
    protected List<T> records;

    public PageResponse() {
    }

    public PageResponse(PageList page) {
        this.total = page.getTotal();
        this.current = page.getCurrent();
        this.size = page.getSize();
        this.pages = page.getPages();
        this.hasPre = page.getHasPre();
        this.hasNext = page.getHasNext();
        this.records = page;
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

    public static long getSerialVersionUID() {
        return 1L;
    }

    public List<T> getRecords() {
        return this.records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
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

    public Map<String, Object> getExtra() {
        return this.extra;
    }

    public void putExtra(String key, Object val) {
        this.extra.put(key, val);
    }
}
