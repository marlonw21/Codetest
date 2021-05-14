package com.mw21.codetest.presentation.home
import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mw21.codetest.R
import com.mw21.codetest.presentation.addcolaborator.AddColaboratorActivity
import com.mw21.codetest.presentation.colaborator.ColaboratorsActivity
import com.mw21.codetest.presentation.di.Injector
import kotlinx.android.synthetic.main.activity_home.*
import java.io.*
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {
    var downloadID: Long?=null
    var manager: DownloadManager?=null
    @Inject
    lateinit var factory: HomeViewModelFactory
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        (application as Injector).createHomeSubComponent()
            .inject(this)

        homeViewModel = ViewModelProvider(this, factory)
            .get(HomeViewModel::class.java)
        getJsonResponse()
        var broadcastReceiver = object : BroadcastReceiver(){
            override fun onReceive(context: Context?, intent: Intent?) {
                var id = intent?.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1)
                if (downloadID == id){
               //     unzip(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "employees_json.zip")
                    Toast.makeText(this@HomeActivity, "donwlasld", Toast.LENGTH_SHORT).show()
                }
            }

        }
        registerReceiver(broadcastReceiver, IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE))
        addColaboratorBtn.setOnClickListener {
            startActivity(Intent(this, AddColaboratorActivity::class.java))
        }
        colaboratorBtn.setOnClickListener {
            startActivity(Intent(this, ColaboratorsActivity::class.java))
        }

    }

    private fun getJsonResponse(){
        showProgressBar()
        homeViewModel.getJsonResponse().observe(this, Observer {
            Log.d("HOME", it.toString())
            if (it != null) {
                hideProgressBar()
                downloadFile(it.data.file, "/data/data/${applicationContext.packageName}/zip/employees_data.zip")
            } else {
                hideProgressBar()
                Toast.makeText(this, "Error in response", Toast.LENGTH_SHORT).show()
            }
        })
    }
    fun showProgressBar(){
        progressBarHome.visibility = View.VISIBLE
    }
    fun hideProgressBar(){
        progressBarHome.visibility = View.GONE
    }
    private fun downloadFile(url: String, path: String){
      //  showProgressBar()
        Toast.makeText(this, "download file", Toast.LENGTH_SHORT).show()
        val request = DownloadManager.Request(Uri.parse(url))
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI)
        request.setTitle("Downloading file")
        request.setDescription("Please wait..")
        request.allowScanningByMediaScanner()
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "employees_json.zip")
        manager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        downloadID =  manager?.enqueue(request)
    }
    private fun saveInfoToDB(){

    }
    private fun backupTOCloudFirestore(){

    }
    private fun unzip(path: File, file: String){
//        try{
//            val destDir = File( "" )
//            if (!destDir.exist()){
//                destDir.mkDir()
//            }
//            ZipFile(path).use {zip ->
//
//                zip.entries().asSequence().forEach {entry ->
//
//                    zip.getInputStream(entry).use { input ->
//
//
//                        val filePath = destDir + File.separator + entry.name
//
//                        if (!entry.isDirectory) {
//                            // if the entry is a file, extracts it
//                            extractFile(input, filePath)
//                        } else {
//                            // if the entry is a directory, make the directory
//                            val dir = File(filePath + "")
//                            dir.mkdir()
//                        }
//
//                    }
//
//                }
//
//            }
//
//        }catch(e: Exception){
//            e.printStackTrace()
//
//        }
       /* try{
            var fileInputStream = FileInputStream(path+"/"+file)
            if (fileInputStream != null){
                Log.d("Continue", "is not null")
            }else{
                Log.d("stop", "is null")
            }
            var zipInputStream = ZipInputStream(fileInputStream)
            var zipEntry: ZipEntry?=null
            while( {zipEntry = zipInputStream.nextEntry} !=null){
                Log.d("Decompress", "Unzipping " + zipEntry?.getName());
            }

        }catch (e: Exception){
            e.printStackTrace()
        }

        */

    }

//    private fun extractFile(inputStream: InputStream, destFilePath: String) {
//        val bos = BufferedOutputStream(FileOutputStream(destFilePath))
//        val bytesIn = ByteArray(BUFFER_SIZE)
//        var read: Int
//        while (inputStream.read(bytesIn).also { read = it } != -1) {
//            bos.write(bytesIn, 0, read)
//        }
//        bos.close()
//    }
//    private val BUFFER_SIZE = 4096
}