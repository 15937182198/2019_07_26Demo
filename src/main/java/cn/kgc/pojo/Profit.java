package cn.kgc.pojo;

import java.util.Date;

/**
 * @author LZY
 * @date 2019/8/15 20:06
 */
public class Profit {
    private int accountId;
    private int Yesterday;
    private long YesterdayTime;
    private int Today;

    public Profit() {
    }

    public Profit(int accountId, int yesterday, long yesterdayTime, int today) {
        this.accountId = accountId;
        Yesterday = yesterday;
        YesterdayTime = yesterdayTime;
        Today = today;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getYesterday() {
        return Yesterday;
    }

    public void setYesterday(int yesterday) {
        Yesterday = yesterday;
    }

    public long getYesterdayTime() {
        return YesterdayTime;
    }

    public void setYesterdayTime(long yesterdayTime) {
        YesterdayTime = yesterdayTime;
    }

    public int getToday() {
        return Today;
    }

    public void setToday(int today) {
        Today = today;
    }
}
