package com.spbstu.epam.Lab3.enums;


import lombok.Getter;

//@AllArgsConstructor
@Getter
public enum diffElPage_data {
    checkBox1 ("Water"), checkBox2 ("Earth"), checkBox3 ("Wind"), checkBox4 ("Fire"),
    radio1("Gold"), radio2("Silver"), radio3("Bronze"), radio4("Selen"),
    dropColor1("Red"), dropColor2("Green"), dropColor3("Blue"), dropColor4("Yellow");
    //SERVICES DEFINED IN Lab2.url_data!!!
    public String Arr;

    diffElPage_data(String strings) {
        Arr = strings;
    }
}
