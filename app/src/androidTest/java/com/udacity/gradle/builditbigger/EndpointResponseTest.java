package com.udacity.gradle.builditbigger;

import android.support.v4.util.Pair;
import android.test.AndroidTestCase;
import android.util.Log;

import org.junit.Test;

/**
 * Created by Tauseef Ahmad on 8/13/2016.
 */
public class EndpointResponseTest extends AndroidTestCase {
    String response = null;
    @Test
    public void chechResponsetest(){
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();
        endpointsAsyncTask.execute(new Pair(getContext(),"test"));
        try {
            response = endpointsAsyncTask.get();
            Log.d("tauseef",response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(response);
    }
}
