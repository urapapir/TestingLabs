package com.spbstu.epam.Lab3.enums;

public enum dates_data {
   values1(new Integer[]{0, 100}),values2(new Integer[]{0, 0}),
    values3(new Integer[]{100, 100}),
    values4(new Integer[]{30, 70});

    public Integer[] values;

    dates_data(Integer[] i) {
        values = i;
    }
}
