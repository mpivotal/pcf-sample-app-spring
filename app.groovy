@Grab("thymeleaf-spring4")

@Controller
class Application {
	@RequestMapping("/")
	public String greeting() {
		return "greeting"
	}
}
