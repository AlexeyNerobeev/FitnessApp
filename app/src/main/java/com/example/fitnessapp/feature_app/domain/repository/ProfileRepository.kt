package com.example.fitnessapp.feature_app.domain.repository

import com.example.fitnessapp.feature_app.domain.models.Profile

interface ProfileRepository {
    suspend fun getProfile(): Profile
}