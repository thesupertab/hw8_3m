package com.example.hw8_3m

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.hw8_3m.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var binding:FragmentMainBinding

    private val seriesList = arrayListOf(
        Series("https://www.google.com/url?sa=i&url=https%3A%2F%2Fthedirect.com%2Farticle%2Frick-and-morty-season-7-release-date-schedule-episodes-official&psig=AOvVaw3Rkm54F4yJWNxScaZuAoeM&ust=1704635393412000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCOCDgu3zyIMDFQAAAAAdAAAAABAD","Alive","Rich Sanchez"),
        Series("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.facebook.com%2FMortySmithS%2F%3Flocale%3Dru_RU&psig=AOvVaw1mHOxjsbKqvk89PPt33S6d&ust=1704635500458000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCKC0sqT0yIMDFQAAAAAdAAAAABAD","Alive","Morthy Smith"),
        Series("https://www.google.com/url?sa=i&url=https%3A%2F%2Frickandmorty.fandom.com%2Fwiki%2FAlbert_Einstein&psig=AOvVaw3qcgpJNkhpRNT8-_UYyU6L&ust=1704635681445000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCMCznfT0yIMDFQAAAAAdAAAAABAD","Dead","Albert Einstein"),
        Series("https://www.google.com/url?sa=i&url=https%3A%2F%2Frickandmorty.fandom.com%2Fwiki%2FJerry_Smith&psig=AOvVaw1v-87X5Oo_itpFLl9oO3dX&ust=1704635823679000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCPj54rn1yIMDFQAAAAAdAAAAABAD","Alive","Jerry Smith")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        val adapter = SeriesAdapter(seriesList, this::onClick)
        binding.posterRv.adapter = adapter
    }

    private fun onClick(model: Series){
        findNavController().navigate(R.id.firstFragment, bundleOf("start" to model))
    }
}