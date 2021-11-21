package com.exmple.retrofitpractice

import android.content.Context
import android.util.Log
import com.exmple.retrofitpractice.model.SignedData.token
import okhttp3.Interceptor
import okhttp3.Response

/**
 * @author Anis Parvez
 * Created on 27,June,2021
 */
class AuthInterceptor constructor(private val context: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        /*val token = sharedPref.getToken()
        val tokenType = sharedPref.getTokenType()*/

        Log.d("TAG", "intercept: token: $token")
        if (!token.isNullOrEmpty()) requestBuilder.addHeader(AUTHORIZATION, "$tokenType $token")

        requestBuilder.addHeader(Package_Name, context.packageName)
        requestBuilder.addHeader(Apk_Version, "${BuildConfig.VERSION_CODE}")

        return chain.proceed(requestBuilder.build())
    }

    companion object {
        private const val AUTHORIZATION = "Authorization"
        private const val Package_Name = "Package-Name"
        private const val Apk_Version = "Apk-Version"
        private const val tokenType = "token"
    }
}