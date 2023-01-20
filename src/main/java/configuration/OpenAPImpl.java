package configuration;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.core.Application;


@OpenAPIDefinition(
        tags = {
                @Tag(name = "Planning Poker Menu",
                        description = "This API serves Planning Poker Info")
        },
        info = @Info(
                title = "Swagger with Quarkus",
                version = "0.0.1",
                contact = @Contact(
                        name = "Diego Bufalo",
                        url = "",
                        email = "diego.bufalo14@gmail.com"),
                license = @License(
                        name = "Apache 2.0",
                        url = "http://www.apache.org/licenses/LICENSES-2.0.html"
                )
        )
)
public class OpenAPImpl extends Application {
}
