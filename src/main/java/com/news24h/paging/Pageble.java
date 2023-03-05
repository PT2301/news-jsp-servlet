package com.news24h.paging;

import com.news24h.sort.Sorter;

public interface Pageble {
Integer getPage();//lay trang dang dung
Integer getOffset();
Integer getLimit();
Sorter getSorter();
}
