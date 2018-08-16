/**
 * 
 */
package cn.zl.control;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.zl.dto.ExecuteDTO;
import cn.zl.dto.PageQueryParamDTO;
import cn.zl.dto.PageResultDTO;
import cn.zl.entity.Member;
import cn.zl.repository.MemberRepository;

/**
 * @author zhulin
 *
 * @mail wackycrazy@163.com
 *
 * @creation 2018年8月12日
 */
@RestController
@RequestMapping("member")
public class MemberController {

	@Autowired
	private MemberRepository repository;

	@GetMapping("get/{id}")
	public Member get(@PathVariable String id) {
		return repository.findById(id).get();
	}

	@PostMapping("save")
	public ExecuteDTO save(@RequestBody Member entity) {
		if (entity.date == null) {
			entity.date = new Date();
		}
		repository.save(entity);
		return new ExecuteDTO(true, "保存成功", entity.id);
	}

	@PostMapping("loadPage")
	public PageResultDTO loadPage(@RequestBody PageQueryParamDTO param) {

		// 动态查询条件
		Specification<Member> spac = (root, query, cb) -> {
			if (param.getQuery() != null) {
				// 筛选会员姓名
				query.where(cb.equal(root.get("name"), param.getQuery().toString()));
			}
			return null;
		};
		Pageable pageable = new PageRequest(param.getPage() - 1, param.getSize());
		Page<Member> pageResult = repository.findAll(spac, pageable);

		// 返回分页数据
		return new PageResultDTO(pageResult.getTotalElements(), pageResult.getContent());
	}

	@GetMapping("remove/{id}")
	public ExecuteDTO remove(@PathVariable String id) {
		repository.deleteById(id);
		return new ExecuteDTO(true, "删除成功", id);
	}

}
