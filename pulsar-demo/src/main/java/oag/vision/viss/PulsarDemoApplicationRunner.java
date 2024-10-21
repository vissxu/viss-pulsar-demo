package oag.vision.viss;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import oag.vision.viss.config.CommonConfig;
import oag.vision.viss.entity.Employee;
import oag.vision.viss.entity.RequestBody;
import oag.vision.viss.entity.User;
import oag.vision.viss.util.JSONUtil;
import org.apache.pulsar.client.api.BatcherBuilder;
import org.apache.pulsar.client.api.MessageId;
import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.Schema;
import org.apache.pulsar.client.impl.schema.AvroSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class PulsarDemoApplicationRunner implements ApplicationRunner {


    private static Logger logger = LoggerFactory.getLogger(PulsarDemoApplicationRunner.class);

    private final CommonConfig commonConfig;
    private final PulsarClient  pulsarClient;

    public PulsarDemoApplicationRunner(CommonConfig commonConfig, PulsarClient pulsarClient) {
        this.commonConfig = commonConfig;
        this.pulsarClient = pulsarClient;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

//        Producer<RequestBody> producer = pulsarClient.newProducer(Schema.JSON(RequestBody.class))
//                .topic(commonConfig.getTestTopic())
//                .batcherBuilder(BatcherBuilder.KEY_BASED)
//                .create();
//
//        RequestBody body = new RequestBody();
//        Employee employee = new Employee("001", "Xuwei", 33);
//        employee.setTitle("Software Engineer");
//        body.setFrom("test");
//        body.setUser(employee);
//
//        CompletableFuture<MessageId> completableFuture = producer.sendAsync(body);
//        completableFuture.whenComplete(((messageId, throwable) -> {
//            if( null != throwable ) {
//                logger.error("sendAsyncMessage failed: {}", throwable.getMessage(), throwable);
//            } else {
//                try {
//                    logger.info("sendAsyncMessage success: messageId={}, value={}", messageId, JSONUtil.convertToString(body));
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }));
    }
}
