package com.gzeinnumer.mybasecode.base.response;


import com.google.gson.annotations.SerializedName;

import java.util.List;

/*
{
   "status" : "1",
   "title" : "Success",
   "message" : "Success",
   "total" : 2
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
@GET("")
Call<Response<BaseListResponse<ResponseLogin>>> getUserCall();
 */
public class BaseListResponse<T> {

    @SerializedName("status")
    private String status;

    @SerializedName("title")
    private String title;

    @SerializedName("message")
    private String message;

    @SerializedName("total")
    private int total;

    @SerializedName("data")
    private List<T> data;

    public String getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public int getTotal() {
        return total;
    }

    public List<T> getData() {
        return data;
    }
}
