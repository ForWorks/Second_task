package com.example.my_application.classes

import com.example.my_application.R

class Element(private var avatar: Int, private var title: String, private var description: String) {

    fun getAvatar(): Int { return avatar }
    fun getTitle(): String { return title }
    fun getDescription(): String { return description }

    companion object {
        @JvmStatic
        private val elements: MutableList<Element> = mutableListOf()
        @JvmStatic
        fun getElements(): MutableList<Element> { return elements }
        @JvmStatic
        fun fillElements() {
            for(i in 0..999)
                elements.add(Element(R.drawable.ic_people, "Title $i", "Description $i"))
        }
    }
}