package com.example.fitnessapp.data.repository

import com.example.fitnessapp.data.models.Profile
import com.example.fitnessapp.data.supabase.Connect.supabase
import com.example.fitnessapp.feature_app.domain.repository.AuthRepository
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Columns

class AuthRepositoryImpl: AuthRepository {
    override suspend fun logIn(inputEmail: String, inputPassword: String) {
        supabase.auth.signInWith(Email){
            email = inputEmail
            password = inputPassword
        }
    }

    override suspend fun registration(inputEmail: String, inputPassword: String) {
        supabase.auth.signUpWith(Email){
            email = inputEmail
            password = inputPassword
        }
    }

    override suspend fun addFioNumber(fio: String, number: String) {
        val profile = Profile(fio = fio, phone = number, user_id = getUserId())
        supabase.postgrest["profile"].insert(profile)
    }

    override suspend fun addProfile(
        gender: String,
        birthday: String,
        weight: Int,
        height: Int
    ) {
        val profile = Profile(gender = gender, birthday = birthday, weight = weight,
            height = height)
        supabase.from("profile").update(profile){
            filter {
                and {
                    eq("user_id", getUserId())
                }
            }
        }
    }

    override suspend fun addTarget(target: String) {
        val target = Profile(target = target)
        supabase.from("profile").update(target){
            filter{
                and {
                    eq("user_id", getUserId())
                }
            }
        }
    }

    override suspend fun getName(): String {
        val name = supabase.postgrest["profile"].select(
            columns = Columns.list(
                "fio"
            )
        ){
            filter {
                and {
                    eq("user_id", getUserId())
                }
            }
        }.decodeSingle<Profile>()
        return name.fio
    }

    private suspend fun getUserId() : String{
        supabase.auth.awaitInitialization()
        return supabase.auth.currentUserOrNull()?.id ?: ""
    }
}