import com.typesafe.config.ConfigFactory

object RenderExample extends App {
    def render(what: String) {
        val conf = ConfigFactory.defaultOverrides()
            .withFallback(ConfigFactory.parseResourcesAnySyntax(classOf[ConfigFactory], "/" + what))
            .withFallback(ConfigFactory.defaultReference())

        println("=== BEGIN UNRESOLVED " + what)
        println(conf.root.render())
        println("=== END UNRESOLVED " + what)

        println("=== BEGIN RESOLVED " + what)
        println(conf.resolve().root.render())
        println("=== END RESOLVED " + what)

        println("=== BEGIN UNRESOLVED toString() " + what)
        println(conf.root.toString())
        println("=== END UNRESOLVED toString() " + what)
    }

    render("test01")
    render("test06")
    render("test05")
}
