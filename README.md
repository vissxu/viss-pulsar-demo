
# Description
This code demo help to easily use Apache Pulsar by Springboot.
It defines 4 subscription modes by multiple @PulsarListener annotations.

# Best Practise
## Pre-Condition
1. A Pulsar service, standalone or cluster, refer: [Install.md](./PulsarClusterInstall.md)

2. Create topics, like
```shell
./pulsar-1/bin/pulsar-admin topics create-partitioned-topic xuwei/ns-xuwei/test-topicJ --partitions 5
./pulsar-1/bin/pulsar-admin topics create-partitioned-topic xuwei/ns-xuwei/test-topicS --partitions 3
./pulsar-1/bin/pulsar-admin topics create xuwei/ns-xuwei/test-topic
./pulsar-1/bin/pulsar-admin topics create xuwei/ns-xuwei/test-topic-exclusive
./pulsar-1/bin/pulsar-admin topics create xuwei/ns-xuwei/test-topic-failover
./pulsar-1/bin/pulsar-admin topics create xuwei/ns-xuwei/test-topic-shared
./pulsar-1/bin/pulsar-admin topics create xuwei/ns-xuwei/test-topic-keyshared
./pulsar-1/bin/pulsar-admin topics list xuwei/ns-xuwei                                                                     
visxu➜~/pulsar-cluster-3.0.6» ./pulsar-1/bin/pulsar-admin topics list xuwei/ns-xuwei                                                                                                                                  [10:39:19]
persistent://xuwei/ns-xuwei/test-topic-shared
persistent://xuwei/ns-xuwei/test-topicS-partition-0
persistent://xuwei/ns-xuwei/test-topicS-partition-1
persistent://xuwei/ns-xuwei/test-topic-keyshared
persistent://xuwei/ns-xuwei/test-topicS-partition-2
persistent://xuwei/ns-xuwei/test-topicJ-partition-4
persistent://xuwei/ns-xuwei/test-topicJ-partition-3
persistent://xuwei/ns-xuwei/test-topicJ-partition-2
persistent://xuwei/ns-xuwei/test-topic
persistent://xuwei/ns-xuwei/test-topicJ-partition-1
persistent://xuwei/ns-xuwei/test-topicJ-partition-0
visxu➜~/pulsar-cluster-3.0.6»                                                                                                                                                                                         
visxu➜~/pulsar-cluster-3.0.6»

```
## Run Demo
1. Run the PulsarSpringbootDemoApplication.java
2. Access http get: http://localhost:19999/healthcheck/produce, will send a String message to pulsar cluster.
3. Access http get: http://localhost:19999/healthcheck/produce4json, will send a JSON message to pulsar cluster.
4. More API see the HealthcheckController.java.
5. Message listener will receive the msg and consume it.

# Caution
>When accessing the Consumer object this way, do NOT invoke any operations that would change the Consumer’s cursor position by invoking any receive methods. 
All such operations must be done by the container.

[Reference](https://docs.spring.io/spring-pulsar/reference/reference/pulsar/message-consumption.html#_accessing_the_pulsar_consumer_object)


