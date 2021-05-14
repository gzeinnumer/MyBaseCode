package com.gzeinnumer.mybasecode.base.response;


import com.google.gson.annotations.SerializedName;

/*
{
   "status" : "1",
   "message" : "Success",
   "data" : {
      "" : "",
      "" : "",
      "" : ""
   }
}
*/
/*
@GET("/users/{id}")
Call<Response<BaseObjectResponse<ResponseLogin>>> getUserCall();
 */
public class BaseObjectResponse<T> {

    @SerializedName("status")
    private String status;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private T data;

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
