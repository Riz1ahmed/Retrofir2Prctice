package com.exmple.retrofitpractice

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object GSonUtils {
    /**
     * Convert data to json string.
     * @param data it would be any type of data. Would be
     * Int,String,Float,
     * or
     * model data class EX: UserInfo,ProductModel etc.
     *
     * You will rollback your data by call string2data function
     * with parameter of it's returned value.
     */
    //fun data2String(data: Any) = Gson().toJson(data)

    /**
     * @param stringData jsonString of T type data.
     * T would be anything (data class, Int, String etc).
     * @param clazz class of T. for example if your data is
     * Float type then "Float::class.java", if X data class
     * then "X::class.java".
     *
     * call it as:
     * GSonUtils.string2data(stringData,ClassName::class.java)
     */
    /*fun <T> string2data(stringData: String, clazz: Class<T>?): T {
        return Gson().fromJson(stringData, clazz)!!
    }

    fun json2ProductList(stringData: String): ArrayList<ProductData> {
        val gson = Gson()
        val type = object : TypeToken<ArrayList<ProductData>>() {}.type
        return gson.fromJson(stringData, type)
    }*/


    /**
     * Convert data to json string.
     * @param data it would be any type of data. Would be
     * Int,String,Float or model data class EX: UserInfo,ProductModel etc.
     *
     * You will rollback your data by call fromJson function
     * with parameter of it's returned value.
     */
    fun <T> toJson(data: T): String? = Gson().toJson(data)

    /**
     * @param jsonData jsonString of T type data.
     * T would be anything (data class, Int, String etc).
     *
     * call process: GSonUtils.fromJson<Type>(JsonStrData)
     *
     * Ex:
     *  1. val products = GSonUtils.fromJson<ArrayList<ProductData>>(productsJson)
     *  2. val products:ArrayList<ProductData> = GSonUtils.fromJson(productsJson)
     */
    inline fun <reified T> fromJson(jsonData: String): T {
        return Gson().genericFromJson<T>(jsonData)
    }

    /**
     * Json Generic type converter.
     *
     * Please do not call this method from anywhere.
     * It's actually inner method of this object
     * */
    inline fun <reified T> Gson.genericFromJson(json: String): T {
        return fromJson(json, object : TypeToken<T>() {}.type)
    }

}