package com.vishwa.microservice1;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


//@FeignClient(name="MC2Client", url="http://localhost:7072/")
@FeignClient(name="MICROSERVICE2")
public interface Microservice2Client {

  @GetMapping("/ms2/v1/messages")
  public String getMessage();
}
