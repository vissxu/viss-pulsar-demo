package oag.vision.viss.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig {

    @Value("${pulsar.topic.test-topic: test-topic}")
    private String testTopic;

    @Value("${pulsar.topic.test-topicA: test-topicA}")
    private String testTopicA;

    @Value("${pulsar.topic.test-topicB: test-topicB}")
    private String testTopicB;

    @Value("${pulsar.topic.test-topicC: test-topicC}")
    private String testTopicC;

    @Value("${pulsar.client.service-pulsar-url}")
    private String servicePulsarUrl;

    @Value("${pulsar.client.service-http-url}")
    private String serviceHttpUrl;

    public String getServiceHttpUrl() {
        return serviceHttpUrl;
    }

    public void setServiceHttpUrl(String serviceHttpUrl) {
        this.serviceHttpUrl = serviceHttpUrl;
    }

    public String getServicePulsarUrl() {
        return servicePulsarUrl;
    }

    public void setServicePulsarUrl(String servicePulsarUrl) {
        this.servicePulsarUrl = servicePulsarUrl;
    }

    public String getTestTopic() {
        return testTopic;
    }

    public void setTestTopic(String testTopic) {
        this.testTopic = testTopic;
    }
}
