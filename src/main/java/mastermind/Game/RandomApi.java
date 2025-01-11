package mastermind.Game;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class RandomApi
{
    public static HashMap<Integer, Integer> generatePattern(int length, int min, int max) throws Exception {
        String defaultUrl = String.format(
                "https://www.random.org/integers/?num=4&min=0&max=7&col=1&base=10&format=plain&rnd=new",
                length, min, max
        );

        URL url = new URL(defaultUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        HashMap<Integer, Integer> pattern = new HashMap<>();
        String line;
        int position = 0;
        while ((line = reader.readLine()) != null) {
            pattern.put(Integer.parseInt(line.trim()), position);
            position++;
        }
        reader.close();
        if (pattern.size() != length) {
            System.out.println("Loading...");
            return generatePattern(4,0,7);
    }
        return pattern;
    }
}

