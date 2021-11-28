package com.websarva.wings.android.firebasetest1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.util.Log
import android.widget.EditText
import android.widget.TextView

import androidx.annotation.WorkerThread
import com.google.android.gms.tasks.Task
import com.google.android.gms.tasks.Tasks
import com.google.firebase.Timestamp
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FieldPath
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.google.firebase.firestore.MetadataChanges
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ServerTimestamp
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.Source
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.firestoreSettings
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import java.util.ArrayList
import java.util.Date
import java.util.HashMap
import java.util.concurrent.Callable
import java.util.concurrent.Executor
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

/**
 * 『Androidアプリ開発の教科書Kotlin』
 * 第4章
 * イベントとリスナサンプル
 *
 * メインアクティビティクラス。
 *
 * @author Shinzo SAITO
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 表示ボタンであるButtonオブジェクトを取得。
        val btClick = findViewById<Button>(R.id.btClick)
      /*  val btnClick2 = findViewById<ImageView>(R.id.imageView3)  */

        // リスナクラスのインスタンスを生成。
        val listener = HelloListener()
        // 表示ボタンにリスナを設定。
        btClick.setOnClickListener(listener)
/*  btnClick2.setOnClickListener(listener) */


  // クリアボタンであるButtonオブジェクトを取得。
  val btClear = findViewById<Button>(R.id.btClear)
  // クリアボタンにリスナを設定。
  btClear.setOnClickListener(listener)
}

/**
* ボタンをクリックしたときのリスナクラス。
*/
private inner class HelloListener : View.OnClickListener {
  override fun onClick(view: View) {
      // 名前入力欄であるEditTextオブジェクトを取得。
      val input = findViewById<EditText>(R.id.etName)
      // メッセージを表示するTextViewオブジェクトを取得。
      val output = findViewById<TextView>(R.id.tvOutput)

      // idのR値に応じて処理を分岐。
      when(view.id) {
          // 表示ボタンの場合…
          R.id.btClick -> {
              // 入力された名前文字列を取得。
              val inputStr = input.text.toString()
              // メッセージを表示。
              output.text = inputStr + "さん、こんにちは!"
          }
          R.id.imageView3 -> {
              // 入力された名前文字列を取得。
              val inputStr = input.text.toString()
              // メッセージを表示。
              output.text = inputStr + "さん、こんにちは!"
          }
          // クリアボタンの場合…
          R.id.btClear -> {
              // 名前入力欄を空文字に設定。
              input.setText("")
              // メッセージ表示欄を空文字に設定。
              output.text = ""
          }
      }
      output.text = "AAAAA!"
       val TAG = "DocSnippets"
        // Create a new user with a first and last name
              val user = hashMapOf(
                  "first" to input.text,
                  "last" to "Lovelace",
                  "born" to 1815
              )
        // Access a Cloud Firestore instance from your Activity

              val db = Firebase.firestore
      output.text = "AAAAA!2"
        // Add a new document with a generated ID
              db.collection("users")
                  .add(user)
                  .addOnSuccessListener { documentReference ->
                      Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                      output.text = "suc"
                  }
                  .addOnFailureListener { e ->
                      Log.w(TAG, "Error adding document", e)
                      output.text = "Error adding document" +  e
                  }

    /*  // 名前入力欄であるEditTextオブジェクトを取得。
      val input = findViewById<EditText>(R.id.etName)
      // メッセージを表示するTextViewオブジェクトを取得。
      val output = findViewById<TextView>(R.id.tvOutput)

      // idのR値に応じて処理を分岐。
      when(view.id) {
          // 表示ボタンの場合…
          R.id.btClick -> {
              // 入力された名前文字列を取得。
              val inputStr = input.text.toString()
              // メッセージを表示。
              output.text = inputStr + "さん、こんにちは!"
          }
          R.id.imageView3 -> {
              // 入力された名前文字列を取得。
              val inputStr = input.text.toString()
              // メッセージを表示。
              output.text = inputStr + "さん、こんにちは!"
          }
          // クリアボタンの場合…
          R.id.btClear -> {
              // 名前入力欄を空文字に設定。
              input.setText("")
              // メッセージ表示欄を空文字に設定。
              output.text = ""  */
          }
      }
  }


