# springboot-learning
 * &nbsp;&nbsp; Springboot framework learning, and integration of mybatis, dubbo and other frameworks

## -- contents --

#### Recommended order：

### springboot module
 * &nbsp;&nbsp; Build a springboot framework
 
### springboot-mybatis module
 * &nbsp;&nbsp; Springboot integrates mybatis.Then we can visit database simply.  
 * &nbsp;&nbsp; The springboot configuration file has three forms: application.properties, application.yml and xml files. 
 Choose one of them when you use it. When springboot integrates mybatis, you can use the mybatis-generator plugin 
 to automatically generate the dao layer entity class, mapper file and xml file.  
 * &nbsp;&nbsp; This module uses the third form, but contains the configuration files needed for the three forms.
 
 ### springboot-redis module
 * &nbsp;&nbsp; Springboot integrates redis  
 * &nbsp;&nbsp; Redis is a key-value storage system. Similar to Memcached, it supports storing more value types, including string, 
 list, set, zset (sorted set), and hash (hash typeName). These data types support push/pop, add/remove, 
 and intersection set and difference sets and richer operations, and these operations are atomic.
 
  ### springboot-rocketmq-producer module  
  ### springboot-rocketmq-consumer module
  * &nbsp;&nbsp; Springboot integrates RocketMQ
  * &nbsp;&nbsp; Apache RocketMQ™ is an open source distributed messaging and streaming data platform.
  See http://rocketmq.apache.org
  
  ### springboot-dubbo-provider module
  ### springboot-dubbo-consumer module
  * &nbsp;&nbsp; Springboot integrates dubbo
  * &nbsp;&nbsp; Apache Dubbo™ (incubating) is a high-performance, java based open source RPC framework.
  * &nbsp;&nbsp; The dubbo contains four main components:  
  &nbsp;&nbsp; Provider: The Provider exposes the service party as a "service provider."   
  &nbsp;&nbsp; Consumer: The Consumer calls the remote service party to call it "service consumer."   
  &nbsp;&nbsp; Registry: The Central Directory Service for Registry Service Registration and Discovery is called the Service Registry.   
  &nbsp;&nbsp; Monitor: The log service of the number of calls and the time of calling the Monitor Statistics Service is called the Service Monitoring Center. 
  
  
  