package sa.edu.twuaiq.jsonarrayexample

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IProductsApi {

    /***
     * REQUEST METHOD
    Every method must have an HTTP annotation that provides the request method and relative URL.
    There are eight built-in annotations: HTTP, GET, POST, PUT, PATCH, DELETE, OPTIONS and HEAD.
    The relative URL of the resource is specified in the annotation.
     * */

    /***
     * Query parameters are added with the @Query annotation on a method parameter.
     * They are automatically added at the end of the URL.
     * */
    @GET("/products")
    fun getListProducts(
        @Query("limit") limit: Int
    ) : Call<List<ProductModel>>
}