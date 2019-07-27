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
	private Date dealDate;

	/**
	 * 所属账户
	 */
   	@Column(name = "accountId" )
	private Integer accountId;

}
