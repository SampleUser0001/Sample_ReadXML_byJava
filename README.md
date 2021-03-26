# TemplateMaven
Mavenのテンプレート。

## 起動引数

1. 入力.xmlパス
2. 出力.tsvパス
3. listファイルパス

実行例
```
mvn clean compile exec:java -Dexec.mainClass="sample.read.xml.App" -Dexec.args="'./src/main/resources/input.xml' './src/main/resources/output.tsv' './src/main/resources/attribute.lst' "
```

### 備考

Maven on Dockerしようとしたが、うまく動かないので、XMLReader配下で実行すること。

起動引数が複数渡せない?

``` txt
maven_1  | clean compile exec:java -Dexec.mainClass="sample.read.xml.App" -Dexec.args="'/usr/src/mymaven/XMLReader/src/main/resources/input.xml' '/usr/src/mymaven/XMLReader/src/main/resources/output.xml' '/usr/src/mymaven/XMLReader/src/main/resources/attribute.lst' "
maven_1  | [ERROR] Error executing Maven.
maven_1  | java.lang.StringIndexOutOfBoundsException: String index out of range: -1
maven_1  |      at java.lang.AbstractStringBuilder.setLength(AbstractStringBuilder.java:207)
maven_1  |      at java.lang.StringBuilder.setLength(StringBuilder.java:76)
maven_1  |      at org.apache.maven.cli.CleanArgument.cleanArgs(CleanArgument.java:65)
maven_1  |      at org.apache.maven.cli.CLIManager.parse(CLIManager.java:158)
maven_1  |      at org.apache.maven.cli.MavenCli.cli(MavenCli.java:407)
maven_1  |      at org.apache.maven.cli.MavenCli.doMain(MavenCli.java:278)
maven_1  |      at org.apache.maven.cli.MavenCli.main(MavenCli.java:193)
maven_1  |      at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
maven_1  |      at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
maven_1  |      at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
maven_1  |      at java.lang.reflect.Method.invoke(Method.java:498)
maven_1  |      at org.codehaus.plexus.classworlds.launcher.Launcher.launchEnhanced(Launcher.java:282)
maven_1  |      at org.codehaus.plexus.classworlds.launcher.Launcher.launch(Launcher.java:225)
maven_1  |      at org.codehaus.plexus.classworlds.launcher.Launcher.mainWithExitCode(Launcher.java:406)
maven_1  |      at org.codehaus.plexus.classworlds.launcher.Launcher.main(Launcher.java:347)
sample_readxml_byjava_maven_1 exited with code 1
```

## 参考

- [Java入門:Java による XML の読込み](https://java.keicode.com/lib/xml-basic.php)

