package com.marknazareno.grpc.spring.boot.demo;

import io.grpc.examples.helloworld.GreeterGrpc;
import io.grpc.examples.helloworld.HelloReply;
import io.grpc.examples.helloworld.HelloRequest;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by mark on 11/3/17.
 */
@SpringBootApplication
public class DemoServer {
  public static void main(String[] args) {
    SpringApplication.run(DemoServer.class, args);
  }

  @GRpcService
  public static class GreeterService extends GreeterGrpc.GreeterImplBase {
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
      HelloReply reply = HelloReply.newBuilder().setMessage("Hello " + request.getName()).build();
      responseObserver.onNext(reply);
      responseObserver.onCompleted();
    }
  }
}
