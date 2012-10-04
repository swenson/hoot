/*
 * Copyright (C) 2012 Two Toasters, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.twotoasters.android.hoot;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HootResult<T> {

    public boolean isSuccess() {
        return mSuccessfulResponseCodes != null ? mSuccessfulResponseCodes
                .contains(mResponseCode) : sDefaultSuccessfulCodes
                .contains(mResponseCode);
    }

    public T getDeserializedResult() {
        return mResultStorage;
    }

    public String getResponseString() {
        return mResponse;
    }

    public InputStream getResponseStream() {
        return mResponseStream;
    }

    public int getResponseCode() {
        return mResponseCode;
    }

    public Exception getException() {
        return mException;
    }

    public Map<String, List<String>> getHeaders() {
        return mHeaders;
    }

    // -------------------------------------------------------------------------
    // END OF PUBLIC INTERFACE
    // -------------------------------------------------------------------------
    private static List<Integer> sDefaultSuccessfulCodes = new ArrayList<Integer>();
    static {
        sDefaultSuccessfulCodes.add(HttpURLConnection.HTTP_OK);
        sDefaultSuccessfulCodes.add(HttpURLConnection.HTTP_ACCEPTED);
        sDefaultSuccessfulCodes.add(HttpURLConnection.HTTP_CREATED);
    }
    private List<Integer> mSuccessfulResponseCodes = null;
    private T mResultStorage = null;
    private String mResponse;
    private int mResponseCode;
    private Exception mException;
    private Map<String, List<String>> mHeaders;
    private InputStream mResponseStream;

    void setSuccessfulResponseCodes(List<Integer> codes) {
        mSuccessfulResponseCodes = codes;
    }

    void setDeserializedResult(T result) {
        mResultStorage = result;
    }

    void setResponse(String response) {
        mResponse = response;
    }

    void setResponseCode(int responseCode) {
        mResponseCode = responseCode;
    }

    void setException(Exception e) {
        mException = e;
    }

    public void setHeaders(Map<String, List<String>> headerFields) {
        mHeaders = headerFields;
    }

    public void setResponseStream(InputStream responseStream) {
        mResponseStream = responseStream;
    }
}