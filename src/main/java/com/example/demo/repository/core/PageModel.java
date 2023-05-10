package com.example.demo.repository.core;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.example.demo.repository.core.Sort.SqlOrderByProcessor;
import com.example.demo.utils.CoreUtils;

import org.springframework.util.StringUtils;

import lombok.EqualsAndHashCode;
import lombok.Data;




@Data
@EqualsAndHashCode(callSuper = false)
public class PageModel {

	private Integer pageNumber;
	private Integer pageSize;
	private List<Sort> sorts;

	public String generateSqlOrderBy(String alias) {
		return generateSqlOrderBy(alias, null, new Sort.DefaultSqlOrderByProcessor());
	}
	
	public String generateSqlOrderBy(String alias, Sort defaultSort) {
		return generateSqlOrderBy(alias, defaultSort, new Sort.DefaultSqlOrderByProcessor());
	}
	
	
	public String generateSqlOrderBy(String alias, Sort defaultSort, SqlOrderByProcessor processor) {
		Pattern r = Pattern.compile("\\w+");

		List<String> s = new ArrayList<String>();

		if (CoreUtils.isNotEmpty(this.sorts)) {
			for (Sort sort : this.sorts) {
				if(r.matcher(sort.getSort()).matches()) {
					String t = processor.process(alias, sort);
					if(CoreUtils.isNotEmpty(t)) {
						s.add(t);
					}
				}
			}
		}

		if (CoreUtils.isNotNull(defaultSort)) {
			s.add(processor.process(alias, defaultSort));
		}

		if (CoreUtils.isNotEmpty(s)) {
			return " ORDER BY " + StringUtils.arrayToDelimitedString(s.toArray(), ",");
		}

		return "";
	}

}
