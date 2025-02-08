package com.example.fitnessapp.data.supabase

import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest

object Connect {
    val supabase = createSupabaseClient(
        supabaseUrl = "https://sakpfhsanlbgslhkkknq.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InNha3BmaHNhbmxiZ3NsaGtra25xIiwicm9sZSI6ImFub24iLCJpYXQiOjE3Mzg3MzA0ODYsImV4cCI6MjA1NDMwNjQ4Nn0.EvuNCX8DwcBoioavcRxIMh5wXRJo0enbaKnA_9_jHTA"
    ){
        install(Auth)
        install(Postgrest)
    }
}