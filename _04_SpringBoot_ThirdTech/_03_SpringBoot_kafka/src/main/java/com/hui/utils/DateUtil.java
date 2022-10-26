package com.hui.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateUtil {
    /**
     * 获取当前时间, 返回时间戳
     * @return long
     */
    public static Long getNowTimestamp(){
        Date date = new Date();
        return  date.getTime();
    }

    /**
     * 获取当前的格式化日期
     * @return yyyy-MM-dd
     */
    public static String getNowFormatDate() {
        Long nowTime = getNowTimestamp();

        return DateUtil.getFormatDate(nowTime);
    }

    /**
     * 根据输入时间戳获取格式日期+时间字符串-"yyyy-MM-dd HH:mm:ss"
     * @param timestamp long, 时间戳
     * @return 格式化日期和时间-yyyy-MM-dd HH:mm:ss
     */
    public static String getFormatDateTime(Long timestamp){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return simpleDateFormat.format(timestamp);
    }

    /**
     * 根据输入时间戳获取格式日期字符串-"yyyy-MM-dd"
     * @param timestamp long, 时间戳
     * @return String 返回格式化日期
     */
    public static String getFormatDate(Long timestamp){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        return simpleDateFormat.format(timestamp);
    }

    /**
     * 根据输入时间戳获取格式时间字符串-"HH:mm:ss"
     * @param timestamp long, 时间戳
     * @return string, 格式化时间
     */
    public static String getFormatTime(Long timestamp){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");

        return simpleDateFormat.format(timestamp);
    }

    /**
     * 根据输入的格式化日期时间, 获取对应的时间戳
     * @param formatDate String, 格式化日期, 必须为"yyyy-MM-dd HH:mm:ss"格式
     * @return long, 时间戳
     */
    public static Long getTimestamp(String formatDate){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long timestamp = null;
        try {
            timestamp = simpleDateFormat.parse(formatDate).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return timestamp;
    }

    /**
     * 根据输入的天数, 获取每一天的格式化日期, 返回String的列表
     * @param pastDays 要获取的过去的天数
     * @return 格式化日期的列表
     */
    public static List<String> getPastFormatDate(int pastDays) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long nowTimestamp = getNowTimestamp();
        ArrayList<String> datesList = new ArrayList<>();
        long oneDayMs = (long) 24 * 60 * 60 * 1000;

        for (int i = 0; i < pastDays; i++){
            String formatDate = simpleDateFormat.format(nowTimestamp - (i * oneDayMs));
            datesList.add(formatDate);
        }

        return datesList;
    }
}
