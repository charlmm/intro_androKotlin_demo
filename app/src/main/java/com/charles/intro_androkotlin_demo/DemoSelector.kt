package com.charles.intro_androkotlin_demo

import android.os.Bundle
import android.app.Activity
import android.content.Intent
import android.view.Gravity
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.BaseExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.TextView
import android.widget.Toast

class DemoSelector : Activity() {

    internal var elvChapters: ExpandableListView? = null
    internal var elaAdapter: ChaptersListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo_selector)
        setupChaptersListView()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.activity_demo_selector, menu)
        return true
    }

    private fun setupChaptersListView() {
        elvChapters = findViewById<ExpandableListView>(R.id.elvChapters)
        elaAdapter = ChaptersListAdapter()
        elvChapters!!.setAdapter(elaAdapter)
        elvChapters!!.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
            val exerciseTitle = elaAdapter!!.getChild(groupPosition, childPosition) as String
            val exerciseClass = elaAdapter!!.getExerciseClass(groupPosition, childPosition, id)
            if (exerciseClass != null) {
                Toast.makeText(this@DemoSelector, exerciseTitle, Toast.LENGTH_LONG).show()
                startActivity(Intent(this@DemoSelector, exerciseClass))
            } else {
                Toast.makeText(this@DemoSelector, "Exercise Not Available", Toast.LENGTH_SHORT).show()
            }
            false
        }

    }

    inner class ChaptersListAdapter : BaseExpandableListAdapter() {
        private val chapters = resources.getStringArray(R.array.chapters)
        private val exercises: Array<Array<String>?>

        // Layout parameters for the ExpandableListView
        // Center the text vertically
        // Set the text starting position
        private val genericView: TextView
            get() {
                val lp = AbsListView.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
                )

                val textView = TextView(this@DemoSelector)
                textView.layoutParams = lp
                textView.textSize = 20f
                textView.gravity = Gravity.CENTER_VERTICAL or Gravity.LEFT
                textView.setPadding(60, 20, 20, 20)
                return textView
            }

        init {
            exercises = arrayOfNulls(chapters.size)
            for (i in exercises.indices) {
                val resId = resources.getIdentifier("chap" + (i + 1), "array", packageName)
                exercises[i] = resources.getStringArray(resId)
            }
        }


        override fun getChild(groupPosition: Int, childPosition: Int): Any {
            return exercises[groupPosition]!![childPosition]
        }

        override fun getChildId(groupPosition: Int, childPosition: Int): Long {
            return childPosition.toLong()
        }

        override fun getChildrenCount(groupPosition: Int): Int {
            return exercises[groupPosition]!!.size
        }

        override fun getChildView(
            groupPosition: Int, childPosition: Int, isLastChild: Boolean,
            convertView: View, parent: ViewGroup
        ): View {
            val textView = genericView
            textView.setPadding(80, 20, 20, 20)
            textView.text = getChild(groupPosition, childPosition).toString()
            return textView
        }

        override fun getGroup(groupPosition: Int): Any {
            return "Chapter " + (groupPosition + 1) + ": " + chapters[groupPosition]
        }

        override fun getGroupCount(): Int {
            return chapters.size
        }

        override fun getGroupId(groupPosition: Int): Long {
            return groupPosition.toLong()
        }

        override fun getGroupView(
            groupPosition: Int, isExpanded: Boolean, convertView: View,
            parent: ViewGroup
        ): View {
            val textView = genericView
            textView.text = getGroup(groupPosition).toString()
            return textView
        }

        override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
            return true
        }

        override fun hasStableIds(): Boolean {
            return true
        }

        fun getExerciseClass(groupPosition: Int, childPosition: Int, id: Long): Class<out Activity>? {
            val exerciseId = "chap" + (groupPosition + 1) + "ex" + (childPosition + 1)
            return ExerciseActivityMapper.getExerciseClass(exerciseId)
        }
    }

}
