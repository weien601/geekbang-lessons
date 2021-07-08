# 第六节 Java 标准技术栈架构

## 作业

参考
com.salesmanager.shop.tags.CommonResponseHeadersTag 实现一个自定义的 Tag，将 Hard Code 的 Header 名值 对，变为属性配置的方式，类似于:
```xml
<tag>
  <name>common-response-headers</name>
  <tag-class>com.salesmanager.shop.tags.CommonResponseHeadersTag</tag-class>
  <body-content>empty</body-content>
  <attribute>
    <name>Cache-Control</name>
    <required>false</required>
    <rtexprvalue>no-cache</rtexprvalue>
    <type>java.lang.String</type>
  </attribute>
  <attribute>
    <name>Pragma</name>
    <required>false</required>
    <rtexprvalue>no-cache</rtexprvalue>
    <type>java.lang.String</type>
  </attribute>
  <attribute>
    <name>Expires</name>
    <required>false</required>
    <rtexprvalue>-1</rtexprvalue>
    <type>java.lang.Long</type>
  </attribute>
</tag>
```
1. 实现自定义标签
2. 编写自定义标签tld文件
3. 部署到Servlet应用


## 实现

* tag类：src/main/java/org/geektimes/projects/work1/tags/CommonResponseHeadersTag.java 
* tld文件：src/main/webapp/WEB-INF/common-response.tld
* jsp例子：src/main/webapp/index.jsp
