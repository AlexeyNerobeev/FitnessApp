package com.example.fitnessapp.data.profileData

import android.util.Log
import androidx.compose.ui.text.font.FontWeight
import com.example.fitnessapp.data.models.Profile
import com.example.fitnessapp.data.supabase.Connect.supabase
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.datetime.LocalDate

class AddProfile {
    suspend fun addProfile(fio: String, height: Int, weight: Int, birthDay: String, userId: String,
                           gender: String){
        withContext(Dispatchers.Main){
            try {
                val profile = Profile(fio = fio, height = height, weight = weight, birthday = birthDay,
                    user_id = userId, gender = gender)
                supabase.from("profile").insert(profile)
            } catch (ex:Exception){
                Log.e("supa", ex.message.toString())
            }
        }
    }
}