package com.gzeinnumer.mybasecode.base.response;


import com.google.gson.annotations.SerializedName;

import java.util.List;

/*
{
   "status" : "1",
   "message" : "Success",
   "total" : "total"
   "data" : [
      {
         "" : "",
         "" : ""
      },
      {
         "" : "",
         "" : ""
      }
   ]
}
*/
/*
@GET("/users/{id}")
Call<Response<BaseListResponse<ResponseLogin>>> getUserCall();
 */
public class BaseListResponse<T> {

    @SerializedName("status")
    private String status;

    @SerializedName("message")
    private String message;

    @SerializedName("total")
    private String total;

    @SerializedName("data")
    private List<T> data;

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getTotal() {
        return total;
    }

    public List<T> getData() {
        return data;
    }
}
