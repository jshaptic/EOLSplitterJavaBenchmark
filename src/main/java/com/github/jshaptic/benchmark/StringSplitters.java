package com.github.jshaptic.benchmark;

import java.util.stream.StreamSupport;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringTokenizer;

import com.google.common.base.Splitter;

// Collection of various splitters methods. Some known methods were not used because doesn't have required features or were depricated.
// Following methods and classes were escluded from this collection
// 1) java.util.StringTokenizer - considered as legacy class, ignores empty tokens
// 2) org.apache.commons.lang3.StringUtils.split - adjacent separators are treated as one separator
public class StringSplitters
{
	public static String[] splitUsingJDKStringSplit(String str, String delim)
	{
		return str.split(delim, -1);
	}
	
	public static String[] splitUsingCommonsStringUtilsSplitPreserveAllTokens(String str, String delim)
	{
		if (str.length() == 0) return new String[]{""};
		return StringUtils.splitPreserveAllTokens(str, delim);
	}
	
	public static String[] splitUsingCommonsStringUtilsSplitPreserveAllTokens(String str, char delim)
	{
		if (str.length() == 0) return new String[]{""};
		return StringUtils.splitPreserveAllTokens(str, delim);
	}
	
	public static String[] splitUsingCommonsStringUtilsSplitByWholeSeparatorPreserveAllTokens(String str, String delim)
	{
		if (str.length() == 0) return new String[]{""};
		return StringUtils.splitByWholeSeparatorPreserveAllTokens(str, delim);
	}
	
	public static String[] splitUsingCommonsStringTokenizer(String str, String delim)
	{
		if (str.length() == 0) return new String[]{""};
		return new StringTokenizer(str, delim).setIgnoreEmptyTokens(false).getTokenArray();
	}
	
	public static String[] splitUsingCommonsStringTokenizer(String str, char delim)
	{
		if (str.length() == 0) return new String[]{""};
		return new StringTokenizer(str, delim).setIgnoreEmptyTokens(false).getTokenArray();
	}
	
	public static String[] splitUsingGuavaSplitter(String str, String delim)
	{
		return StreamSupport.stream(Splitter.on(delim).split(str).spliterator(), false).toArray(String[]::new);
	}
	
	public static String[] splitUsingGuavaSplitter(String str, char delim)
	{
		return StreamSupport.stream(Splitter.on(delim).split(str).spliterator(), false).toArray(String[]::new);
	}
}