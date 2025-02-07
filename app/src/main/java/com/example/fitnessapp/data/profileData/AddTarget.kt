package com.example.fitnessapp.data.profileData

import android.util.Log
import com.example.fitnessapp.data.models.Profile
import com.example.fitnessapp.data.supabase.Connect.supabase
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AddTarget {
    suspend fun addTarget(target: String, userId: String){
        withContext(Dispatchers.Main){
            try{
                val profile = Profile(target = target, user_id = userId)
                supabase.from("profile").update(profile){
                    filter {
                        and {
                            eq("user_id", profile.user_id)
                        }
                    }
                }
            } catch(ex:Exception){
                Log.e("supa", ex.message.toString())
            }
        }
    }
}