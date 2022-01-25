package com.gzeinnumer.mybasecode.base.response;


import com.google.gson.annotations.SerializedName;

/*
{
    "status": 1,
    "title": "Perhatian",
    "message": "Success",
    "info": {
        "total": 1,
        "totalPage": null,
        "page": null,
        "next": null,
        "prev": null
    },
    "data": {
        "id": 1,
        "name": "zein",
        "created_at": "2022-01-09 14:53:35",
        "updated_at": "2022-01-09 21:54:14"
    }
}
*/
/*
@GET("")
Call<Response<BaseObjectResponse<ResponseLogin>>> getUserCall();
 */
public class BaseObjectResponse<T> {

    @SerializedName("data")
    private T data;

    @SerializedName("title")
    private String title;

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private int status;

    @SerializedName("info")
    private Info info;

    public T getData(){
        return data;
    }

    public String getTitle(){
        return title;
    }

    public String getMessage(){
        return message;
    }

    public int getStatus(){
        return status;
    }

    public Info getInfo(){
        return info;
    }
}
