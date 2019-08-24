/**
 * Copyright (C)
 * FileName: MyDate
 * Author:   cp
 * Date:     2019/8/24 11:34
 * Description: 我的日期类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package org.cp.collection.test;

/**
 * 〈一句话功能简述〉<br> 
 * 〈我的日期类〉
 *
 * @author cp
 * @create 2019/8/24
 * @since 1.0.0
 */
public class MyDate {

    private Integer year;
    private Integer month;
    private Integer day;

    public MyDate() {
    }

    public MyDate(Integer year, Integer month, Integer day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}
