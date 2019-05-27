package com.github.jshaptic.benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.State;

import com.github.jshaptic.benchmark.data.LoremIpsumGenerator;

import org.openjdk.jmh.annotations.Scope;

@State(Scope.Benchmark)
public class ConvertToUnixEOLBenchmark
{
	@Param({"windows", "unix", "macintosh"})
	private String eol;
	
	@Benchmark
	public String testJDKStringReplace() throws InterruptedException
	{
		return UnixEOLConverters.normalizeUsingJDKStringReplace(LoremIpsumGenerator.getStaticText(eol));
	}
	
	@Benchmark
	public String testJDKStringReplaceChars() throws InterruptedException
	{
		return UnixEOLConverters.normalizeUsingJDKStringReplaceChars(LoremIpsumGenerator.getStaticText(eol));
	}
	
	@Benchmark
	public String testJDKStringReplaceAll() throws InterruptedException
	{
		return UnixEOLConverters.normalizeUsingJDKStringReplaceAll(LoremIpsumGenerator.getStaticText(eol));
	}
	
	@Benchmark
	public String testJDKCompiledPatternReplaceAll() throws InterruptedException
	{
		return UnixEOLConverters.normalizeUsingJDKCompiledPatternReplaceAll(LoremIpsumGenerator.getStaticText(eol));
	}
	
	@Benchmark // looks like this method is the fastest
	public String testCommonsStringUtilsReplace() throws InterruptedException
	{
		return UnixEOLConverters.normalizeUsingCommonsStringUtilsReplace(LoremIpsumGenerator.getStaticText(eol));
	}
	
	@Benchmark
	public String testCommonsStringUtilsReplaceChars() throws InterruptedException
	{
		return UnixEOLConverters.normalizeUsingCommonsStringUtilsReplaceChars(LoremIpsumGenerator.getStaticText(eol));
	}
	
	@Benchmark
	public String testCommonsStringUtilsReplaceEach() throws InterruptedException
	{
		return UnixEOLConverters.normalizeUsingCommonsStringUtilsReplaceEach(LoremIpsumGenerator.getStaticText(eol));
	}
}