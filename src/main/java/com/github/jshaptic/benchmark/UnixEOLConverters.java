package com.github.jshaptic.benchmark;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class UnixEOLConverters
{
	private static final Pattern p1 = Pattern.compile("\r\n", Pattern.LITERAL);
	private static final Pattern p2 = Pattern.compile("\r", Pattern.LITERAL);
	
	public static String normalizeUsingJDKStringReplace(String str)
	{
		return str.replace("\r\n", "\n").replace("\r", "\n");
	}
	
	public static String normalizeUsingJDKStringReplaceChars(String str)
	{
		return str.replace("\r\n", "\n").replace('\r', '\n');
	}
	
	public static String normalizeUsingJDKStringReplaceAll(String str)
	{
		return str.replaceAll("\r\n", "\n").replaceAll("\r", "\n");
	}
	
	public static String normalizeUsingJDKCompiledPatternReplaceAll(String str)
	{
		return p2.matcher(p1.matcher(str).replaceAll("\n")).replaceAll("\n");
	}
	
	public static String normalizeUsingCommonsStringUtilsReplace(String str)
	{
		return StringUtils.replace(StringUtils.replace(str, "\r\n", "\n"), "\r", "\n");
	}
	
	public static String normalizeUsingCommonsStringUtilsReplaceChars(String str)
	{
		return StringUtils.replaceChars(StringUtils.replace(str, "\r\n", "\n"), '\r', '\n');
	}
	
	public static String normalizeUsingCommonsStringUtilsReplaceEach(String str)
	{
		return StringUtils.replaceEach(str, new String[]{"\r\n", "\r"}, new String[]{"\n", "\n"});
	}
}