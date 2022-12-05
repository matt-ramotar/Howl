package so.howl.android.feature.account

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import so.howl.common.entities.HowlUser

@Composable
fun HowlAccountTab(user: HowlUser) {
    Text(text = user.name)
}