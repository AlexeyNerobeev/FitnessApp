package com.example.fitnessapp.feature_app.data.repositoryImplementation

import com.example.fitnessapp.data.supabase.Connect.supabase
import com.example.fitnessapp.feature_app.domain.models.Target
import com.example.fitnessapp.feature_app.domain.repository.TargetRepository
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Columns

class TargetRepositoryImpl: TargetRepository {
    override suspend fun getTodayTarget(): Target {
        return supabase.postgrest["targets"].select(
            columns = Columns.list(
                "water",
                "steps"
            )
        ){
            filter {
                and {
                    eq("user_id", getUserId())
                }
            }
        }.decodeSingle<Target>()
    }

    private suspend fun getUserId(): String{
        supabase.auth.awaitInitialization()
        return supabase.auth.currentUserOrNull()?.id?:""
    }
}