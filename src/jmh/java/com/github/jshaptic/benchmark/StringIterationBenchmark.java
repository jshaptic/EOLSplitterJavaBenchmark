package com.github.jshaptic.benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.State;

import com.github.jshaptic.benchmark.data.LoremIpsumGenerator;

import org.openjdk.jmh.annotations.Scope;

@State(Scope.Benchmark)
public class StringIterationBenchmark
{
	private final static String sample = LoremIpsumGenerator.getStaticText("windows");
	
	@Benchmark
	public int testCharArrayWithLoop() throws InterruptedException
	{
		char[] strArray = sample.toCharArray();
		int count = 0;
		for (int i = 0; i < strArray.length; i++)
			if (strArray[i] == ' ')
				count++;
		return count;
	}
	
	@Benchmark
	public int testCharArrayWithEachLoop() throws InterruptedException
	{
		char[] strArray = sample.toCharArray();
		int count = 0;
		for (char c : strArray)
			if (c == ' ')
				count++;
		return count;
	}
	
	@Benchmark // looks like this method is the fastest
	public int testCharAtWithLoop() throws InterruptedException
	{
		int count = 0;
		for (int i = 0; i < sample.length(); i++)
			if (sample.charAt(i) == ' ')
				count++;
		return count;
	}
	
	@Benchmark
	public int testCharsStream() throws InterruptedException
	{
		return sample.chars().reduce(0, (count, c) -> count + (c == ' ' ? 1 : 0));
	}
}