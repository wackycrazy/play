/**
 * 
 */
package cn.zl.test;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import cn.zl.dto.ExecuteDTO;
import cn.zl.dto.PageQueryParamDTO;
import cn.zl.dto.PageResultDTO;
import cn.zl.entity.Member;

/**
 * 单元测试
 * @author zhulin
 *
 * @mail wackycrazy@163.com
 *
 * @creation 2018年8月12日
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MemberTest {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void test() {
		String baseURL = "http://localhost:"+port;
		
		String name = "祝林";
		//添加测试
		Member entity = new Member();
		entity.name = name;
		entity.sex = 1;
		ExecuteDTO execute = restTemplate.postForObject(baseURL+"/member/save", entity, ExecuteDTO.class);
		assertThat(execute).isNotNull();
		assertThat(execute.isSuccess()).isTrue();
		assertThat(execute.getValue()).isNotNull();
		
		/*//测试获取
		entity = restTemplate.postForObject(baseURL+"/member/get", execute.getValue(), Member.class);
		assertThat(entity).isNotNull();
		assertThat(entity.id).isNotNull();
		assertThat(entity.name).isEqualTo(name);
		
		//测试修改
		entity.name = "lin";
		execute = this.restTemplate.postForObject(baseURL+"/member/save", entity, ExecuteDTO.class);
		assertThat(execute).isNotNull();
		assertThat(execute.isSuccess()).isTrue();
		
		//测试修改成功
		entity = this.restTemplate.postForObject(baseURL+"/member/get", execute.getValue(), Member.class);
		assertThat(entity).isNotNull();
		assertThat(entity.id).isNotNull();
		assertThat(entity.name).isNotEqualTo(name);*/
		
		//测试分页查询
		PageQueryParamDTO param = new PageQueryParamDTO(1, 20, null);
		PageResultDTO pageResult = this.restTemplate.postForObject(baseURL+"/member/loadPage", param, PageResultDTO.class);
		assertThat(pageResult).isNotNull();
		assertThat(pageResult.getRows()).isNotEmpty();
		assertThat(pageResult.getTotal()).isGreaterThan(0);
		
		//测试删除
		execute = this.restTemplate.postForObject(baseURL+"/member/remove"	, entity.id, ExecuteDTO.class);
		assertThat(execute).isNotNull();
		assertThat(execute.isSuccess()).isTrue();
		
		
		//测试删除成功
		entity = this.restTemplate.postForObject(baseURL+"/member/get", execute.getValue(), Member.class);
		assertThat(entity).isNull();
	}
}
