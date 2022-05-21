package com.example.fitness_app

import android.content.Context

class Prefs(val context: Context) {
    val name = "shared"
    val l = "isLogin"
    val idn = "id"
    val isdata = "insert"
    val kca = "kca"
    val nej = "nej"
    val min ="min"
    val shared = context.getSharedPreferences(name, 0)

    fun saveIsLogin(isLogin:Boolean){
        shared.edit().putBoolean(l, isLogin ).apply()
    }

    fun getIsLogin():Boolean{
      return  shared.getBoolean(l, false)
    }

    fun saveId(id:Int){
        shared.edit().putInt(idn, id).apply()
    }

    fun getID():Int{
        return shared.getInt(idn, 0)
    }

    fun saveIsDataInsert(IsDataInsert:Boolean){
        shared.edit().putBoolean(isdata, IsDataInsert ).apply()
    }

    fun getIsDataInsert():Boolean{
        return  shared.getBoolean(isdata, false)
    }
    fun savekca(kcal:Int){
        shared.edit().putInt(kca, kcal).apply()
    }
    fun getkca():Int{
        return shared.getInt(kca, 0)
    }
    fun savenej(nj:Int){
        shared.edit().putInt(nej, nj).apply()
    }
    fun getnej():Int{
        return shared.getInt(nej, 0)
    }
    fun savemi(mi:Int){
        shared.edit().putInt(min, mi).apply()
    }
    fun getmi():Int{
        return shared.getInt(min, 0)
    }

}