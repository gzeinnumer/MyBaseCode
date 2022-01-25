package com.gzeinnumer.mybasecode.base.response;


import com.google.gson.annotations.SerializedName;

import java.util.List;

/*
{
    "status": 1,
    "title": "Perhatian",
    "message": "Success",
    "info": {
        "total": 21,
        "totalPage": 3,
        "page": 2,
        "next": 3,
        "prev": 1
    },
    "data": [
        {
            "id": 11,
            "name": "md 11",
            "created_at": "2022-01-09 19:10:38",
            "updated_at": "2022-01-10 13:08:10"
        }
    ]
}
*/
/*
@GET("")
Call<Response<BaseListResponse<ResponseLogin>>> getUserCall();
 */
public class BaseListResponse<T> {

    @SerializedName("data")
    private List<T> data;

    @SerializedName("title")
    private String title;

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private int status;

    @SerializedName("info")
    private Info info;

    public List<T> getData(){
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
