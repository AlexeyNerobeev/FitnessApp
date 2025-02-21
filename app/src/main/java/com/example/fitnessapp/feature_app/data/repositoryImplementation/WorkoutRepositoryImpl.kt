package com.example.fitnessapp.feature_app.data.repositoryImplementation

import com.example.fitnessapp.data.supabase.Connect.supabase
import com.example.fitnessapp.feature_app.domain.models.CompleteWorkouts
import com.example.fitnessapp.feature_app.domain.models.Exercise
import com.example.fitnessapp.feature_app.domain.models.Workout
import com.example.fitnessapp.feature_app.domain.repository.WorkoutRepository
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Columns

class WorkoutRepositoryImpl: WorkoutRepository {
    override suspend fun getWorkoutData(): Workout {
        return supabase.postgrest["workout"].select(
            columns = Columns.list(
                "name",
                "complexity",
                "description",
                "date"
            )
        ).decodeSingle<Workout>()
    }

    override suspend fun saveCompleteWorkout(name: String, status: String) {
        val workout = CompleteWorkouts(name = name, status = status, user_id = getUserId())
        supabase.postgrest["completeWorkouts"].insert(workout)
    }

    private suspend fun getUserId(): String{
        supabase.auth.awaitInitialization()
        return supabase.auth.currentUserOrNull()?.id?:""
    }

    override suspend fun getExerciseData(): Exercise {
        return supabase.postgrest["exercise"].select(
            columns = Columns.list(
                "name",
                "complexity",
                "description",
                "approaches"
            )
        ).decodeSingle<Exercise>()
    }
}