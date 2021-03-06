package com.example.fitness_app.ui.profile

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.example.fitness_app.Prefs
import com.example.fitness_app.data.database.AppDatabase
import com.example.fitness_app.data.entities.UserEntity
import com.example.fitness_app.databinding.ProfileFragmentBinding
import com.example.fitness_app.ui.ejercicios.FinishActivity
import com.example.fitness_app.ui.login.GetStartActivity

class ProfileFragment : Fragment() {

    private var _binding: ProfileFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var userLiveData:LiveData<UserEntity>
    private lateinit var user:UserEntity
    private val SELECT_ACTIVITY = 50
    private var imageUri:Uri? = null
    private var id:Int? = null

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = ProfileFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val prefs = Prefs(binding.btnCerrarSesion.context)
        val database = AppDatabase.getDatabase(binding.btnCerrarSesion.context)
        userLiveData = database.user().get(prefs.getID())

        userLiveData.observe(viewLifecycleOwner, Observer {
              user = it
            binding.txtNombre.text = user.name+" "+user.surname
        })
        id = prefs.getID()
        val imageUri = ImageController.getImageUri(binding.btnCerrarSesion.context, prefs.getID().toLong())
        binding.imageView5.setImageURI(imageUri)
        binding.btnEdit.setOnClickListener {
            getActivity()?.let { it1 -> ImageController.selectPhotoFromGallery(it1,SELECT_ACTIVITY) }

        }
        binding.btnCerrarSesion.setOnClickListener {

            prefs.saveIsLogin(false)
            prefs.saveId(0)
            prefs.saveIsDataInsert(false)
            prefs.savenej(0)
            prefs.savekca(0)
            prefs.savemi(0)
            startActivity(Intent(binding.btnCerrarSesion.context, GetStartActivity::class.java))
            FinishActivity()
        }

        return root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when{
            requestCode == SELECT_ACTIVITY && resultCode == Activity.RESULT_OK  ->{
                imageUri = data!!.data
                binding.imageView5.setImageURI(imageUri)
                imageUri?.let {
                    ImageController.saveImage(binding.txtNombre.context, id!!.toLong(), it)
                }
            }
        }
    }

}