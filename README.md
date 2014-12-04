debugskills
===========

1. logger > system.out.println

2. logback support jmx which means we can use jmx to update log level dynamicly. I prefer jmxterm personally.
   > java -jar jmxterm-1.0.0-SNAPSHOT-uber.jar
    >> jvms
    >> open [your java process pid]
    >> domain ch.qos.logback.classic 
    >> bean ch.qos.logback.classic:Name=demo,Type=ch.qos.logback.classic.jmx.JMXConfigurator
    >> run setLoggerLevel [your logger name] [expected log level]

    refer:  jmxterm -> http://wiki.cyclopsgroup.org/jmxterm/

3. with jmxterm & log4jdbc, we can turn on sql audit at any time.
      a. add log4jdbc4 dependency in your pom.xml
      b. update jdbc url to jdbc:log4jdbc:mysql://[host]/[db name]/[xxxxx]
      c. update driver class name to net.sf.log4jdbc.DriverSpy
      d. add <logger name="jdbc.sqltiming" level="OFF" /> in your logback.xml
    
    call following command in jmxterm when you want to time sql execution.
      >> run setLoggerLevel jdbc.sqltiming DEBUG
    
    then you will find following log in your log file:
     >> select pojo0_.id as id0_0_, pojo0_.name as name0_0_ from pojo pojo0_ where pojo0_.id=1 
     >> {executed in 0 msec}

4. jstack is useful and easy to use.
5. perf4j is useful.
6. btrace is a little heavy to use, but it is extremely powerful.
7. newrelic is easy to use, and a little expensive.
    
    


