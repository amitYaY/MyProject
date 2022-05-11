package com.amyay;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.List;
import java.util.logging.*;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

public class HttpURLConnectionTest {

    private static Logger log = Logger.getLogger("HttpURLConnectionTest");

    public static void main(String[] args) {
        try {
            URL url = new URL("https://raw.githubusercontent.com/arcjsonapi/HoldingValueCalculator/master/api/holding");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            System.out.println(conn.getResponseCode());
            System.out.println(conn.getResponseMessage());

            InputStream is = conn.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);

            /*BufferedReader br = new BufferedReader(isr);
            while (br.readLine() != null) {
                System.out.println(br.readLine());
            }*/

            Gson gson = new GsonBuilder().create();
            List<HoldingData> data = gson.fromJson(isr, new TypeToken<List<HoldingData>>(){}.getType());
            System.out.println(data.get(0).date);
        } catch (IOException ex) {
            log.log(Level.SEVERE, "Connection Error", ex);
        }
    }

    public class HoldingData{

        private String date;
        private String security;
        private Integer quantity;
        private Double price;
        private String portfolio;

        @Override
        public String toString(){
            return this.date;
        }


        public String getDate(){
            return date;
        }

        public String getSecurity(){
            return security;
        }
        public Integer getQuantity(){
            return quantity;
        }
        public String getPortfolio(){
            return portfolio;
        }

        public void setDate(String data){
            this.date = data;
        }

        public void setSecurity(String security){
            this.security = security;
        }

        public void setQuantity(Integer quantity){
            this.quantity = quantity;
        }

        public void getPortfolio(String portfolio){
            this.portfolio = portfolio;
        }


        public Double getPrice(){
            return price;
        }

        public void setPrice(Double price){
            this.price = price;
        }
    }
}
