import org.jboss.shrinkwrap.api.ShrinkWrap
import org.wildfly.swarm.Swarm
import org.wildfly.swarm.jaxrs.JAXRSArchive

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

fun main(args:Array<String>) {
  val swarm = Swarm()

  val deployment = ShrinkWrap.create(JAXRSArchive::class.java)
  deployment.addClass(HelloKotlinRest::class.java)
  deployment.addAllDependencies()
  swarm.start().deploy(deployment)
}


@Path("/")
class HelloKotlinRest {

  @GET
  //@Produces(MediaType.APPLICATION_JSON)
  fun hello() = "hello: wildfly swarm + gradle + kotlin " + java.util.Date()

}
