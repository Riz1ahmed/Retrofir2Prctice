
import com.exmple.retrofitpractice.NoInternetException
import com.exmple.retrofitpractice.RetroApiException
import com.exmple.retrofitpractice.model.ErrorResponse
import com.google.gson.Gson
import org.json.JSONException
import retrofit2.Response

/**
 * @author Anis Parvez
 * Created on 27,June,2021
 */
abstract class SafeApiRequest {
    suspend fun <T : Any> apiRequest(call: suspend () -> Response<T>): T {
        val response: Response<T>

        try {
            response = call.invoke()
        } catch (e: Exception) {
            if (e is NoInternetException) {
                throw NoInternetException(e.message.toString())
            } else {
                throw RetroApiException(e.message.toString())
            }
        }

        val responseBody = response.body()
        if (response.isSuccessful && responseBody != null) return responseBody

        val error = response.errorBody()?.source().toString()
        val message = StringBuilder()

        error.let {
            try {
                val messageData : String
                when {
                    response.code() == 400 -> {
                        messageData = if(it.contains("display_message")) {
                            val text = it.removePrefix("[text=")
                            val data = text.removeSuffix("]")
                            val errorResponse = Gson().fromJson(data, ErrorResponse::class.java)
                            errorResponse.error[0]
                        } else {
                            "Something went wrong."
                        }
                    }
                    response.code() == 401 -> messageData =  "Unauthorized Error."
                    response.code() == 403 -> messageData =  "Permission Denied."
                    response.code() == 404 -> messageData =  "Not found."
                    response.code() == 500 -> messageData =  "Internal Server error."
                    else -> messageData =  "Something went wrong."
                }
                message.append(messageData)
                message.append("\n")
            } catch (e: JSONException) {
                e.printStackTrace()
            }
        }
        message.append("Error Code: ${response.code()}")
        throw RetroApiException(message.toString())
    }
}