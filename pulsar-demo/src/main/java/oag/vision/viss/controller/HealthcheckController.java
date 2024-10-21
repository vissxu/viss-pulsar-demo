package oag.vision.viss.controller;


import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClientException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/healthcheck")
public class HealthcheckController {

//    private final Producer pulsarProducer;
//    public HealthcheckController(Producer pulsarProducer) {
//        this.pulsarProducer = pulsarProducer;
//    }

    @GetMapping("")
    public String healthcheck() {
        return "OKOKOK";
    }

    @GetMapping("/produce")
    public String produce() throws PulsarClientException {
//        pulsarProducer.send("This is a test message");
        return "OKOKOK";
    }


    @GetMapping("/consume")
    public String consume() {

        return "OKOKOK";
    }
}
