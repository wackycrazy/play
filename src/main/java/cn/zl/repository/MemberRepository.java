/**
 * 
 */
package cn.zl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.zl.entity.Member;
/**
 * @author zhulin
 *
 * @mail wackycrazy@163.com
 *
 * @creation 2018年8月12日
 */
public interface MemberRepository extends JpaRepository<Member, String>, JpaSpecificationExecutor<Member> {

}
