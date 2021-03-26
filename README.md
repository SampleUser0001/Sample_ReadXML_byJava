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

## 参考

- [Java入門:Java による XML の読込み](https://java.keicode.com/lib/xml-basic.php)

