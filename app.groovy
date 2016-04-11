@Grab("thymeleaf-spring4")

import org.springframework.core.env.Environment

@Controller
class Application {

	@Autowired
	private Environment env;

	@RequestMapping("/")
	public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name)
		// For details of what's in the Environment see https://github.com/spring-projects/spring-boot/blob/master/spring-boot/src/main/java/org/springframework/boot/cloud/CloudFoundryVcapEnvironmentPostProcessor.java
		model.addAttribute("application_name", env.getProperty("vcap.application.name", "none"))
		model.addAttribute("app_instance_index", env.getProperty("vcap.application.instance_index"))
		return "greeting"
	}
}
