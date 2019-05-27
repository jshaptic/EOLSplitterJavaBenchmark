package com.github.jshaptic.benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.State;

import com.github.jshaptic.benchmark.StringSplitters;
import com.github.jshaptic.benchmark.data.LoremIpsumGenerator;

import org.openjdk.jmh.annotations.Scope;

@State(Scope.Benchmark)
public class StringSplitBenchmark
{
	private final static String sample = LoremIpsumGenerator.getStaticText("windows");
	private final static String windowsSep = "\r\n";
	private final static String unixSep = "\n";
	private final static char macintoshSep = '\r';
	
	@Benchmark
	public String[] testJDKStringSplitByWindowsSep() throws InterruptedException
	{
		return StringSplitters.splitUsingJDKStringSplit(sample, windowsSep);
	}
	
	@Benchmark // looks like default String split method is the fastes among others
	public String[] testJDKStringSplitByUnixSep() throws InterruptedException
	{
		return StringSplitters.splitUsingJDKStringSplit(sample, unixSep);
	}
	
	@Benchmark
	public String[] testCommonsStringUtilsSplitPreserveAllTokensByWindowsSep() throws InterruptedException
	{
		return StringSplitters.splitUsingCommonsStringUtilsSplitPreserveAllTokens(sample, windowsSep);
	}
	
	@Benchmark
	public String[] testCommonsStringUtilsSplitPreserveAllTokensByUnixSep() throws InterruptedException
	{
		return StringSplitters.splitUsingCommonsStringUtilsSplitPreserveAllTokens(sample, unixSep);
	}
	
	@Benchmark
	public String[] testCommonsStringUtilsSplitPreserveAllTokensByMacintoshSep() throws InterruptedException
	{
		return StringSplitters.splitUsingCommonsStringUtilsSplitPreserveAllTokens(sample, macintoshSep);
	}
	
	@Benchmark
	public String[] testCommonsStringUtilsSplitByWholeSeparatorPreserveAllTokensByWindowsSep() throws InterruptedException
	{
		return StringSplitters.splitUsingCommonsStringUtilsSplitByWholeSeparatorPreserveAllTokens(sample, windowsSep);
	}
	
	@Benchmark
	public String[] testCommonsStringUtilsSplitByWholeSeparatorPreserveAllTokensByUnixSep() throws InterruptedException
	{
		return StringSplitters.splitUsingCommonsStringUtilsSplitByWholeSeparatorPreserveAllTokens(sample, unixSep);
	}
	
	@Benchmark
	public String[] testCommonsStringTokenizerByWindowsSep() throws InterruptedException
	{
		return StringSplitters.splitUsingCommonsStringTokenizer(sample, windowsSep);
	}
	
	@Benchmark
	public String[] testCommonsStringTokenizerByUnixSep() throws InterruptedException
	{
		return StringSplitters.splitUsingCommonsStringTokenizer(sample, unixSep);
	}
	
	@Benchmark
	public String[] testCommonsStringTokenizerByMacintoshSep() throws InterruptedException
	{
		return StringSplitters.splitUsingCommonsStringTokenizer(sample, macintoshSep);
	}
	
	@Benchmark
	public String[] testGuavaSplitterByWindowsSep() throws InterruptedException
	{
		return StringSplitters.splitUsingGuavaSplitter(sample, windowsSep);
	}
	
	@Benchmark
	public String[] testGuavaSplitterByUnixSep() throws InterruptedException
	{
		return StringSplitters.splitUsingGuavaSplitter(sample, unixSep);
	}
	
	@Benchmark
	public String[] testGuavaSplitterByMacintoshSep() throws InterruptedException
	{
		return StringSplitters.splitUsingGuavaSplitter(sample, macintoshSep);
	}
}