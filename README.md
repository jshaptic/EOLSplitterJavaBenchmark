# How to run
Before running make sure that gradle daemon is not already running, otherwise kill it.

Run benchmark:

```
$ gradlew clean
$ gradlew jmh
```

# Tests
**ConvertToUnixEOLBenchmark**
> Set of various methods, whose purpose is to convert all possible line endings (\r\n, \r, \n) to one Unix form \n.

**StringSplitBenchmark**
> Set of various methods, whose purpose is to split string by some character or string. There were tested 3 different delimiters: "\r\n" as string, "\n" as string and '\r' as char.

**EOLSplitBenchmark**
> Main test, which checks what is the fastest way to split text by any possible line ending (\r\n, \r, \n), regardless of what EOL marker is used and whether it's the same across the text.

# Benchmark results

On Windows Laptop with JDK 1.8.0_172, 64-bit

```
Benchmark                                                                                          (EOL)  Mode  Cnt   Score    Error  Units
ConvertToUnixEOLBenchmark.testCommonsStringUtilsReplace                                          windows  avgt    5  16.758 ±  0.955  ms/op
ConvertToUnixEOLBenchmark.testCommonsStringUtilsReplace                                             unix  avgt    5   6.323 ±  0.015  ms/op
ConvertToUnixEOLBenchmark.testCommonsStringUtilsReplace                                        macintosh  avgt    5  18.303 ± 10.467  ms/op
ConvertToUnixEOLBenchmark.testCommonsStringUtilsReplaceChars                                     windows  avgt    5  17.971 ±  2.657  ms/op
ConvertToUnixEOLBenchmark.testCommonsStringUtilsReplaceChars                                        unix  avgt    5   7.512 ±  0.057  ms/op
ConvertToUnixEOLBenchmark.testCommonsStringUtilsReplaceChars                                   macintosh  avgt    5   9.181 ±  0.127  ms/op
ConvertToUnixEOLBenchmark.testCommonsStringUtilsReplaceEach                                      windows  avgt    5  29.999 ±  1.432  ms/op
ConvertToUnixEOLBenchmark.testCommonsStringUtilsReplaceEach                                         unix  avgt    5   6.237 ±  0.008  ms/op
ConvertToUnixEOLBenchmark.testCommonsStringUtilsReplaceEach                                    macintosh  avgt    5  29.226 ±  1.264  ms/op
ConvertToUnixEOLBenchmark.testJDKCompiledPatternReplaceAll                                       windows  avgt    5  67.691 ±  2.908  ms/op
ConvertToUnixEOLBenchmark.testJDKCompiledPatternReplaceAll                                          unix  avgt    5   5.791 ±  4.572  ms/op
ConvertToUnixEOLBenchmark.testJDKCompiledPatternReplaceAll                                     macintosh  avgt    5  78.140 ±  3.437  ms/op
ConvertToUnixEOLBenchmark.testJDKStringReplace                                                   windows  avgt    5  67.794 ±  3.452  ms/op
ConvertToUnixEOLBenchmark.testJDKStringReplace                                                      unix  avgt    5   5.786 ±  4.629  ms/op
ConvertToUnixEOLBenchmark.testJDKStringReplace                                                 macintosh  avgt    5  78.249 ±  3.304  ms/op
ConvertToUnixEOLBenchmark.testJDKStringReplaceAll                                                windows  avgt    5  69.369 ±  3.237  ms/op
ConvertToUnixEOLBenchmark.testJDKStringReplaceAll                                                   unix  avgt    5   6.498 ±  0.043  ms/op
ConvertToUnixEOLBenchmark.testJDKStringReplaceAll                                              macintosh  avgt    5  85.856 ±  3.714  ms/op
ConvertToUnixEOLBenchmark.testJDKStringReplaceChars                                              windows  avgt    5  44.005 ±  1.297  ms/op
ConvertToUnixEOLBenchmark.testJDKStringReplaceChars                                                 unix  avgt    5   7.405 ±  2.396  ms/op
ConvertToUnixEOLBenchmark.testJDKStringReplaceChars                                            macintosh  avgt    5  20.117 ± 13.212  ms/op
EOLSplitBenchmark.testCustomLogic1Split                                                          windows  avgt    5  17.667 ±  0.607  ms/op
EOLSplitBenchmark.testCustomLogic1Split                                                             unix  avgt    5  17.607 ±  0.674  ms/op
EOLSplitBenchmark.testCustomLogic1Split                                                        macintosh  avgt    5  19.108 ±  0.295  ms/op
EOLSplitBenchmark.testCustomLogic2Split                                                          windows  avgt    5  16.821 ±  0.555  ms/op
EOLSplitBenchmark.testCustomLogic2Split                                                             unix  avgt    5  16.766 ±  0.476  ms/op
EOLSplitBenchmark.testCustomLogic2Split                                                        macintosh  avgt    5  18.166 ±  0.341  ms/op
EOLSplitBenchmark.testCustomLogic3Split                                                          windows  avgt    5  28.407 ±  0.992  ms/op
EOLSplitBenchmark.testCustomLogic3Split                                                             unix  avgt    5  28.285 ±  1.155  ms/op
EOLSplitBenchmark.testCustomLogic3Split                                                        macintosh  avgt    5  27.575 ±  0.783  ms/op
EOLSplitBenchmark.testCustomLogic4Split                                                          windows  avgt    5  19.063 ±  0.545  ms/op
EOLSplitBenchmark.testCustomLogic4Split                                                             unix  avgt    5  18.899 ±  0.600  ms/op
EOLSplitBenchmark.testCustomLogic4Split                                                        macintosh  avgt    5  23.401 ±  0.978  ms/op
EOLSplitBenchmark.testStringUtilsReplaceAndJDKSplit                                              windows  avgt    5  21.472 ±  0.794  ms/op
EOLSplitBenchmark.testStringUtilsReplaceAndJDKSplit                                                 unix  avgt    5  11.549 ±  0.276  ms/op
EOLSplitBenchmark.testStringUtilsReplaceAndJDKSplit                                            macintosh  avgt    5  22.366 ±  1.151  ms/op
StringSplitBenchmark.testCommonsStringTokenizerByMacintoshSep                                        N/A  avgt    5  39.202 ±  1.143  ms/op
StringSplitBenchmark.testCommonsStringTokenizerByUnixSep                                             N/A  avgt    5  53.196 ±  0.568  ms/op
StringSplitBenchmark.testCommonsStringTokenizerByWindowsSep                                          N/A  avgt    5  87.306 ±  2.013  ms/op
StringSplitBenchmark.testCommonsStringUtilsSplitByWholeSeparatorPreserveAllTokensByUnixSep           N/A  avgt    5   6.929 ±  0.164  ms/op
StringSplitBenchmark.testCommonsStringUtilsSplitByWholeSeparatorPreserveAllTokensByWindowsSep        N/A  avgt    5   6.986 ±  0.074  ms/op
StringSplitBenchmark.testCommonsStringUtilsSplitPreserveAllTokensByMacintoshSep                      N/A  avgt    5   6.601 ±  0.122  ms/op
StringSplitBenchmark.testCommonsStringUtilsSplitPreserveAllTokensByUnixSep                           N/A  avgt    5   8.231 ±  0.110  ms/op
StringSplitBenchmark.testCommonsStringUtilsSplitPreserveAllTokensByWindowsSep                        N/A  avgt    5  28.289 ±  1.208  ms/op
StringSplitBenchmark.testGuavaSplitterByMacintoshSep                                                 N/A  avgt    5   6.900 ±  0.149  ms/op
StringSplitBenchmark.testGuavaSplitterByUnixSep                                                      N/A  avgt    5   6.283 ±  0.142  ms/op
StringSplitBenchmark.testGuavaSplitterByWindowsSep                                                   N/A  avgt    5  20.727 ±  0.812  ms/op
StringSplitBenchmark.testJDKStringSplitByUnixSep                                                     N/A  avgt    5   5.524 ±  0.144  ms/op
StringSplitBenchmark.testJDKStringSplitByWindowsSep                                                  N/A  avgt    5  23.832 ±  0.690  ms/op
```

# Interpretation of results

Main purpose of this benchmark was to find the fastest method to split text by any possible line ending. According to the results it's a logic that was implemented in method EOLSplitters.splitUsingCustomLogic2. Combination of StringUtils replace and JDK String split method wasn't as good as a custom logic. 

# Environments info

Windows Laptop

```
  OS: Windows 10 Pro, 64-bit
  Model Name: HP Elitebook
  CPU: Intel Core i5-8250U @ 1.60 GHz 1.80GHz
  Number of Cores: 4
  L1 Cache: 256 KB
  L2 Cache: 1 MB
  L3 Cache: 6 MB
  Memory: 8 GB
```