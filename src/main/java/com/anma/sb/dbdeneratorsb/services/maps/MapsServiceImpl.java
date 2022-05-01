package com.anma.sb.dbdeneratorsb.services.maps;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.GeocodingApiRequest;
import com.google.maps.PendingResult;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Service
public class MapsServiceImpl implements MapsService {

    @Autowired
    private final Environment environment;

    public MapsServiceImpl(Environment environment) {
        this.environment = environment;
    }

    public void getPlace() {

        try {
            var ctxAddress = "Kyiv";
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            GeoApiContext context = new GeoApiContext.Builder()
                    .apiKey(environment.getProperty("MAPS_API_KEY"))
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .maxRetries(3)
                    .build();
//
            GeocodingResult[] results = GeocodingApi.geocode(context, ctxAddress).await();

            System.out.println(gson.toJson(results[0].addressComponents));

            // Second
            GeocodingApiRequest req = GeocodingApi.newRequest(context).address("Sydney");
//
            GeocodingResult[] results2 = req.await();
            System.out.println(Arrays.toString(results2));

            // Async
            req.setCallback(new PendingResult.Callback<GeocodingResult[]>() {
                @Override
                public void onResult(GeocodingResult[] result) {
                    System.out.println(result);
                }

                @Override
                public void onFailure(Throwable e) {
                    e.printStackTrace();
                }
            });

            // Invoke .shutdown() after your application is done making requests
            context.shutdown();

        } catch (ApiException | IOException | InterruptedException e) {
            e.printStackTrace();
        }


    }
}
