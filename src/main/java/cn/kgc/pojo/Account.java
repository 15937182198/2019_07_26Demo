package cn.kgc.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Repository;
import java.util.Date;

/**
 * @Description  
 * @Author  MaJinZhong
 * @Date 2019/08/03 15:35 
 */

@Repository
@Setter
@Getter
@ToString
@Entity
@Table ( name ="account" )
public class Account  implements Serializable {


	/**
	 * 账户编号编号
	 */
   	@Column(name = "accountId" )
	private Integer accountId;

	/**
	 * 用户账号
	 */
   	@Column(name = "accountName" )
	private String accountName;

	/**
	 * 密码
	 */
   	@Column(name = "accountPassword" )
	private String accountPassword;

	/**
	 * 积分
	 */
   	@Column(name = "accountMoney" )
	private Double accountMoney;

	/**
	 * 账户创建时间
	 */
   	@Column(name = "accountCreateDate" )
	private Date accountCreateDate;

	/**
	 * 推荐人id
	 */
   	@Column(name = "referrer" )
	private Integer referrer;

	/**
	 * 用户上级编号
	 */
   	@Column(name = "accountLead" )
	private Integer accountLead;

	/**
	 * 权限编号
	 */
   	@Column(name = "jur" )
	private Integer jur;

	/**
	 * 该用户在金字塔的坐标
	 */
   	@Column(name = "accountJNumber" )
	private Integer accountJNumber;


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

	public String getAccountPassword() {
		return accountPassword;
	}

	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}

	public Double getAccountMoney() {
		return accountMoney;
	}

	public void setAccountMoney(Double accountMoney) {
		this.accountMoney = accountMoney;
	}

	public Date getAccountCreateDate() {
		return accountCreateDate;
	}

	public void setAccountCreateDate(Date accountCreateDate) {
		this.accountCreateDate = accountCreateDate;
	}

	public Integer getReferrer() {
		return referrer;
	}

	public void setReferrer(Integer referrer) {
		this.referrer = referrer;
	}

	public Integer getAccountLead() {
		return accountLead;
	}

	public void setAccountLead(Integer accountLead) {
		this.accountLead = accountLead;
	}

	public Integer getJur() {
		return jur;
	}

	public void setJur(Integer jur) {
		this.jur = jur;
	}

	public Integer getAccountJNumber() {
		return accountJNumber;
	}

	public void setAccountJNumber(Integer accountJNumber) {
		this.accountJNumber = accountJNumber;
	}
}
