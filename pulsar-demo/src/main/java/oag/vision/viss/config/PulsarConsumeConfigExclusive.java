package oag.vision.viss.config;

import java.io.IOException;
import oag.vision.viss.entity.Employee;
import oag.vision.viss.entity.RequestBody;
import oag.vision.viss.entity.User;
import oag.vision.viss.util.JSONUtil;
import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.client.api.MessageListener;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.api.Schema;
import org.apache.pulsar.client.api.SubscriptionMode;
import org.apache.pulsar.client.api.SubscriptionType;
import org.apache.pulsar.client.impl.schema.AvroSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PulsarConsumeConfigExclusive {

    private Logger logger = LoggerFactory.getLogger(PulsarConsumeConfigExclusive.class);


    private final CommonConfig commonConfig;
    private final PulsarClient pulsarClient;


    public PulsarConsumeConfigExclusive(CommonConfig commonConfig, PulsarClient pulsarClient) {
        this.commonConfig = commonConfig;
        this.pulsarClient = pulsarClient;
    }

//    @Bean
    Consumer pulsarExclusiveConsumerA() throws PulsarClientException {
        Consumer<String> consumer = pulsarClient.newConsumer(Schema.STRING)
                .topic(commonConfig.getTestTopic())
                .consumerName("consumerExclusiveA")
                .subscriptionName("subscription-Exclusive")
                .subscriptionType(SubscriptionType.Exclusive)
                .subscriptionMode(SubscriptionMode.Durable)
                .messageListener(new MessageListener<String>() {
                    @Override
                    public void received(Consumer<String> consumer, Message<String> msg) {
                        logger.info("received msg, topic: {}, value: {} ", msg.getTopicName(), msg.getValue());
                        try {
                            consumer.acknowledge(msg);
                        } catch (PulsarClientException e) {
                            throw new RuntimeException(e);
                        }
                    }
                })
                .subscribe();
        return consumer;
    }

//    @Bean
    Consumer pulsarExclusiveConsumerB() throws PulsarClientException {
        Consumer<String> consumer = pulsarClient.newConsumer(Schema.STRING)
                .topic(commonConfig.getTestTopic())
                .consumerName("consumerExclusiveB")
                .subscriptionName("subscription-Exclusive")
                .subscriptionType(SubscriptionType.Exclusive)
                .subscriptionMode(SubscriptionMode.Durable)
                .messageListener(new MessageListener<String>() {
                    @Override
                    public void received(Consumer<String> consumer, Message<String> msg) {
                        logger.info("received msg, topic: {}, value: {} ", msg.getTopicName(), msg.getValue());
                    }
                })
                .subscribe();
        return consumer;
    }

    @Bean
    Consumer pulsarExclusiveConsumerC() throws PulsarClientException {
        Consumer<RequestBody> consumer = pulsarClient.newConsumer(Schema.JSON(RequestBody.class))
                .topic(commonConfig.getTestTopic())
                .consumerName("consumerExclusiveC")
                .subscriptionName("subscription-Exclusive")
                .subscriptionType(SubscriptionType.Exclusive)
                .messageListener(new MessageListener<RequestBody>() {
                    @Override
                    public void received(Consumer<RequestBody> consumer, Message<RequestBody> msg) {
                        try {
                            logger.info("received msg, topic: {}, value: {} ", msg.getTopicName(), JSONUtil.convertToString(msg.getValue()));
                            consumer.acknowledge(msg);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                })
                .subscribe();
        return consumer;
    }


}

