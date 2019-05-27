package com.github.jshaptic.benchmark.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.jshaptic.benchmark.UnixEOLConverters;

public class ConvertToUnixEOLTests extends Assert
{
	private static final Map<String, String> data = new HashMap<String, String>();

	@BeforeClass
	public static void setup()
	{
		data.put("", "");
		data.put("abc", "abc");
		data.put("\n", "\n");
		data.put("\r", "\n");
		data.put("\r\n", "\n");
		data.put("abc\n", "abc\n");
		data.put("abc\r", "abc\n");
		data.put("abc\r\n", "abc\n");
		data.put("\nabc", "\nabc");
		data.put("\rabc", "\nabc");
		data.put("\r\nabc", "\nabc");
		data.put("\r\r\r\n\r\n\n\n\r", "\n\n\n\n\n\n\n");
		data.put("abc\rabc\r\nabc\nabc", "abc\nabc\nabc\nabc");
	}
	
	@Test
	public void testJDKStringReplace()
	{
		for (String sample : data.keySet())
		{
			assertEquals(data.get(sample), UnixEOLConverters.normalizeUsingJDKStringReplace(sample));
		}
	}
	
	@Test
	public void testJDKStringReplaceChars()
	{
		for (String sample : data.keySet())
		{
			assertEquals(data.get(sample), UnixEOLConverters.normalizeUsingJDKStringReplaceChars(sample));
		}
	}
	
	@Test
	public void testJDKStringReplaceAll()
	{
		for (String sample : data.keySet())
		{
			assertEquals(data.get(sample), UnixEOLConverters.normalizeUsingJDKStringReplaceAll(sample));
		}
	}
	
	@Test
	public void testJDKCompiledPatternReplaceAll()
	{
		for (String sample : data.keySet())
		{
			assertEquals(data.get(sample), UnixEOLConverters.normalizeUsingJDKCompiledPatternReplaceAll(sample));
		}
	}
	
	@Test
	public void testCommonsStringUtilsReplace()
	{
		for (String sample : data.keySet())
		{
			assertEquals(data.get(sample), UnixEOLConverters.normalizeUsingCommonsStringUtilsReplace(sample));
		}
	}
	
	@Test
	public void testCommonsStringUtilsReplaceChars()
	{
		for (String sample : data.keySet())
		{
			assertEquals(data.get(sample), UnixEOLConverters.normalizeUsingCommonsStringUtilsReplaceChars(sample));
		}
	}
	
	@Test
	public void testCommonsStringUtilsReplaceEach()
	{
		for (String sample : data.keySet())
		{
			assertEquals(data.get(sample), UnixEOLConverters.normalizeUsingCommonsStringUtilsReplaceEach(sample));
		}
	}
}