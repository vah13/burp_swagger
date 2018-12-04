import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class main {
    public static void main(String [] argv) throws IOException, JSONException {
        String content = new String(Files.readAllBytes(Paths.get("C:\\Users\\vava\\Desktop\\swagger.json")));

        JSONObject obj = new JSONObject(content);
        JSONObject paths = obj.getJSONObject("paths");

        for (int i=0; i< paths.names().length(); i++) {
            pprint("-", 25);
            JSONObject methods = paths.getJSONObject((String) paths.names().get(i));
            System.out.println(paths.names().get(i));

            for (int j=0; j<methods.length(); j++) {
                System.out.println(methods.names().get(j));

                JSONObject headers = methods.getJSONObject((String) methods.names().get(j));
                for (int h = 0; h < headers.length(); h++) {
                    System.out.println(headers.names().get(h));
                }

            }


        }
    }

    private static void pprint(String s, int _i)
    {
        String _s = "";
        for (int i=0;i<_i;i++)
        {
            _s += s;
        }
        System.out.println(_s);
    }
}
