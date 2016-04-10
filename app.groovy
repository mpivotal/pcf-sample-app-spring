@Grab("thymeleaf-spring4")

@Controller
class Application {
	@RequestMapping("/")
	public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name)
		return "greeting"
	}
}
