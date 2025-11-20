package dev.jhon0206.spring_shield.api;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("demo")
public class DemoController {

  @GetMapping("public")
  public String demoPublic() {
    return "Endpoint public";
  }

  @GetMapping("authenticated")
  public String demoAuthenticated() {
    return "Endpoint authenticated";
  }

  @GetMapping("worker")
  public String demoWorker() {
    return "Endpoint worker";
  }

  @GetMapping("admin")
  public String demoAdmin() {
    return "Endpoint admin";
  }

  @GetMapping("vendor")
  public String demoVendor() {
    return "Endpoint vendor";
  }

  @GetMapping("client")
  public String demoClient() {
    return "Endpoint client";
  }

}
