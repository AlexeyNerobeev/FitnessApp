package com.example.fitnessapp.feature_app.data.repositoryImplementation

import com.example.fitnessapp.data.supabase.Connect.supabase
import com.example.fitnessapp.feature_app.domain.models.Notification
import com.example.fitnessapp.feature_app.domain.repository.NotificationRepository
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Columns
import org.koin.androidx.compose.get

class NotificationRepositoryImpl: NotificationRepository {
    override suspend fun getNotifications(): List<Notification> {
        val notifications = supabase.postgrest["notifications"].select(
            columns = Columns.list(
                "created_at",
                "image",
                "text"
            )
        ){
            filter {
                and{
                    eq("user_id", getUserId())
                }
            }
        }.decodeList<Notification>()
        return notifications
    }

    private suspend fun getUserId(): String{
        supabase.auth.awaitInitialization()
        return supabase.auth.currentUserOrNull()?.id?:""
    }

    override suspend fun newNotification() {
        val notification = Notification(user_id = getUserId(),
            image = "https://sakpfhsanlbgslhkkknq.supabase.co/storage/v1/object/public/NotificationIcons//breakfast_icon.svg",
            text = "Привет, пора завтракать")
        supabase.postgrest["notifications"].insert(notification)
    }
}