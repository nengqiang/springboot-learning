# springboot-learning
 * Springboot framework learning, and integration of mybatis, dubbo and other frameworks

## -- contents --

#### Recommended order：

### springboot module
 * Build a springboot framework
 
### springboot-mybatis module
 * Springboot integrates mybatis.Then we can visit database simply.  
 * The springboot configuration file has three forms: application.properties, application.yml and xml files. 
 Choose one of them when you use it. When springboot integrates mybatis, you can use the mybatis-generator plugin 
 to automatically generate the dao layer entity class, mapper file and xml file.  
 * This module uses the third form, but contains the configuration files needed for the three forms.
 
### springboot-redis module
 * Springboot integrates redis  
 * Redis is a key-value storage system. Similar to Memcached, it supports storing more value types, 
 including string, list, set, zset (sorted set), and hash (hash typeName). These data types support push/pop, add/remove, 
 and intersection set and difference sets and richer operations, and these operations are atomic.
 
### springboot-rocketmq-producer module  
### springboot-rocketmq-consumer module
 * Springboot integrates RocketMQ
 * Apache RocketMQ™ is an open source distributed messaging and streaming data platform.
 See http://rocketmq.apache.org
  
### springboot-dubbo-provider module
### springboot-dubbo-consumer module
 * Springboot integrates dubbo
 * Apache Dubbo™ (incubating) is a high-performance, java based open source RPC framework.
 * The dubbo contains four main components:    
   * Provider: The Provider exposes the service party as a "service provider."   
   * Consumer: The Consumer calls the remote service party to call it "service consumer."   
   * Registry: The Central Directory Service for Registry Service Registration and Discovery is called the 
   Service Registry.   
   * Monitor: The log service of the number of calls and the time of calling the Monitor Statistics Service is called 
   the Service Monitoring Center. 
 * Since the dubbo provider and the consumer profile are in the same project, the provider and the consumer cannot start 
 at the same time.   
 When the provider is started separately, the service is registered to the service center;   
 when the consumer is started separately, the service is registered to the service center.   
 Since the consumer imports the provider module dependency, the consumer can use the corresponding service of the 
 service center.
  
### springboot-mybatis-muti-datasource
 *  Use of master-slave database
  
### springboot-thymeleaf module
 * Springboot integrates thymeleaf
 * slf4j jquery echarts
  