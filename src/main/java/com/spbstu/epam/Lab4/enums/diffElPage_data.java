package com.spbstu.epam.Lab4.enums;

public enum diffElPage_data {

    CHECKBOX_NUMBER(4),
    DROPDOWN_NUMBER(4),

    checkbox1("Water"), checkbox2("Earth"), checkbox3("Wind"), checkbox4("Fire"),
    radio1("Gold"), radio2("Silver"), radio3("Bronze"), radio4("Selen"),
    dropdown1("Red"), dropdown2("Green"), dropdown3("Blue"), dropdown4("Yellow");

    public String strValue;
    public Integer intValue;

    diffElPage_data(String str) {
        strValue = str;
    }

    diffElPage_data(Integer i) {
        intValue = i;
    }
}
