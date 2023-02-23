package com.example.myapplication.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.*
import com.example.myapplication.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


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
        //dashboardViewModel.text.observe(viewLifecycleOwner) {
        //    textView.text = it
        //}



        if (favoriteList.isEmpty()){textView.text = "Você não tem nenhum favorito adicionado."}
        //favoriteList.add(Character(1,"renata","ola", R.drawable.char3))

        binding.favoriteRecycler.apply {
            layoutManager = GridLayoutManager(meuContexto,1)
            adapter = CardAdapterDetails(favoriteList)
        }

        val swipeToDeleteCallBack = object : SwipeToDeleteCallBack(){
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                favoriteList.removeAt(position)
                binding.favoriteRecycler.adapter?.notifyItemRemoved(position)
            }
        }

        val itemTouchHelper = ItemTouchHelper(swipeToDeleteCallBack)
        itemTouchHelper.attachToRecyclerView(binding.favoriteRecycler)

        return root


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}