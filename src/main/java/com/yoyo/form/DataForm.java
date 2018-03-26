package com.yoyo.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by fbin on 2018/3/25.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataForm<T> {

    protected int pageNumber = 1;

    protected int pageSize = 15;

    protected int total = 0;

    protected List<T> pageRecords;

}
