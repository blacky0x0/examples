
## jOOQ manual ##

http://www.jooq.org/doc/3.7/manual-single-page/

## Generate classes##

java -classpath lib/jooq-3.7.2.jar:lib/jooq-meta-3.7.2.jar:lib/jooq-codegen-3.7.2.jar:lib/mysql-connector-java-5.1.36.jar:. org.jooq.util.GenerationTool jooq/src/main/resources/library.xml
