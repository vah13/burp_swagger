import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import io.swagger.models.HttpMethod;
import io.swagger.models.Operation;
import io.swagger.models.Path;
import io.swagger.models.Response;
import io.swagger.models.Swagger;
import io.swagger.models.parameters.Parameter;
import io.swagger.parser.SwaggerParser;
import org.json.JSONException;

public class main {
    public static void main(String [] argv) throws IOException, JSONException {
        Swagger swagger = new SwaggerParser().read("C:\\Users\\vava\\Desktop\\work\\207\\swagger.json");
        Map<String, Path> paths = swagger.getPaths();
        for (Map.Entry<String, Path> p : paths.entrySet()) {
            Path path = p.getValue();
            Map<HttpMethod, Operation> operations = path.getOperationMap();
            for (Map.Entry<HttpMethod, Operation> o : operations.entrySet()) {
                System.out.println("===");
                System.out.println("HOST: " + swagger.getHost());
                System.out.println("BASEPATH: " + swagger.getBasePath());
                System.out.println("PATH: " + p.getKey());
                System.out.println("Http method: " + o.getKey());
                System.out.println("Summary: " + o.getValue().getSummary());
                System.out.println("Parameters number: " + o.getValue().getParameters().size());
                for (Parameter parameter : o.getValue().getParameters()) {
                    System.out.println(" - " + parameter.getName());
                }
                System.out.println("Responses:");
                for (Map.Entry<String, Response> r : o.getValue().getResponses().entrySet()) {
                    System.out.println(" - " + r.getKey() + ": " + r.getValue().getDescription());
                }
                System.out.println("");
            }

        }

    }

}
