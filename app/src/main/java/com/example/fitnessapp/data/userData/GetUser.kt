package com.example.fitnessapp.data.userData

import android.util.Log
import com.example.fitnessapp.data.models.User
import com.example.fitnessapp.data.supabase.Connect.supabase
import io.github.jan.supabase.auth.auth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetUser {
    suspend fun getUserId(): String{
        var userId = ""
        withContext(Dispatchers.Main){
            try{
                val supabaseUser = User(supabase.auth.currentUserOrNull()?.id?:"",
                    supabase.auth.currentUserOrNull()?.email?:"")
                userId = supabaseUser.id
            } catch (ex: Exception){
                Log.e("supa", ex.message.toString())
            }
        }
        return userId
    }
}