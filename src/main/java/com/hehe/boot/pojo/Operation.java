package com.hehe.boot.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Data
@AllArgsConstructor //有参构造器
@NoArgsConstructor  //无参构造器
@TableName("operations") // 对应数据库表名
public class Operation {
    private Long          id;
    private String        name;
    private String        kind;
    private LocalDateTime timestamp;

    public static String getTimeInterval(LocalDateTime timestamp) {
        LocalDateTime now = LocalDateTime.now();

        if (timestamp.isAfter(now)) {
            throw new IllegalArgumentException("Timestamp is in the future");
        }

        // 计算各个时间单位之间的差异
        long years = ChronoUnit.YEARS.between(timestamp, now);
        long months = ChronoUnit.MONTHS.between(timestamp, now);
        long days = ChronoUnit.DAYS.between(timestamp, now);
        long hours = ChronoUnit.HOURS.between(timestamp, now);
        long minutes = ChronoUnit.MINUTES.between(timestamp, now);
        long seconds = ChronoUnit.SECONDS.between(timestamp, now);

        // 返回最大的有效时间单位
        if (years > 0) {
            return years + " year" + (years > 1 ? "s" : "");
        } else if (months > 0) {
            return months + " month" + (months > 1 ? "s" : "");
        } else if (days > 0) {
            return days + " day" + (days > 1 ? "s" : "");
        } else if (hours > 0) {
            return hours + " hour" + (hours > 1 ? "s" : "");
        } else if (minutes > 0) {
            return minutes + " minute" + (minutes > 1 ? "s" : "");
        } else {
            return seconds + " second" + (seconds > 1 ? "s" : "");
        }
    }
}

