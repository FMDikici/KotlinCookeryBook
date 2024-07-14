package com.fmd.yemekkitabi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.atilsamancioglu.yemektariflerikitabi.R
import com.atilsamancioglu.yemektariflerikitabi.databinding.FragmentListeBinding
import com.fmd.yemekkitabi.adapter.Tarifadapter
import com.fmd.yemekkitabi.model.tarif
import com.fmd.yemekkitabi.roomdb.TarifDAO
import com.fmd.yemekkitabi.roomdb.Tarifdatabase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers


class ListeFragment : Fragment() {
    private var _binding:FragmentListeBinding? = null

    private val binding get() = _binding!!

    private lateinit var db: Tarifdatabase
    private lateinit var tarifDao: TarifDAO
    private val mDisposable= CompositeDisposable()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        db= Room.databaseBuilder(requireContext(),Tarifdatabase::class.java,"Tarifler").build()
        tarifDao=db.tarifDao()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        binding.floatingActionButton.setOnClickListener{yeniEkle(it)}
        binding.tarifRecyclerView.layoutManager=LinearLayoutManager(requireContext())

    }

    private fun verileriAl(){
        mDisposable.add(
            tarifDao.getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
        )
    }
    private fun handleResponse(tarifler:List<tarif>){
        val adapter =Tarifadapter(tarifler)
        binding.tarifRecyclerView.adapter=adapter
    }

    fun yeniEkle(view:View){
        val action=ListeFragmentDirections.actionListeFragmentToTarifFragment(bilgi="eski",id=0)
        Navigation.findNavController(view).navigate(action)
    }


}


