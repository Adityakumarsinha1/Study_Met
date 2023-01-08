package projectxclone.adityakumarsinha0000

import android.content.Intent
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_registerr.*


class Registerr : AppCompatActivity(){

    private lateinit var email:EditText
    private lateinit var password:EditText
    private lateinit var cpassword:EditText
    private lateinit var register:Button

    private lateinit var semail:String
    private lateinit var spassword:String
    private lateinit var scpassword:String


    private lateinit var auth: FirebaseAuth

    @SuppressLint("SetTextI18n")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registerr)

//        Toast.makeText(this ,"Welcome TO The Registration Page.", Toast.LENGTH_SHORT).show()

        auth= Firebase.auth


        email=findViewById(R.id.email)
        password=findViewById(R.id.password)
        cpassword=findViewById(R.id.cpassworde)
        register=findViewById(R.id.register)


        register.setOnClickListener{

            semail=email.text.toString().trim()
            spassword=password.text.toString().trim()
            scpassword=cpassword.text.toString().trim()


            if (semail.isEmpty()||spassword.isEmpty()||scpassword.isEmpty()) {
                Toast.makeText(this, "Email and passwords can not be empty", Toast.LENGTH_SHORT).show()
            }
            else{
                if (spassword == scpassword) {
                    auth.createUserWithEmailAndPassword(semail, scpassword)
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d("TAG", "createUserWithEmail:success")
                                val user = auth.currentUser
                                updateUI(user)
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w("TAG", "createUserWithEmail:failure", task.exception)
                                Toast.makeText(baseContext, "Authentication failed.", Toast.LENGTH_SHORT).show()
//                        updateUI(null)
                            }
                        }
                }
                else {
                    Toast.makeText(this, "Both passwors must be same", Toast.LENGTH_SHORT).show()
                }
                }

        }
    }



    fun viewhide2() {}
    fun login() {
        val intent =Intent(this , MainActivity::class.java)
        startActivity(intent)
    }


    private fun updateUI(user: FirebaseUser?) {
        Toast.makeText(this, "Registration sucessfull", Toast.LENGTH_SHORT).show()
        val intent =Intent(this , MainActivity::class.java)
        startActivity(intent)
    }
}
