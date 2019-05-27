package com.github.jshaptic.benchmark.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.jshaptic.benchmark.StringSplitters;

public class StringSplitTests extends Assert
{
	private static final Map<String, String[]> data = new HashMap<String, String[]>();

	@BeforeClass
	public static void setup()
	{
		data.put("", new String[]{""});
		data.put("abc", new String[]{"abc"});
		data.put("\n", new String[]{"", ""});
		data.put("abc\n", new String[]{"abc", ""});
		data.put("\nabc", new String[]{"", "abc"});
		data.put("\n\n\n", new String[]{"", "", "", ""});
		data.put("\nabc\nabc\n\nabc\n", new String[]{"", "abc", "abc", "", "abc", ""});
	}
	
	@Test
	public void testJDKStringSplit()
	{
		for (String sample : data.keySet())
		{
			assertArrayEquals(data.get(sample), StringSplitters.splitUsingJDKStringSplit(sample, "\n"));
		}
	}
	
	@Test
	public void testCommonsStringUtilsSplitPreserveAllTokensString()
	{
		for (String sample : data.keySet())
		{
			assertArrayEquals(data.get(sample), StringSplitters.splitUsingCommonsStringUtilsSplitPreserveAllTokens(sample, "\n"));
		}
	}
	
	@Test
	public void testCommonsStringUtilsSplitPreserveAllTokensChar()
	{
		for (String sample : data.keySet())
		{
			assertArrayEquals(data.get(sample), StringSplitters.splitUsingCommonsStringUtilsSplitPreserveAllTokens(sample, '\n'));
		}
	}
	
	@Test
	public void testCommonsStringUtilsSplitByWholeSeparatorPreserveAllTokens()
	{
		for (String sample : data.keySet())
		{
			assertArrayEquals(data.get(sample), StringSplitters.splitUsingCommonsStringUtilsSplitByWholeSeparatorPreserveAllTokens(sample, "\n"));
		}
	}
	
	@Test
	public void testCommonsStringTokenizerString()
	{
		for (String sample : data.keySet())
		{
			assertArrayEquals(data.get(sample), StringSplitters.splitUsingCommonsStringTokenizer(sample, "\n"));
		}
	}
	
	@Test
	public void testCommonsStringTokenizerChar()
	{
		for (String sample : data.keySet())
		{
			assertArrayEquals(data.get(sample), StringSplitters.splitUsingCommonsStringTokenizer(sample, '\n'));
		}
	}
	
	@Test
	public void testGuavaSplitterString()
	{
		for (String sample : data.keySet())
		{
			assertArrayEquals(data.get(sample), StringSplitters.splitUsingGuavaSplitter(sample, "\n"));
		}
	}
	
	@Test
	public void testGuavaSplitterChar()
	{
		for (String sample : data.keySet())
		{
			assertArrayEquals(data.get(sample), StringSplitters.splitUsingGuavaSplitter(sample, '\n'));
		}
	}
}