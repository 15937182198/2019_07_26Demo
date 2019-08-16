package cn.kgc.pojo;

import java.util.Date;

/**
 * @author LZY
 * @date 2019/8/15 20:06
 */
public class Profit {
    private int accountId;
    private double Yesterday;
    private long YesterdayTime;
    private double Today;


    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public double getYesterday() {
        return Yesterday;
    }

    public void setYesterday(double yesterday) {
        Yesterday = yesterday;
    }

    public long getYesterdayTime() {
        return YesterdayTime;
    }

    public void setYesterdayTime(long yesterdayTime) {
        YesterdayTime = yesterdayTime;
    }

    public double getToday() {
        return Today;
    }

    public void setToday(double today) {
        Today = today;
    }

    @Override
    public String toString() {
        return "Profit{" +
                "accountId=" + accountId +
                ", Yesterday=" + Yesterday +
                ", YesterdayTime=" + YesterdayTime +
                ", Today=" + Today +
                '}';
    }
}
