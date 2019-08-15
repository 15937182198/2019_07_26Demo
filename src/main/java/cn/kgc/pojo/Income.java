package cn.kgc.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Repository;

/**
 * @Description  
 * @Author  MaJinZhong
 * @Date 2019/08/15 18:31 
 */

@Repository
@Setter
@Getter
@ToString
@Entity
@Table ( name ="income" )
public class Income  implements Serializable {


	/**
	 * 收益编号
	 */
   	@Column(name = "incomeId" )
	private Integer incomeId;

	/**
	 * 前日收益
	 */
   	@Column(name = "oldIncome" )
	private Double oldIncome;

	/**
	 * 昨日收入
	 */
   	@Column(name = "income" )
	private Double income;

	/**
	 * 所属账户编号
	 */
   	@Column(name = "accountId" )
	private Integer accountId;

}
