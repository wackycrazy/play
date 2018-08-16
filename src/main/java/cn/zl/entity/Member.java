/**
 * 
 */
package cn.zl.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * @author zhulin
 *
 * @mail wackycrazy@163.com
 *
 * @creation 2018年8月12日
 */
@Entity
@Table(name = "t_member")
public class Member {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "id", length = 36)
	public String id;
	
	/**
	 * 注册日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@Temporal(TemporalType.DATE)
	@Column(name = "date")
	public Date date;
	
	/**
	 * 姓名
	 */
	@Column(name = "name", length = 50)
	public String name;
	
	/**
	 * 性别
	 */
	@Column(name = "sex")
	public Integer sex;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}
}
