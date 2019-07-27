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
@Table ( name ="jurisdiction" )
public class Jurisdiction  implements Serializable {


	/**
	 * 权限编号
	 */
   	@Column(name = "jurId" )
	private Integer jurId;

	/**
	 * 权限名
	 */
   	@Column(name = "jurName" )
	private String jurName;

}
