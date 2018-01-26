import org.jboss.arquillian.drone.api.annotation.Drone
import org.jboss.arquillian.junit.Arquillian
import org.junit.Test
import org.junit.runner.RunWith
import org.openqa.selenium.WebDriver
import org.wildfly.swarm.it.AbstractIntegrationTest

import org.fest.assertions.Assertions.assertThat

@RunWith(Arquillian::class.java)
internal class JAXRSApplicationIT : AbstractIntegrationTest() {

    @Drone
    val browser : WebDriver

    @Test
    fun testIt() {
        browser.navigate().to("http://localhost:8080/")
        assertThat(browser.pageSource).contains("hello: wildfly swarm + gradle + kotlin ")
    }
}
