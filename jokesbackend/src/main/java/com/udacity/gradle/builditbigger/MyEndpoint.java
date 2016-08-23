/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.udacity.gradle.builditbigger;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import java.io.IOException;

import javax.inject.Named;

import pk.smallapps.myjokes.MyJokes;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "builditbigger.gradle.udacity.com",
                ownerName = "builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /**
     * A simple endpoint method that takes a name and says Hi back
     */
    @ApiMethod(name = "randomJokes")
    public Joke randomJokes(@Named("name") String name) {
        MyJokes myJokes = new MyJokes();
        Joke response = new Joke();
        String jokeText = "";
        try {
            jokeText = myJokes.getRandomJoke();
        } catch (IOException e) {
            e.printStackTrace();
        }
        response.setJokeText(jokeText);
        return response;
    }

}
