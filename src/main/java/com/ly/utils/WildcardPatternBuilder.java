package com.ly.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class WildcardPatternBuilder {
	static Pattern starPtn = Pattern.compile("\\*");
	Set<String> rules = new HashSet();
	List<String> ptns = new ArrayList();

	public Pattern getPattern() {
		StringBuilder sb = new StringBuilder();
		int size = this.ptns.size();
		if (size > 0) {
			sb.append("(").append((String) this.ptns.get(0)).append(")");
		}
		for (int i = 1; i < size; ++i) {
			sb.append("|(").append((String) this.ptns.get(i)).append(")");
		}
		return Pattern.compile(sb.toString());
	}

	public void add(String rule) {
		if ((StringUtils.isNotBlank(rule)) && (this.rules.add(rule))) {
			String[] stars = starPtn.split(rule, -1);
			if (stars.length > 1) {
				StringBuilder regex = new StringBuilder();
				for (int i = 0; i < stars.length - 1; ++i) {
					if ("".equals(stars[i]))
						if ("".equals(stars[(i + 1)])) {
							regex.append(".*");
							++i;
						} else {
							regex.append("[^/]*");
						}
					else {
						regex.append(Pattern.quote(stars[i]));
					}
				}
				if ("".equals(stars[(stars.length - 1)]))
					regex.append("[^/]*");
				else {
					regex.append(Pattern.quote(stars[(stars.length - 1)]));
				}
				this.ptns.add(regex.toString());
			} else {
				this.ptns.add(Pattern.quote(stars[0]));
			}
		}
	}

	public static Pattern build(String rules) {
		   Pattern p = null;
	       if (StringUtils.isNotBlank(rules)) {
	         String[] u = rules.split("[,; ]");
	         WildcardPatternBuilder b = new WildcardPatternBuilder();
	         
	         for (int i = 0; i < u.length; i++) {
	        	  String rule =  u[i];
	        	  b.add(rule);
			 }
	         
	         p = b.getPattern();
	     }
	       return p;
	   }
}
