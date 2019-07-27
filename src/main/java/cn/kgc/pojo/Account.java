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
	 * 用户上级编号
	 */
   	@Column(name = "accountLead" )
	private Integer accountLead;

	/**
	 * 权限编号
	 */
   	@Column(name = "jur" )
	private Integer jur;

}
