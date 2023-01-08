package projectxclone.adityakumarsinha0000

import android.content.Intent
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_loggedinn.*

class Loggedinn : AppCompatActivity() {

    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loggedinn)
        Toast.makeText(this ,"Login successful", Toast.LENGTH_SHORT).show()

    }
    fun logout(view: View) {
        Firebase.auth.signOut()
        val intent =Intent(this , MainActivity::class.java)
        startActivity(intent)
        Toast.makeText(this ,"Log-out successful", Toast.LENGTH_SHORT).show()
    }

}