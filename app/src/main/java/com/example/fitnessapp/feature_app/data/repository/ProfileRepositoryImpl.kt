package com.example.fitnessapp.feature_app.data.repository

import com.example.fitnessapp.data.supabase.Connect.supabase
import com.example.fitnessapp.feature_app.domain.models.Profile
import com.example.fitnessapp.feature_app.domain.repository.ProfileRepository
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Columns

class ProfileRepositoryImpl: ProfileRepository {
    override suspend fun getProfile(): Profile {
        val profile = supabase.postgrest["profile"].select(
            columns = Columns.list(
                "fio",
                "target",
                "height",
                "weight",
                "birthday"
            )
        ){
            filter {
                and {
                    eq("user_id", getUserId())
                }
            }
        }.decodeSingle<Profile>()
        return profile
    }

    private suspend fun getUserId(): String{
        supabase.auth.awaitInitialization()
        return supabase.auth.currentUserOrNull()?.id?:""
    }
}