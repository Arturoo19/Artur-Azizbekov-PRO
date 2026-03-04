package com.example.ordinarianl.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ordinarianl.databinding.FragmentDetalleBinding
import com.example.ordinarianl.model.Post

class DetalleFragment : Fragment() {

    private lateinit var binding: FragmentDetalleBinding
    private lateinit var post: Post

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        post = arguments?.getSerializable("post") as Post
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDetalleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.textTitle.text = post.title
        binding.textBody.text = post.body
        binding.textTags.text =
            post.tags?.joinToString(", ")
    }
}