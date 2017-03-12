package com.marknazareno.grpc.spring.boot.demo;

import com.google.common.base.Strings;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.examples.helloworld.GreeterGrpc;
import io.grpc.examples.helloworld.HelloReply;
import io.grpc.examples.helloworld.HelloRequest;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

/**
 * Created by mark on 11/3/17.
 */
@SpringBootApplication
public class DemoClient {

  public static void main(String[] args) {
    SpringApplication.run(DemoClient.class, args);
  }

  @Component
  public static class DemoClientRunner implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(DemoClientRunner.class);

    @Value("${host:localhost}")
    private String host;

    @Value("${port:6565}")
    private int port;

    public void run(String... strings) throws Exception {
      String name = Optional.ofNullable(strings).filter(a -> a.length > 0).map(a -> a[0]).filter(a -> !Strings.isNullOrEmpty(a)).orElse("World");
      ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext(true).build();
      GreeterGrpc.GreeterBlockingStub rpc = GreeterGrpc.newBlockingStub(channel);
      HelloRequest request = HelloRequest.newBuilder().setName(name).build();
      HelloReply reply = rpc.sayHello(request);
      LOG.info(reply.toString());
      channel.shutdownNow();
    }
  }
}
