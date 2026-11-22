package ui.screen


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextObfuscationMode
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SecureTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.garden.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun RegistrationScreen(onClick: () -> Unit){

    var passwordHidden by rememberSaveable { mutableStateOf(true) }

    val fieldColors = TextFieldDefaults.colors(
        focusedContainerColor = Color(0xFFF3F4F6),
        unfocusedContainerColor = Color(0xFFF3F4F6),
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent
    )

    Box(
        modifier = Modifier.fillMaxSize().background(Color.Gray).imePadding()
    ){
        Card(
            modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
            ),
            shape = RoundedCornerShape(
                topStart = 24.dp,
                topEnd = 24.dp
            ),
        ){

            TextField(
                modifier = Modifier.fillMaxWidth().padding(30.dp),
                state = rememberTextFieldState(),
                label = { Text("login") },
                colors = fieldColors,
                shape = RoundedCornerShape(12.dp),
            )
            SecureTextField(
                state = rememberTextFieldState(),
                label = { Text("password") },
                modifier = Modifier.fillMaxWidth().padding(30.dp),
                textObfuscationMode = if (passwordHidden) {
                    TextObfuscationMode.RevealLastTyped
                } else {
                    TextObfuscationMode.Visible
                },
                trailingIcon = {
                    IconButton(onClick = { passwordHidden = !passwordHidden }) {
                        Icon(
                            painter = painterResource(
                                id = if (passwordHidden) R.drawable.passw_eye_closed else R.drawable.passw_eye_open
                            ),
                            contentDescription = if (passwordHidden) "Показать пароль" else "Скрыть пароль"
                        )
                    }
                },
                colors = fieldColors,
                shape = RoundedCornerShape(12.dp),
            )

            Button(
                modifier = Modifier.fillMaxWidth().padding(30.dp),
                onClick = { onClick() }
            ) {
                Text("Log in ->")
            }
        }
    }
}