package cn.kgc.pojo;

public class NewDeal {

    private Deal deal;
    private String accountName;

    public Deal getDeal() {
        return deal;
    }

    public void setDeal(Deal deal) {
        this.deal = deal;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Override
    public String toString() {
        return "NewDeal{" +
                "deal=" + deal +
                ", accountName='" + accountName + '\'' +
                '}';
    }
}
