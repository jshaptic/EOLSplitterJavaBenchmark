package com.github.jshaptic.benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.State;

import com.github.jshaptic.benchmark.data.LoremIpsumGenerator;
import com.github.jshaptic.benchmark.EOLSplitters;

import org.openjdk.jmh.annotations.Scope;

@State(Scope.Benchmark)
public class EOLSplitBenchmark
{
	@Param({"windows", "unix", "macintosh"})
	private String eol;
	
	@Benchmark //looks like this custom splitter slightly better than others
	public String[] testCustomLogic1Split() throws InterruptedException
	{
		return EOLSplitters.splitUsingCustomLogic1(LoremIpsumGenerator.getStaticText(eol));
	}
	
	@Benchmark
	public String[] testCustomLogic2Split() throws InterruptedException
	{
		return EOLSplitters.splitUsingCustomLogic2(LoremIpsumGenerator.getStaticText(eol));
	}
	
	@Benchmark
	public String[] testCustomLogic3Split() throws InterruptedException
	{
		return EOLSplitters.splitUsingCustomLogic3(LoremIpsumGenerator.getStaticText(eol));
	}
	
	@Benchmark
	public String[] testCustomLogic4Split() throws InterruptedException
	{
		return EOLSplitters.splitUsingCustomLogic4(LoremIpsumGenerator.getStaticText(eol));
	}
	
	@Benchmark
	public String[] testStringUtilsReplaceAndJDKSplit() throws InterruptedException
	{
		return EOLSplitters.splitUsingCommonsStringUtilsReplaceAndJDKSplit(LoremIpsumGenerator.getStaticText(eol));
	}
}