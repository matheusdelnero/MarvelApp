package com.example.myapplication.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.size
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.*
import com.example.myapplication.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment(), CharacterClickListener {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onClick(character: Character) {
        val intent = Intent(context,DetailActivity::class.java)
        intent.putExtra(CHAR_ID_EXTRA,character.id)
        startActivity(intent)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val textView: TextView = binding.textDashboard
        val meuContexto = this.context
        val home = this
        //dashboardViewModel.text.observe(viewLifecycleOwner) {
        //    textView.text = it
        //}


        if (favoriteList.isEmpty()){textView.text = "Você não tem nenhum favorito adiconado."}
        //favoriteList.add(Character(1,"renata","ola", R.drawable.char3))

        binding.favoriteRecycler.apply {
            layoutManager = GridLayoutManager(meuContexto,1)
            adapter = CardAdapter(favoriteList,home )
        }
        return root


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}