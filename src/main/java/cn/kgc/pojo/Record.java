package cn.kgc.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Repository;


@Repository
@Setter
@Getter
@ToString
@Entity
@Table ( name ="record" )
public class Record  implements Serializable {


	/**
	 * 消费记录id
	 */
   	@Column(name = "recordId" )
	private Integer recordId;

	/**
	 * 所属账户
	 */
   	@Column(name = "accountId" )
	private Integer accountId;

	/**
	 * 支出
	 */
   	@Column(name = "expend" )
	private Double expend;

	/**
	 * 收入
	 */
   	@Column(name = "income" )
	private Double income;

	public Integer getRecordId() {
		return recordId;
	}

	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Double getExpend() {
		return expend;
	}

	public void setExpend(Double expend) {
		this.expend = expend;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}
}
