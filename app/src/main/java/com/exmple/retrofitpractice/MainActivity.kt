package com.exmple.retrofitpractice

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.exmple.retrofitpractice.databinding.ActivityMainBinding
import com.exmple.retrofitpractice.model.SignedData.token
import com.exmple.retrofitpractice.model.product.ProductData
import com.exmple.retrofitpractice.model.shop.ShopData
import com.exmple.retrofitpractice.model.signin.SignInUser
import com.exmple.retrofitpractice.model.signin.SigninSuccRsp
import com.exmple.retrofitpractice.model.signup.SignupUser
import com.exmple.retrofitpractice.network.ApiInterface
import com.exmple.retrofitpractice.network.RetrofitApiClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainViewModel

    private val apiInterface: ApiInterface = RetrofitApiClient.getApiInterface(this)
    //RetrofitApiClient.getClient().create(ApiInterface::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //showMyIp()

        Handler(Looper.getMainLooper()).postDelayed({
            //signUpReq()
            signInReq()
        }, 2000)
    }

    /*private fun signUpReq() {
        Log.d("TAG", "signInReq: Sign Up")
        apiInterface.signupUser(
            SignupUser(fullName = "Rizwan Ahmed", password = "123456", phoneNo = "0175384108")
        ).enqueue(object : Callback<SignupSuccRsp> {
            override fun onResponse(
                call: Call<SignupSuccRsp>, succRsp: Response<SignupSuccRsp>
            ) {
                if (succRsp.isSuccessful) {
                    val serverResponse = succRsp.body()
                    Log.d("TAG", "onResponse signin Token: ${serverResponse?.token}")
                    Log.d("TAG", "onResponse userInfo: ${serverResponse?.userInfo}")
                } else {
                    *//*val errorResponse = Gson().fromJson<SignupErrorResponse>(errorJson,
                        object : TypeToken<SignupErrorResponse>() {}.type)*//*
                    val errorJson = succRsp.errorBody()!!.charStream().readText()
                    val er = GSonUtils.fromJson<SignupErrResp>(errorJson)
                    Log.d("TAG", "onResponse error: ${er}")
                }
            }

            override fun onFailure(call: Call<SignupSuccRsp>, t: Throwable) {
                Log.d("TAG", "onResponse failed: ${t.message}")
            }
        })
    }*/

    private fun signUpUser() {
        Log.d("TAG", "signUpReq: Sign In")
        CoroutineScope(IO).launch {
            try {
                apiInterface.signupUser(
                    SignupUser(
                        fullName = "Rizwan Ahmed",
                        password = "123456",
                        phoneNo = "0175384108"
                    )
                ).let {
                    withContext(Main) {
                        if (it.isSuccessful) {
                            Log.d(TAG, "signUpReq: Success")
                        } else {
                            Log.d(TAG, "signUpReq: failed code:${it.code()}")
                        }
                    }
                }
            } catch (e: IOException) {
                Log.d(TAG, "signUpReq Error: ${e.message}")
            }
        }
    }

    private fun signInReq() {
        Log.d("TAG", "signInReq: Sign In")
        CoroutineScope(IO).launch {
            try {
                apiInterface.signInUser(
                    SignInUser(password = "123456", userName = "01775384108")
                ).let {
                    withContext(Main) {
                        Log.d(TAG, "signInReq: Response code: ${it.code()}")
                        if (it.isSuccessful) {
                            userSignedSuccessful(it.body()!!)
                            Log.d(TAG, "signInReq: Success")
                        } else {
                            Log.d(TAG, "signInReq: failed")
                        }
                    }
                }
            } catch (e: IOException) {
                Log.d(TAG, "signInReq: ${e.message}")
            }
        }

        /*apiInterface.signInUser(
            SignInUser(password = "123456", userName = "0175384108")
        ).enqueue(object : Callback<SigninSuccRsp> {
            override fun onResponse(
                call: Call<SigninSuccRsp>, succRsp: Response<SigninSuccRsp>
            ) {
                if (succRsp.isSuccessful) {
                    val serverResponse = succRsp.body()
                    Log.d("TAG", "onResponse userInfo token: ${serverResponse?.token}")
                    token = serverResponse?.token
                    Log.d("TAG", "onResponse userInfo: ${serverResponse?.userInfo}")

                    createShop()
                } else {
                    *//*val errorResponse = Gson().fromJson<SignupErrorResponse>(errorJson,
                        object : TypeToken<SignupErrorResponse>() {}.type)*//*
                    val errorJson = succRsp.errorBody()!!.charStream().readText()
                    val er = GSonUtils.fromJson<SigninErrResp>(errorJson)
                    Log.d("TAG", "onResponse error: ${er}")
                }
            }

            override fun onFailure(call: Call<SigninSuccRsp>, t: Throwable) {
                Log.d("TAG", "onResponse failed: ${t.message}")
            }
        })*/
    }

    private fun userSignedSuccessful(signedRsp: SigninSuccRsp) {
        token = signedRsp.token
        Log.d(TAG, "signInSuccess: token: $token")
        //createShop()
        createProduct()
    }

    fun createShop() {
        CoroutineScope(IO).launch {
            RetrofitApiClient.getApiInterface(this@MainActivity)
                .createShop(ShopData("Liilab supershop", "tarango", 0f)).let { rsp ->
                    if (rsp.isSuccessful) {
                        Log.d(TAG, "createShop: shop Created")
                    } else {
                        Log.d(TAG, "createShop: shop Created failed")
                    }
                }
        }
        /*RetrofitApiClient.getApiInterface(this).createShop(ShopData("abc", "tarango", 0f))
            .enqueue(object : Callback<ShopCreateSuccResp> {
                override fun onResponse(
                    call: Call<ShopCreateSuccResp>, response: Response<ShopCreateSuccResp>
                ) {
                    if (response.isSuccessful) {
                        val x=response.body()
                        Log.d(TAG, "onResponse: Shop created: $x")
                    } else {
                        Log.d(TAG, "onResponse: Shop created failed")

                        *//*val er = response.errorBody()
                        Log.d(TAG, "onResponse: Error: $er")*//*

                        val errorJson = response.errorBody()!!.charStream().readText()
                        //val er = Gson().fromJson(errorJson, ShopCreateErrResp::class.java)
                        val er = GSonUtils.fromJson<ShopCreateErrResp>(errorJson)
                        Log.d("TAG", "onResponse error: ${er}")
                    }
                }

                override fun onFailure(call: Call<ShopCreateSuccResp>, t: Throwable) {
                    Log.d(TAG, "onFailure: connection failed")
                }

            })*/
    }

    private fun createProduct() {
        CoroutineScope(IO).launch {
            RetrofitApiClient.getApiInterface(this@MainActivity)
                .createProduct(
                ProductData(
                    sku = "123456789",
                    brand = "RFL",
                    title = "Waterpot",
                    measurement = "100",
                    tags = "a b c d",
                    //isManualBarcode = true,
                    note = "this sample note",
                    unit = 1,
                    shop = 1,
                    images = listOf(1)
                )
            ).let {
                Log.d(TAG, "createProduct: Response code: ${it.code()}")
            }
        }
    }

    private fun createStock(){
        CoroutineScope(IO).launch {
            RetrofitApiClient.getApiInterface(this@MainActivity).addPurchase()
        }
    }

    /*private fun showMyIp() {
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
    }*/

    companion object {
        const val TAG = "tag"
    }
}