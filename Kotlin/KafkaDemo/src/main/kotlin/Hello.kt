package hello

import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.KafkaStreams
import org.apache.kafka.streams.StreamsBuilder
import org.apache.kafka.streams.StreamsConfig
import org.apache.kafka.streams.kstream.Consumed
import java.util.*


fun createProperties(): Properties {
    val properties = Properties()
    properties.setProperty(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:29092")
    properties.setProperty(StreamsConfig.APPLICATION_ID_CONFIG, "my-consumer-1")
    properties.setProperty(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().javaClass.name)
    properties.setProperty(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().javaClass.name)
    return properties;
}

fun main(args : Array<String>) {

    val streamsBuilder = StreamsBuilder()

    val source = streamsBuilder.stream("my-topic", Consumed.with(Serdes.String(), Serdes.String()))
    source.foreach { k, v -> println("Key: $k ,Value: $v") }

    val kafkaStreams = KafkaStreams(streamsBuilder.build(), createProperties())
    kafkaStreams.start()
}
