package com.example.fitnessapp.feature_app.data.repositoryImplementation

import com.example.fitnessapp.data.supabase.Connect.supabase
import com.example.fitnessapp.feature_app.domain.models.Workout
import com.example.fitnessapp.feature_app.domain.repository.WorkoutRepository
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Columns

class WorkoutRepositoryImpl: WorkoutRepository {
    override suspend fun getWorkoutData(): Workout {
        return supabase.postgrest["workout"].select(
            columns = Columns.list(
                "name",
                "complexity",
                "description"
            )
        ).decodeSingle<Workout>()
    }
}