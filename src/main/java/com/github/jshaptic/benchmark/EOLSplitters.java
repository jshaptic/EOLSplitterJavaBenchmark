package com.github.jshaptic.benchmark;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class EOLSplitters
{
	public static String[] splitUsingCustomLogic1(String input)
	{
		if (input == null || input.length() == 0) return new String[]{""};
		
		List<String> output = new ArrayList<String>();
		
		int tokenStart = 0;
		for (int i = 0; i < input.length(); i++)
		{
			char c = input.charAt(i);
			if (c == '\r' || c == '\n')
			{
				if (tokenStart == i)
					output.add("");
				else
					output.add(input.substring(tokenStart, i));
				if (c == '\r' && i + 1 < input.length() && input.charAt(i + 1) == '\n')
					i++;
				tokenStart = i + 1;
			}
		}
		
		if (tokenStart >= input.length())
			output.add("");
		else
			output.add(input.substring(tokenStart));
		
		return output.toArray(new String[output.size()]);
	}
	
	public static String[] splitUsingCustomLogic2(String input)
	{
		if (input == null || input.length() == 0) return new String[]{""};
		
		List<String> output = new ArrayList<String>();
		
		int start = 0;
		int end = 0;
		char prevChar = '\n';
		for (int i = 0; i < input.length(); i++)
		{
			char c = input.charAt(i);
			end = i;
			
			if (prevChar == '\r' && c == '\n')
			{
				start = i + 1;
			}
			else if (c == '\n' || c == '\r')
			{	
				if (start == end)
					output.add("");
				else
					output.add(input.substring(start, end));
				
				start = i + 1;
			}
			
			prevChar = c;
		}
		
		if (start >= input.length())
			output.add("");
		else
			output.add(input.substring(start));
		
		return output.toArray(new String[output.size()]);
	}
	
	public static String[] splitUsingCustomLogic3(String input)
	{
		if (input == null || input.length() == 0) return new String[]{""};
		
		List<String> output = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		
		char prevChar = '\n';
		for (int i = 0; i < input.length(); i++)
		{
			char c = input.charAt(i);
			
			if (c == '\r')
			{
				output.add(sb.toString());
				sb.setLength(0);
			}
			else if (c == '\n')
			{
				if (prevChar != '\r')
				{
					output.add(sb.toString());
					sb.setLength(0);
				}
			}
			else
				sb.append(c);
			
			prevChar = c;
		}
		
		if (prevChar == '\r' || prevChar == '\n')
			output.add("");
		else
			output.add(sb.toString());
		
		return output.toArray(new String[output.size()]);
	}
	
	public static String[] splitUsingCustomLogic4(String input)
	{
		if (input == null || input.length() == 0) return new String[]{""};
		
		List<String> output = new LinkedList<String>();
		
		int i,j;
		for (i = 0, j = 0; j < input.length(); j++)
		{
			char c = input.charAt(j);
			if (c == '\r' || c == '\n')
			{
				if (i == j)
					output.add("");
				else
					output.add(input.substring(i, j));
				if (c == '\r' && j + 1 < input.length() && input.charAt(j + 1) == '\n')
					j++;
				i = j + 1;
			}
		}
		
		if (i >= input.length())
			output.add("");
		else
			output.add(input.substring(i));
		
		return output.toArray(new String[output.size()]);
	}
	
	public static String[] splitUsingCommonsStringUtilsReplaceAndJDKSplit(String input)
	{
		return StringUtils.replace(StringUtils.replace(input, "\r\n", "\n"), "\r", "\n").split("\n", -1);
	}
}