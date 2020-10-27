


slf4j相当于一个日志的门面，与jdbc类似，具体的日志可以让 log4j logback  jdk自带log来实现

slf4j需要跟具体的实现绑定在一起，在项目当中，slf4j会自动扫面日志的实现（比如自动发现logback），

编程的时候使用的Logger是slf4j的Logger，（会区自动扫描Slf4j的Lgger的实现）