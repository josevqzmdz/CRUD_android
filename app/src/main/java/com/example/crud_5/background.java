package com.example.crud_5;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

class background extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... strings) {
        String result = "";
        String usuario = strings[0];
        String contrasena = strings[1];

        String link = "http://192.168.126.1/CRUD_5/post_metodo.php";
        try{
            URL url = new URL(link);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoInput(true);
            http.setDoOutput(true);

            OutputStream ops = http.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(ops, "UTF-8"));
            String data = URLEncoder.encode("nombre","UTF-8")+"="+URLEncoder.encode(usuario,"UTF-8")
                    +"&&"+URLEncoder.encode("contrasena","UTF-8")+"="+URLEncoder.encode(contrasena,"UTF-8");

            writer.write(data);
            writer.flush();
            writer.close();
            ops.close();

            InputStream ips = http.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(ips, "ISO-8859-1"));
            String line = "";
            while ((line = reader.readLine()) != null){
                result += line;
            }

            reader.close();
            ips.close();
            http.disconnect();
            return result;

        }catch (MalformedURLException e){
            result = e.getMessage();
        }catch (IOException e){
            result = e.getMessage();
        }

        return result;
    }
}
