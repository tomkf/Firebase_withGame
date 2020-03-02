package com.example.firebasegame

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_auth.*

class AuthActivity: AppCompatActivity() {
    private lateinit var authMode: AuthMode

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_login)

        authMode = intent?.extras?.getParcelable(AuthModeExtraName)!!

        when(authMode) {
            is AuthMode.Login -> { auth_button.text = getString(R.string.login)}
            is AuthMode.Register -> { auth_button.text = getString(R.string.register) }
        }
    }

    companion object {
        const val AuthModeExtraName = "AUTH_MODE"

        fun newIntent(authMode: AuthMode, context: Context): Intent {
            val intent = Intent(context, AuthActivity::class.java)
            intent.putExtra(AuthModeExtraName, authMode)
            return intent
        }
    }
}