package projectxclone.adityakumarsinha0000

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {


    private lateinit var email:EditText
    private lateinit var password:EditText
    private lateinit var login:Button

    private lateinit var semail:String
    private lateinit var spassword:String

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        email=findViewById(R.id.email)
        password=findViewById(R.id.password)
        login=findViewById(R.id.login)

        auth= Firebase.auth

        login.setOnClickListener{

            semail=email.text.toString().trim()
            spassword=password.text.toString().trim()

            auth.signInWithEmailAndPassword(semail, spassword)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("TAG", "signInWithEmail:success")
                        val user = auth.currentUser
                        updateUI(user)
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("TAG", "signInWithEmail:failure", task.exception)
                        Toast.makeText(baseContext, "Incorrect Login credentials.",
                            Toast.LENGTH_SHORT).show()
//                        updateUI(null)
                    }
                }


        }
    }

    private fun updateUI(user: FirebaseUser?) {
//        intent.putExtra('data',user)
        val intent =Intent(this , Loggedinn::class.java)
        startActivity(intent)
    }


    fun sign_up(view: View) {
        val intent =Intent(this , Registerr::class.java)
        startActivity(intent)
    }

    fun viewhide(view: View) {}

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if(currentUser != null){
            updateUI(currentUser);

            Toast.makeText(baseContext, "Already logged in.",
                Toast.LENGTH_SHORT).show()
        }
    }
}