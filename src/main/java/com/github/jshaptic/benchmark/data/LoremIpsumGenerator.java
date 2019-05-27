package com.github.jshaptic.benchmark.data;

import java.io.IOException;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

public class LoremIpsumGenerator
{	
	private static String windowsEOL = "\r\n";
	private static String textWithWindowsEOL = "";
	static
	{
		try
		{
			textWithWindowsEOL = Resources.toString(Resources.getResource("LoripsumWindows.txt"), Charsets.UTF_8);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	private static String unixEOL = "\n";
	private static String textWithUnixEOL = "";
	static
	{
		try
		{
			textWithUnixEOL = Resources.toString(Resources.getResource("LoripsumUnix.txt"), Charsets.UTF_8);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	private static String macintoshEOL = "\r";
	private static String textWithMacintoshEOL = "";
	static
	{
		try
		{
			textWithMacintoshEOL = Resources.toString(Resources.getResource("LoripsumMacintosh.txt"), Charsets.UTF_8);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static String getStaticText(String eol)
	{
		if (eol.equalsIgnoreCase("windows")) return textWithWindowsEOL;
		if (eol.equalsIgnoreCase("unix")) return textWithUnixEOL;
		if (eol.equalsIgnoreCase("macintosh")) return textWithMacintoshEOL;
		return textWithWindowsEOL;
	}
	
	public static String getEOL(String eol)
	{
		if (eol.equalsIgnoreCase("windows")) return windowsEOL;
		if (eol.equalsIgnoreCase("unix")) return unixEOL;
		if (eol.equalsIgnoreCase("macintosh")) return macintoshEOL;
		return windowsEOL;
	}
}