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



@Repository
@Setter
@Getter
@ToString
@Entity
@Table ( name ="deal" )
public class Deal  implements Serializable {


	/**
	 * 交易编号
	 */
   	@Column(name = "dealId" )
	private Integer dealId;

	/**
	 * 收入/支出
	 */
   	@Column(name = "dealIncome" )
	private Double dealIncome;

	/**
	 * 交易时间
	 */
   	@Column(name = "dealDate" )
	private String dealDate;

	/**
	 * 所属账户
	 */
   	@Column(name = "accountId" )
	private Integer accountId;

	public Integer getDealId() {
		return dealId;
	}

	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	public Double getDealIncome() {
		return dealIncome;
	}

	public void setDealIncome(Double dealIncome) {
		this.dealIncome = dealIncome;
	}

	public String getDealDate() {
		return dealDate;
	}

	public void setDealDate(String dealDate) {
		this.dealDate = dealDate;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
}
