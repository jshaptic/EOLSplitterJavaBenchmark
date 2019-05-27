package com.github.jshaptic.benchmark.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.jshaptic.benchmark.EOLSplitters;

public class EOLSplitTests extends Assert
{
	private static final Map<String, String[]> data = new HashMap<String, String[]>();

	@BeforeClass
	public static void setup()
	{
		data.put("", new String[]{""});
		data.put("abc", new String[]{"abc"});
		data.put("\n", new String[]{"", ""});
		data.put("\r", new String[]{"", ""});
		data.put("\r\n", new String[]{"", ""});
		data.put("abc\n", new String[]{"abc", ""});
		data.put("abc\r", new String[]{"abc", ""});
		data.put("abc\r\n", new String[]{"abc", ""});
		data.put("\nabc", new String[]{"", "abc"});
		data.put("\rabc", new String[]{"", "abc"});
		data.put("\r\nabc", new String[]{"", "abc"});
		data.put("\r\r\r\n\r\n\n\n\r", new String[]{"", "", "", "", "", "", "", ""});
		data.put("abc\rabc\r\nabc\nabc", new String[]{"abc", "abc", "abc", "abc"});
	}
	
	@Test
	public void testCustomLogicSplit1()
	{
		for (String sample : data.keySet())
		{
			assertArrayEquals(data.get(sample), EOLSplitters.splitUsingCustomLogic1(sample));
		}
	}
	
	@Test
	public void testCustomLogicSplit2()
	{
		for (String sample : data.keySet())
		{
			assertArrayEquals(data.get(sample), EOLSplitters.splitUsingCustomLogic2(sample));
		}
	}
	
	@Test
	public void testCustomLogicSplit3()
	{
		for (String sample : data.keySet())
		{
			assertArrayEquals(data.get(sample), EOLSplitters.splitUsingCustomLogic3(sample));
		}
	}
	
	@Test
	public void testCustomLogicSplit4()
	{
		for (String sample : data.keySet())
		{
			assertArrayEquals(data.get(sample), EOLSplitters.splitUsingCustomLogic3(sample));
		}
	}
	
	@Test
	public void testCommonsStringUtilsReplaceAndJDKSplit()
	{
		for (String sample : data.keySet())
		{
			assertArrayEquals(data.get(sample), EOLSplitters.splitUsingCommonsStringUtilsReplaceAndJDKSplit(sample));
		}
	}
}