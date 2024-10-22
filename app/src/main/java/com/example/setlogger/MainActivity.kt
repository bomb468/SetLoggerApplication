package com.example.setlogger

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.setlogger.database.WorkoutDatabase
import com.example.setlogger.database.daos.WorkoutDetailsDao
import com.example.setlogger.databinding.ActivityMainBinding
import com.example.setlogger.repository.WorkoutDetailsRepository
import com.example.setlogger.viewModels.WorkoutSelectionViewModel
import com.example.setlogger.viewModels.WorkoutSelectionViewModelFactory
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var navHostFragment: NavHostFragment
    lateinit var repository: WorkoutDetailsRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        repository = WorkoutDetailsRepository(WorkoutDatabase.getInstance(this).workoutDetailsDao)



        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpNavigation()
    }

    private fun setUpNavigation(){
        navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
    }
}