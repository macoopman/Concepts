### Prereqs
- Java 8

### Download
- Download kafka binaries from website



## -------------------------- STARTING -------------------------------------
* Add kafka bin to path

* Zookeeper Config Set UP
	1) In kafka dir create dir -> mkdir -p data/zookeeper
	2) Edit -> vim config/zookeeper.properties
		- set data dir to the newly created file 

* Start Zookeeper
	- zookeeper-server-start.sh config/zookeeper.properties
	- * need to use sudo on my machine 
	* use -> zookeeper-server-start.sh --daemon config/zookeeper.properties
		- runs in background

* Start Kafka
	- Make dir -> data/kafka
	- Edit Properties
		- vim config/server.properties
		- Edit: log.dirs to direct to new folder 
	- START
		- sudo bin/kafka-server-start.sh config/server.properties



## -------------------------- CLI -------------------------------------

## COMMANDS

### TOPICS  (kafka-topics.sh)

	* **kafka-topics.sh**
		- list all kafka commands
	- kafka-topics.sh --zookeeper 127.0.0.1:2181 --topic first_topic --create --partitions 3 --replication-factor 1
		- zookeeper
			- to create a topic we must point to zookeeper 
			- zookeeper runs on localhost 2181
		- topic
			- create a topic
		- create
			- create the new topic
		- partitions
			- must set partitions
		- replication-factor
			- can not have more replications than number of brokers 
	- kafka-topics.sh --zookeeper 127.0.0.1:2181 --list	
		- list
			- list all topics that have been created 
	- kafka-topics.sh --zookeeper 127.0.0.1:2181 --topic first_topic --describe
		- describe
			- gives output discription of specific topic 
	kafka-topics.sh --zookeeper localhost:2181 --topic second_topic --delete
		- delete
			- marks topic for deletion 

PRODUCER (kafka-console-producer.sh)

	- kafka-console-producer.sh --broker-list localhost:9092 --topic first_topic
		- broker-list
			- add ip to kafka broker
		- topic
			- topic name to send data to
		- Once completed you get a carrot display and can input your message. Press "Ctrl-C" to exit
	- kafka-console-producer.sh --broker-list localhost:9092 --topic first_topic --producer-property acks=all
		- producer-property
			- set properities for producer

	- kafka-console-producer.sh --broker-list localhost:9092 --topic new_topic
		- Sending data to a new topic (that was not create) creates a new topic automatically
		- Gives default setting --BEST to build explicitly
		- defaults can be changed in settings "server.properties"

CONSUMER (kafka-console-consumer.sh)

	- kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic first_topic
		- bootstrap-server
			- connect to kafka 
		- Only reads new messages from the point at which it starts consuming (not old one). See below to get all messages 
	- kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic first_topic --from-beginning
		- from-beginning
			- get all messages 
	- kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic first_topic --group my-first-app
		- group 
			- sets a name for a consumer group
			- by running that command multiple times, in different terminals, the messages get distribuited b/t the consumers that are apart of that group 


CONSUMER GROUPS (kafka-consumer-groups.sh)
	- List all consumer groups, describe a consumer group, delete consumer group infor, or reset offsets
	- kafka-consumer-groups.sh --bootstrap-server localhost:9092 --list
		- list
			- list all create groups 
	- kafka-consumer-groups.sh --bootstrap-server localhost:9092 --describe --group my-first-app
		- get specifics of a group 

-------------------------- JAVA -------------------------------------

1) Create new Java Maven project
2) Add dependencies to pom file 
```java

	<!-- https://mvnrepository.com/artifact/org.apache.kafka/kafka-clients -->
	<dependency>
	    <groupId>org.apache.kafka</groupId>
	    <artifactId>kafka-clients</artifactId>
	    <version>2.4.1</version>
	</dependency>

	<!-- https://mvnrepository.com/artifact/org.slf4j/slf4j-simple -->
	<dependency>
	    <groupId>org.slf4j</groupId>
	    <artifactId>slf4j-simple</artifactId>
	    <version>1.7.30</version>
	    <scope>test</scope>
	</dependency>

	** Comment out scope in the logger
```

------ PRODUCERS


Create Producer
```java
	public class ProducerDemo {

	   public static void main(String[] args) {
	      // create producer properties
	      Properties properties = new Properties();
	      properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
	      properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
	      properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());

	      // create producer
	      KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

	      // create producer record
	      ProducerRecord<String, String> record =  new ProducerRecord<String, String>("first_topic", "Hello, World!");


	      // send data -- asynchronous -- data not sent right a
	      producer.send(record);

	      // forces the data to be sent
	//      producer.flush();
	      // data sent when connection is closed - flush and close 
	      producer.close();
	   }
	}
```

Producer With Callback
	- Adds a callback subclass (not right term) to show how messages work
	- log messages done with slf4j
