@Grab("thymeleaf-spring4")

import org.springframework.core.env.Environment

@Controller
class Application {

  @Autowired
  private Environment env;

  @RequestMapping("/")
  public String index(Model model) {
    // For details of what's in the Environment see https://github.com/spring-projects/spring-boot/blob/master/spring-boot/src/main/java/org/springframework/boot/cloud/CloudFoundryVcapEnvironmentPostProcessor.java
    model.addAttribute("application_name", env.getProperty("vcap.application.name", "@application_name"))
    model.addAttribute("app_instance_index", env.getProperty("vcap.application.instance_index", "@app_instance_index"))
    model.addAttribute("application_mem_limits", env.getProperty("vcap.application.limits.mem", "@application_mem_limits"))
    model.addAttribute("vcap_services", env.getProperty("vcap.services")) // how do we get properties for a service when we don't necessarily know the name?
    return "index"
  }
}
