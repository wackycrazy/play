/**
 * 
 */
package cn.zl.dto;

import java.util.List;

/**
 * @author zhulin
 *
 * @mail wackycrazy@163.com
 *
 * @creation 2018年8月12日
 */
public class PageResultDTO {
	private long total;

	private List<?> rows;

	public PageResultDTO() {
    }

	public PageResultDTO(long total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}
}
