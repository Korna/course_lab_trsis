package com.coma;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.TimeUnit;

import com.coma.service.ExhibitService;
import com.google.common.collect.Iterables;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.kafka.test.rule.KafkaEmbedded;
import org.springframework.kafka.test.utils.ContainerTestUtils;
import org.springframework.test.context.junit4.SpringRunner;
import com.coma.eda.consumer.Receiver;
import com.coma.eda.producer.Sender;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringKafkaApplicationTest {



    @Autowired
    private KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;

    @Autowired
    private ExhibitService exhibitService;

    @Autowired
    private Receiver receiver;

    @Autowired
    private Sender sender;

    protected final static String HELLOWORLD_TOPIC = "helloworld.t";
    @ClassRule
    public static KafkaEmbedded kafkaEmbedded = new KafkaEmbedded(1, true, HELLOWORLD_TOPIC);

    @Before
    public void runBeforeTestMethod() throws Exception {
        for (MessageListenerContainer messageListenerContainer : kafkaListenerEndpointRegistry
                .getListenerContainers()) {
            ContainerTestUtils.waitForAssignment(messageListenerContainer,
                    kafkaEmbedded.getPartitionsPerTopic());
        }
    }

    @Test
    public void testReceiveAndWriteInDatabase() throws Exception {
        String message = "Message";
        assertThat(Iterables.size(exhibitService.listAll())).isEqualTo(3);

        sender.send(HELLOWORLD_TOPIC, message);

        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
        assertThat(receiver.getLatch().getCount()).isEqualTo(0);

        assertThat(Iterables.size(exhibitService.listAll())).isEqualTo(4);

        Assertions.assertThat(Iterables.getLast(exhibitService.listAll()).getAuthor()).isEqualTo(message);
    }
}
