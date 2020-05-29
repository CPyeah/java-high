package org.cp.javadate;

import org.junit.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 *  1    2   3    4   5    6
 * 白1，白2，夜， 晚， 休1，休2
 * 排班计算工具
 * create by CP on 2019/8/9 0009.
 * //16 3
 */
public class WorkDay {

    private String init = "2020-05-05";// 初始化日期

    private int initSort = 3;// 初始化 工作 序列号 jingjing
//    private int initSort = 1;// 初始化 工作 序列号 lulu

    private String target = "2020-05-06";// 目标日期

    private int showNextDay = 120;//显示目标及接下来的7天的工作安排

    static Map<LocalDate, String> specialDay = new HashMap<>();
    static {
        specialDay.put(LocalDate.parse("2019-12-15"), "\uD83C\uDF82");//蛋糕
        specialDay.put(LocalDate.parse("2019-12-22"), "❄");//雪花  冬至
        specialDay.put(LocalDate.parse("2019-12-24"), "\uD83C\uDF4E");//苹果
        specialDay.put(LocalDate.parse("2019-12-25"), "\uD83C\uDF84");//圣诞树
        specialDay.put(LocalDate.parse("2020-01-01"), "\uD83E\uDD5A");//鸡蛋
        specialDay.put(LocalDate.parse("2020-01-21"), "\uD83D\uDCAF");//100
        specialDay.put(LocalDate.parse("2020-01-24"), "\uD83C\uDF19");//月亮
        specialDay.put(LocalDate.parse("2020-01-25"), "☀");//太阳
        specialDay.put(LocalDate.parse("2020-02-14"), "❤");//爱心
    }

    /**
     *  2019-08-07  为 休1
     *  2019-08-09 是什么班？
     */
    @Test
    public void workDayScheduler() {
        Map workMap = getWorkMap();
        int durationDays = getDurationDays();
        getTargetWorkDayName(workMap, durationDays);
    }

    /**
     * 获取目标日期的工作安排情况
     * @param workMap
     * @param days
     */
    private void getTargetWorkDayName(Map workMap, int days) {
        String initWorkName = (String) workMap.get(initSort);
        System.out.println("初始情况是 " + init + "是 " + initWorkName);
        int loop = workMap.size();
        int mod = days % loop;
        int targetSort = initSort + mod;
        targetSort = targetSort % loop;
        targetSort = targetSort == 0 ? loop : targetSort;
        System.out.println("那么 " + target +"（"+LocalDate.parse(target).getDayOfWeek()+ "）是 " + workMap.get(targetSort));
        showNextDays(workMap, targetSort);
    }

    /**
     * 计算展示接下来的几天的工作安排情况
     * @param workMap
     * @param targetSort
     */
    private void showNextDays(Map workMap, int targetSort) {
        System.out.println("    接下来的 "+showNextDay+" 天的情况是： ");
        LocalDate targetDate = LocalDate.parse(target);
        int loop = workMap.size();
        while (showNextDay > 0) {
            showNextDay--;
            targetDate = targetDate.plusDays(1);
            targetSort++;
            int index = targetSort % loop == 0 ? loop :targetSort % loop;
            String workName = (String) workMap.get(index);
            if (specialDay.get(targetDate)!=null) {
                System.out.println("    "+ specialDay.get(targetDate) + targetDate + "（" + targetDate.getDayOfWeek() + "）是 " + workName);
            } else {
                System.out.println("    " + targetDate + "（" + targetDate.getDayOfWeek() + "）是 " + workName);
            }
        }
    }

    /**
     * 获取间隔天数
     * @return
     */
    private int getDurationDays() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime initDate = LocalDateTime.parse(init+" 09:00", df);
        LocalDateTime targetDate = LocalDateTime.parse(target+" 09:00", df);
        Duration d = Duration.between(initDate, targetDate);
        int days = (int) d.toDays();
        return days;
    }

    /**
     * 初始化 排班名称及索引
     * @return
     */
    private Map getWorkMap() {
        Map workMap = new HashMap();
        workMap.put(1, "白1");
        workMap.put(2, "白2");
        workMap.put(3, "夜");
        workMap.put(4, "晚");
        workMap.put(5, "休1");
        workMap.put(6, "休2");
        return workMap;
    }



}
