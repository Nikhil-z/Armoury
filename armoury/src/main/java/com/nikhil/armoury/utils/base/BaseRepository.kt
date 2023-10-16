package com.nikhil.armoury.utils.base

import com.nikhil.armoury.utils.NetworkUtils
import com.nikhil.armoury.utils.callback.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

open class BaseRepository {
    // we'll use this function in all
    // repos to handle api errors.
    suspend fun <T> armourGuard(api: suspend () -> Response<T>): Resource<T> {

        // Returning api response
        // wrapped in Resource class
        return withContext(Dispatchers.IO) {
            try {

                // Here we are calling api lambda
                // function that will return response
                // wrapped in Retrofit's Response class
                val response: Response<T> = api()

                if (response.isSuccessful && response.body() != null) {
                    // In case of success response we
                    // are returning Resource.Success object
                    // by passing our data in it.
                    Resource.Success(data = response.body()!!)
                } else {
                    // parsing api's own custom json error
                    // response in ExampleErrorResponse pojo
                    //   val errorResponse: ExampleErrorResponse? = convertErrorBody(response.errorBody())
                    // Simply returning api's own failure message
                    Resource.Error(errorMessage = /*errorResponse?.failureMessage ?:*/ "Something went wrong (unSuccessful) ${response.errorBody().toString()}")
                }

            } catch (e: HttpException) {
                // Returning HttpException's message
                // wrapped in Resource.Error
                Resource.Error(errorMessage = e.message ?: "Something went wrong (HttpException)")
            } catch (e: IOException) {
                // Returning no internet message
                // wrapped in Resource.Error
                Resource.Error(NetworkUtils.checkNetworkError(e.message.toString()))
            } catch (e: Exception) {
                // Returning 'Something went wrong' in case
                // of unknown error wrapped in Resource.Error
                Resource.Error(errorMessage = "Something went wrong (Exception)")
            }
        }
    }

    // If you don't wanna handle api's own
    // custom error response then ignore this function
    /* private fun convertErrorBody(errorBody: ResponseBody?): ExampleErrorResponse? {
         return try {
             errorBody?.source()?.let {
                 val moshiAdapter = Moshi.Builder().build().adapter(ExampleErrorResponse::class.java)
                 moshiAdapter.fromJson(it)
             }
         } catch (exception: Exception) {
             null
         }
     }*/
}