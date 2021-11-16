package com.exmple.retrofitpractice

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.exmple.retrofitpractice.databinding.ActivityMainBinding
import com.exmple.retrofitpractice.model.ServerResponse
import com.exmple.retrofitpractice.model.SignupErrResp
import com.exmple.retrofitpractice.model.SignupSuccRsp
import com.exmple.retrofitpractice.model.SignupUser
import com.exmple.retrofitpractice.network.ApiInterface
import com.exmple.retrofitpractice.network.RetrofitApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private val apiInterface: ApiInterface =
        RetrofitApiClient.getClient().create(ApiInterface::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //showMyIp()

        Handler(Looper.getMainLooper()).postDelayed({
            signUpReq()
        }, 3000)
    }

    private fun signUpReq() {
        apiInterface.signupUser(
            SignupUser(fullName = "", password = "", phoneNo = "")
        ).enqueue(object : Callback<SignupSuccRsp> {
            override fun onResponse(
                call: Call<SignupSuccRsp>, succRsp: Response<SignupSuccRsp>
            ) {
                if (succRsp.isSuccessful) {
                    val serverResponse = succRsp.body()
                    Log.d("TAG", "onResponse userInfo: ${serverResponse?.userInfo}")
                } else {
                    /*val errorResponse = Gson().fromJson<SignupErrorResponse>(errorJson,
                        object : TypeToken<SignupErrorResponse>() {}.type)*/
                    val errorJson = succRsp.errorBody()!!.charStream().readText()
                    val er = GSonUtils.fromJson<SignupErrResp>(errorJson)
                    Log.d("TAG", "onResponse error: ${er}")
                }
            }

            override fun onFailure(call: Call<SignupSuccRsp>, t: Throwable) {
                Log.d("TAG", "onResponse failed: ${t.message}")
            }
        })
    }


    private fun showMyIp() {
        Log.d("TAG", "showMyIp: Calling to API")

        apiInterface.getMyIp()?.enqueue(object : Callback<ServerResponse?> {
            override fun onResponse(
                call: Call<ServerResponse?>, response: Response<ServerResponse?>
            ) {
                val serverResponse: ServerResponse? = response.body()
                if (response.code() == 200 && serverResponse != null) { //response code 200 means server call successful
                    //data found. So place the data into TextView
                    var txt = ""
                    txt += "IP=${serverResponse.ip}\n"
                    txt += "City=${serverResponse.city}\n"
                    txt += "Country=${serverResponse.country}\n"
                    binding.textview.text = txt
                } else {
                    //somehow data not found. So error message showing in TextView
                    binding.textview.text = "Not found Message=${response.message()}"
                }
            }

            override fun onFailure(call: Call<ServerResponse?>, t: Throwable) {
                //network call failed due to disconnect internet connection or server error
                binding.textview.text = "onResponse: Failed=${t.message}"
            }
        })
    }
}