```java
	import org.apache.kafka.common.serialization.StringSerializer;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

	import java.util.Properties;

	public class ProducerDemoWithCallback {

	   public static void main(String[] args) {
	      final Logger logger = LoggerFactory.getLogger(ProducerDemoWithCallback.class);

	      // create producer properties
	      Properties properties = new Properties();
	      properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
	      properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
	      properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());

	      // create producer
	      KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);


	      for(int i = 0; i < 10; ++i){
		 // create producer record
		 ProducerRecord<String, String> record =  new ProducerRecord<String, String>("first_topic", "Hello, World! " + Integer.toString(i) );


		 // send data -- asynchronous -- data not sent right a
		 producer.send(record, new Callback() {
		    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
		       // executes every time a record is sent or exception is thrown
		       if (e == null){
		          logger.info("\nReceived new metadata. \n" +
		             "Topic: " + recordMetadata.topic() + "\n" +
		             "Partition: " + recordMetadata.partition() + "\n" +
		             "Offset: " + recordMetadata.offset() + "\n" +
		             "Timestamp: " + recordMetadata.timestamp() + "\n"
		          );
		       } else {
		          logger.error("Error while producing:  " + e);
		       }
		    }
		 });
	      }


	      // forces the data to be sent
	//      producer.flush();
	      // data sent when connection is closed - flush and close
	      producer.close();
	   }
	}
```

Add Key
	- adds key to message
	- when key is present the same key will always go to the same partition. (I dont believe I can control which partition, it is just done for you)
```java
 		 String topic = "first_topic";
		 String value = "hello world " + Integer.toString(i);
		 String key = "id_" + Integer.toString(i);

		 ProducerRecord<String, String> record =  new ProducerRecord<String, String>(topic, key, value );
```


------ CONSUMER

Basic Consumer
```java
		public class ConsumerDemo {

		   public static void main(String[] args) {
		      Logger logger = LoggerFactory.getLogger(ConsumerDemo.class.getName());

		      String bootStrapServers = "127.0.0.1:9092";
		      String groupId = "my-forth-application";
		      String topic = "first_topic";

		      // Create Config
		      Properties properties = new Properties();
		      properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapServers);
		      properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		      properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		      properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
		      properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

		      //create consumer
		      KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);

		      // subscribe consumer to topic(s)
		      consumer.subscribe(Arrays.asList(topic));

		      // poll for new data
		      while(true) {
			 ConsumerRecords<String, String> records =  consumer.poll(Duration.ofMillis(100));

			 for(ConsumerRecord<String, String> record : records){
			    logger.info("Key: " + record.key() + " , Value: " + record.value());
			    logger.info("Partition: " + record.partition() +  " , Offset: " + record.offset());
			 }
		      }

		   }
		}
```





### ----------------------- PRODUCER CONFIGS --------------------------

* **acks**
    * acks=0 (no acks)
        * No responce from broker
        * If broker goes offline or an exception happens, we wont know and will lose data
        * Usefull When:
            * loss is ok.. (Metrics collection, Log collection)
    * acks=1 (leader acks)
        * Leader responce is requested, but replication is not guarantee
        * If no ack producer my retry
    * acks=all
        * Leader + Replicas ack request
        * MUST ALSO USE: -> **min.insync.replicas**
            * broker/topic setting
            * min.insync.replicas=2
                * at least 2 brokers that are ISR must respond that they have the data
    
* **retries**
    * If transient failures, devs are expected to handle exceptions, or data is lost. This sets the max number of retries that can be made.
    * default = 0

### Safe Producer

* Use these setting for a safe producer:
    * enable.idempotence=true** (producer level)
    * min.insync.replicas=2 (broker/topic level)
* NOTE: Running a "safe"producer" might impact throughput and latency

```java
    // create a safe producer
    properties.setProperty(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, "true");
    properties.setProperty(ProducerConfig.ACKS_CONFIG, "all");
    properties.setProperty(ProducerConfig.RETRIES_CONFIG, Integer.toString(Integer.MAX_VALUE));
    properties.setProperty(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, "5");
```
    

### Message Compression

* Producer usally sends data that is text-based, i.e. JSON
* Apply commpression to producer
* Enable at producer level
* **compression.type**
    * none, gzip, lz4, snappy
* LINK: https://blog.cloudflare.com/squeezing-the-firehose/
    * about the diffences in compression 
* Suggested: lz4 and snappy
* Should also adjust: **linger.ms** and **batch.size**

### Batch Size
* Batchs have higher compression ratio: this is good
* Settings:
    * **linger.ms**
        * The number of milliseconds a producer is willing to wait before sending a batch out (default = 0)
        * Introducing some lag (linger.ms=5), we increae the chances of messages being sent together in a batch
    * **batch.size**
        * when size is met then batch is sent (max bytes) (default = 16KB)
        * allocated per partition (dont go super high)

