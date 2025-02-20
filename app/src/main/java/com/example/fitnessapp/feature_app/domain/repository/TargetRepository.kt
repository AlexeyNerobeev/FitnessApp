package com.example.fitnessapp.feature_app.domain.repository

import com.example.fitnessapp.feature_app.domain.models.Target

interface TargetRepository {
    suspend fun getTodayTarget(): Target
}