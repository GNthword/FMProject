package com.milog.fm.fmproject;

import com.milog.fm.annotation.FM;

/**
 * Created by miloway on 2018/10/18.
 */

public class MyBean {

    @FM("fm_int")
    public int i;

    @FM("fm_bool")
    public boolean b;

    @FM("fm_str")
    public String string;

    @FM("fm_int_arr")
    public int[] ints;

    @FM("fm_str_arr")
    public String[] strings;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("bool").append(b).append("\n")
                .append("int").append(i).append("\n")
                .append("str").append(string).append("\n");
        if (ints != null) {
            sb.append("ints");
            for (int i : ints) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }

        if (strings != null) {
            sb.append("strings");
            for (String string : strings) {
                sb.append(string).append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
