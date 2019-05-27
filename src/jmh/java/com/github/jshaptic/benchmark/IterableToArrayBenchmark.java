package com.github.jshaptic.benchmark;

import java.util.Iterator;
import java.util.stream.StreamSupport;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.State;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables;

import org.openjdk.jmh.annotations.Scope;

@State(Scope.Benchmark)
public class IterableToArrayBenchmark
{
	private final static Iterable<String> sample = new Iterable<String>()
	{
		@Override
		public Iterator<String> iterator()
		{
			return new Iterator<String>()
			{
				private int i = 100000000;
				
				@Override
				public String next()
				{
					return "qwertyuiopasdfghjklzxcvbnm";
				}
				
				@Override
				public boolean hasNext()
				{
					return i-- > 0;
				}
			};
		}
	};
	
	@Benchmark // looks like JDK stream is slightly better, than Guava's interface
	public String[] testJDKStream() throws InterruptedException
	{
		return StreamSupport.stream(sample.spliterator(), false).toArray(String[]::new);
	}
	
	@Benchmark
	public String[] testGuavaFluentIterable() throws InterruptedException
	{
		return FluentIterable.from(sample).toArray(String.class);
	}
	
	@Benchmark
	public String[] testGuavaIterables() throws InterruptedException
	{
		return Iterables.toArray(sample, String.class);
	}
}