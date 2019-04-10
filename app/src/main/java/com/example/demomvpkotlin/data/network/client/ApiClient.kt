package com.example.demomvpkotlin.data.network.client

import com.example.demomvpkotlin.data.network.response.DemoResponse
import com.google.gson.JsonObject
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

import java.util.HashMap

interface ApiClient {

    companion object {
        val ERROR_CODE = 0
        val WARNING_CODE = 1
        val SUCCESS_CODE = 2
        val NO_INTERNET_CODE = 3
        val ERROR_CONNECTION_CODE = 4
        val ERROR_UNDEFINE_CODE = 5
        val RESPONSE_CODE_SUCCESS = 200
        val RESPONSE_CODE_INVALID_TOKEN = 401
        val RESPONSE_CODE_BAD_REQUEST = 400
        val RESPONSE_CODE_DATA_CHANGED = 409
        val RESPONSE_MESSAGE_OK = "OK "
        val HEADER_AUTHORIZATION = "Authorization"
        val HEADER_ACCOUNT_ID = "AccountId"
        val HEADER_LANG = "Accept-Language"
        val HEADER_API_KEY = "x-api-key"
        val HEADER_HEAD_TOKEN = "BEARER "
        val HEADER_CONTENT_TYPE = "Content-Type"
        val HEADER_CONTENT_TYPE_VALUE_JSON = "application/json"
        val HEADER_CONTENT_TYPE_VALUE = "application/x-www-form-urlencoded"
        val ERROR_CODE_STRING_OK = "0"
        /**
         * Use for upload image --> part
         */
        val UPLOAD_IMAGE_PART = "file\"; filename=\"_img.png\" "
        /**
         * Use for upload image --> Content type
         */
        val HEADER_CONTENT_TYPE_IMAGE = "multipart/form-data"
        val MEDIA_TYPE_IMAGE = MediaType.parse("image/png")
    }

    @GET("/api/unknown")
    fun getDemoData():Call<DemoResponse>


    //    @POST("auth")
    //    Call<LoginResponse> login(@HeaderMap HashMap<String, Object> header,
    //                              @Body LoginParam param);

//    @POST("getAccountById")
//    fun getAccountById(
//        @HeaderMap header: HashMap<String, Any>,
//        @Body param: AccountParam
//    ): Call<BaseResponse<AccountResponse>>
//
//
//    @POST("getBusStops")
//    fun getBusStop(@HeaderMap header: HashMap<String, Any>): Call<BaseListResponse<List<FindBusStopResponse>, FindBusStopResponse>>
//
//
//    @POST("getListBusStop")
//    fun getListBusServiceForListBusStop(
//        @HeaderMap header: HashMap<String, Any>,
//        @Body listBusStopCode: BusServiceListForBusStopListParam
//    ): Call<BaseListResponse<List<BusServiceFollowBusStopResponse>, BusServiceFollowBusStopResponse>>
//
//    @POST("getRouteForBusService")
//    fun getRouteForBusService(
//        @HeaderMap header: HashMap<String, Any>,
//        @Body lstServiceNo: RouteForBusServiceParam
//    ): Call<BaseListResponse<List<RouteForBusServiceResponse>, RouteForBusServiceResponse>>
//
//    @POST("getOneMapToken")
//    fun getOneMapToken(@HeaderMap header: HashMap<String, Any>): Call<BaseResponse<OneMapTokenResponse>>
//
//    @POST("getHereMapKeys")
//    fun getHereMapKeys(@HeaderMap header: HashMap<String, Any>): Call<BaseResponse<HereMapKeyModel>>
//
//    @POST("getMapBoxKey")
//    fun getMapBoxKey(@HeaderMap header: HashMap<String, Any>): Call<BaseResponse<MapBoxKeyResponse>>
//
//    @POST("getBusServiceFollowBusStop")
//    fun getBusServiceFollowBusStop(
//        @HeaderMap header: HashMap<String, Any>,
//        @Body busStopParam: BusServiceFollowBusStopParam
//    ): Call<BaseListResponse<List<BusServiceFollowBusStopResponse>, BusServiceFollowBusStopResponse>>
//
//    @POST("getUserProfile")
//    fun getUserProfile(
//        @HeaderMap header: HashMap<String, Any>,
//        @Body busStopParam: UserProfileParam
//    ): Call<BaseResponse<UserProfileResponse>>
//
//    @POST("getRouteForBusService")
//    fun getBusServiceDetail(
//        @HeaderMap header: HashMap<String, Any>,
//        @Body listServiceNo: BusServiceDetailParam
//    ): Call<BaseListResponse<List<BusServiceDetailResponse>, BusServiceDetailResponse>>
//
//    @Multipart
//    @PUT("setEventReport")
//    fun setEventReport(
//        @HeaderMap header: HashMap<String, Any>,
//        @Part photo: MultipartBody.Part,
//        @Part("Date") date: RequestBody,
//        @Part("Type") type: RequestBody,
//        @Part("Latitude") latitude: RequestBody,
//        @Part("Longitude") longitude: RequestBody,
//        @Part("Description") description: RequestBody,
//        @Part("Status") status: RequestBody,
//        @Part("AccountId") accountId: RequestBody,
//        @Part("DeviceId") deviceId: RequestBody
//    ): Call<BaseResponse<ReportResponse>>
//
//    @Multipart
//    @POST("uploadMultipleLogFiles")
//    fun uploadLogFiles(
//        @HeaderMap header: HashMap<String, Any>,
//        @Part logFiles: Array<MultipartBody.Part>,
//        @Part("Date") date: RequestBody,
//        @Part("Type") type: RequestBody,
//        @Part("AccountId") accountId: RequestBody,
//        @Part("DeviceId") deviceId: RequestBody
//    ): Call<Any>
//
//    @PUT("setRoutequery")
//    fun setRoutequery(
//        @HeaderMap header: HashMap<String, Any>,
//        @Body setRouteQueryParams: SetRouteQueryParams
//    ): Call<BaseResponse<SetRouteQueryResponse>>
//
//    @PUT("addEventCalendar")
//    fun addEventCalendar(
//        @HeaderMap header: HashMap<String, Any>,
//        @Body json: JsonObject
//    ): Call<ResponseModel>
//
//    @POST("getDevice")
//    fun getDevice(
//        @HeaderMap header: HashMap<String, Any>,
//        @Body deviceInfoParam: DeviceInfoParam
//    ): Call<BaseResponse<DeviceInfoResponse>>
//
//    @PUT("updateShareLocation")
//    fun updateShareLocation(
//        @HeaderMap header: HashMap<String, Any>,
//        @Body shareLocationParam: UpdateShareLocationParam
//    ): Call<BaseResponse<DeviceInfoResponse>>
//
//    @PUT("updateLocation")
//    fun updateLocation(
//        @HeaderMap header: HashMap<String, Any>,
//        @Body locationModel: LocationModel
//    ): Call<ResponseModel>


}