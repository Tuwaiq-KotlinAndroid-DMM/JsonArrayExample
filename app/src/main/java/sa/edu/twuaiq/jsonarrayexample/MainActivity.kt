package sa.edu.twuaiq.jsonarrayexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private val products = mutableListOf<ProductModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val productRecyclerView: RecyclerView = findViewById(R.id.product_recyclerview)
        val productsAdapter = ProductsRecyclerViewAdapter(products)

        productRecyclerView.adapter = productsAdapter


        /***
         *
         * To work with Retrofit you basically need the following three classes:

        Model class which is used as a JSON model

        Interfaces that define the possible HTTP operations

        Retrofit.Builder class - Instance which uses the interface and the Builder API to allow defining the URL end point for the HTTP operations.
         * */

        // Retrofit.Builder
        // And we need to specify a factory for deserializing the response using the Gson library
        val retrofit = Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        //  Builder API
        val productApi = retrofit.create(IProductsApi::class.java)

        // Calling the API Methods and handles the result
        productApi.getListProducts(3).enqueue(object : Callback<List<ProductModel>> {
            override fun onResponse(
                call: Call<List<ProductModel>>,
                response: Response<List<ProductModel>>
            ) {
                

                response.body()?.run {
                    products.addAll(this)
                    productsAdapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<List<ProductModel>>, t: Throwable) {
            }

        })


    }
}