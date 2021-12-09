package com.aikaki.authenticatorautho;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.aikaki.aikakiautho.Utils.Constant;
import com.aikaki.aikakiautho.networking.NetworkingHelpers;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class AuthO {

AuthO(){
    // avoiding instantiation
}


    public static String Create_Sesion () {



//            if(sessionResult.getStatus() != FaceTecSessionStatus.SESSION_COMPLETED_SUCCESSFULLY) {
//                NetworkingHelpers.cancelPendingRequests();
//                faceScanResultCallback.cancel();
//                return;
//            }


            JSONObject parameters = new JSONObject();
//            try {
////                parameters.put("faceScan", sessionResult.getFaceScanBase64());
////                parameters.put("auditTrailImage", sessionResult.getAuditTrailCompressedBase64()[0]);
////                parameters.put("lowQualityAuditTrailImage", sessionResult.getLowQualityAuditTrailCompressedBase64()[0]);
////                parameters.put("externalDatabaseRefID",""
//
//              //  );
//            }
//            catch(JSONException e) {
//                e.printStackTrace();
//                Log.d("FaceTecSDKSampleApp", "Exception raised while attempting to create JSON payload for upload.");
//            }

            //
            // Part 5:  Make the Networking Call to Your Servers.  Below is just example code, you are free to customize based on how your own API works.
            //
            okhttp3.Request request = new okhttp3.Request.Builder()
//            .url(Constant.shared_zoom_url + "/enrollment-3d")
                    .url(Constant.Base_url + "/enrollment-3d")
                    .header("Content-Type", "application/json")
                    .build();



            //
            // Part 8:  Actually send the request.
            //
            NetworkingHelpers.getApiClient().newCall(request).enqueue(new Callback() {
                @Override
                public void onResponse(Call call, okhttp3.Response response) throws IOException {

                    String responseString = response.body().string();
                    response.body().close();
                    try {
                        JSONObject responseJSON = new JSONObject(responseString);


                        boolean didSucceed = responseJSON.getBoolean("success");

                        if (didSucceed == true) {

//                            isSuccess = true;
//
//                            FaceTecCustomization.overrideResultScreenSuccessMessage = "Enrollment\nSucceeded";
//                            faceScanResultCallback.succeed();
                        }
                        else if (didSucceed == false) {
                            // CASE:  In our Sample code, "success" being present and false means that the User Needs to Retry.
                            // Real Users will likely succeed on subsequent attempts after following on-screen guidance.
                            // Attackers/Fraudsters will continue to get rejected.
//                            faceScanResultCallback.retry();
                        }
                        else {
                            // CASE:  UNEXPECTED response from API.  Our Sample Code keys of a success boolean on the root of the JSON object --> You define your own API contracts with yourself and may choose to do something different here based on the error.
                           // faceScanResultCallback.cancel();
                        }
                    }
                    catch(JSONException e) {
                        // CASE:  Parsing the response into JSON failed --> You define your own API contracts with yourself and may choose to do something different here based on the error.  Solid server-side code should ensure you don't get to this case.
                        e.printStackTrace();
                        Log.d("FaceTecSDKSampleApp", "Exception raised while attempting to parse JSON result.");
                       // faceScanResultCallback.cancel();
                    }
                }

                @Override
                public void onFailure(Call call, IOException e) {
                    // CASE:  Network Request itself is erroring --> You define your own API contracts with yourself and may choose to do something different here based on the error.
                    Log.d("FaceTecSDKSampleApp", "Exception raised while attempting HTTPS call.");
                   // faceScanResultCallback.cancel();
                }
            });

            //
            // Part 9:  For better UX, update the User if the upload is taking a while.  You are free to customize and enhance this behavior to your liking.
            //
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                @Override
                public void run() {
//                    if(faceScanResultCallback == null) { return; }
//                    faceScanResultCallback.uploadMessageOverride("Still Uploading...");
                }
            }, 6000);







    return "";
    }









}
