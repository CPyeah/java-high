package org.cp.enumeration;

import java.util.Arrays;

/**
 * create by CP on 2019/8/14 0014.
 */
public enum Season {

    SPRING("春天", "春暖花开", "3,4,5"),
    SUMMER("夏天", "夏日炎炎", "6,7,8"),
    AUTUMN("秋天", "秋高气爽", "9,10,11"),
    WINTER("冬天", "冰天雪地", "12,1,2");

    private final String name;
    private final String desc;
    private final String[] times;

    Season(String name, String desc, String months) {
        this.name = name;
        this.desc = desc;
        this.times = months.split(",");
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String[] getTimes() {
        return times;
    }

    public static Season getSeasonByMonth(String m) {
        Season[] seasons = Season.values();
        for (Season s : seasons) {
            String[] times = s.getTimes();
            boolean contains = Arrays.asList(times).contains(m);
            if (contains) return s;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
