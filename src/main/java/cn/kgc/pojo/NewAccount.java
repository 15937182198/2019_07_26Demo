package cn.kgc.pojo;

/**
 * 账户包装类
 */
public class NewAccount {
    //用户id
    private Integer accountId;
    //用户名
    private String accountName;
    //用户创建时间
    private String accountCreateDate;
    //用户推荐人
    private String referrer;
    //节点积分
    private Double accountMoney;
    //用户上级
    private String accountLead;
    //用户下级1
    private String junior1;
    //用户下级2
    private String junior2;
    //可用积分
    private double usableMoney;

    //用户名
    private String userName;

    //用户手机号
    private String userPhone;

    //用户收货地址
    private String site;

    //冻结积分
    private Double freezeMoney;



    public Double getUsableMoney() {
        return usableMoney;
    }

    public void setUsableMoney(Double usableMoney) {
        this.usableMoney = usableMoney;
    }

    public Double getFreezeMoney() {
        return freezeMoney;
    }

    public void setFreezeMoney(Double freezeMoney) {
        this.freezeMoney = freezeMoney;
    }

    public String getAccountLead() {
        return accountLead;
    }

    public void setAccountLead(String accountLead) {
        this.accountLead = accountLead;
    }

    public String getJunior1() {
        return junior1;
    }

    public void setJunior1(String junior1) {
        this.junior1 = junior1;
    }

    public String getJunior2() {
        return junior2;
    }

    public void setJunior2(String junior2) {
        this.junior2 = junior2;
    }

    public Double getAccountMoney() {
        return accountMoney;
    }

    public void setAccountMoney(Double accountMoney) {
        this.accountMoney = accountMoney;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountCreateDate() {
        return accountCreateDate;
    }

    public void setAccountCreateDate(String accountCreateDate) {
        this.accountCreateDate = accountCreateDate;
    }

    public String getReferrer() {
        return referrer;
    }

    public void setReferrer(String referrer) {
        this.referrer = referrer;
    }

    public void setUsableMoney(double usableMoney) {
        this.usableMoney = usableMoney;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    @Override
    public String toString() {
        return "NewAccount{" +
                "accountId=" + accountId +
                ", accountName='" + accountName + '\'' +
                ", accountCreateDate='" + accountCreateDate + '\'' +
                ", referrer='" + referrer + '\'' +
                ", accountMoney=" + accountMoney +
                ", accountLead='" + accountLead + '\'' +
                ", junior1='" + junior1 + '\'' +
                ", junior2='" + junior2 + '\'' +
                ", usableMoney=" + usableMoney +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", site='" + site + '\'' +
                ", freezeMoney=" + freezeMoney +
                '}';
    }
}
