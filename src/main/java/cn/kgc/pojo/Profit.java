package cn.kgc.pojo;

import java.util.Date;

/**
 * @author LZY
 * @date 2019/8/15 20:06
 */
public class Profit {
    private int accountId;
    private Double Yesterday;
    private String YesterdayTime;
    private Double Today;


    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public Double getYesterday() {
        return Yesterday;
    }

    public void setYesterday(Double yesterday) {
        Yesterday = yesterday;
    }

    public String getYesterdayTime() {
        return YesterdayTime;
    }

    public void setYesterdayTime(String yesterdayTime) {
        YesterdayTime = yesterdayTime;
    }

    public Double getToday() {
        return Today;
    }

    public void setToday(Double today) {
        Today = today;
    }
}
