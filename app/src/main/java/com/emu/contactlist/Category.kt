package com.emu.contactlist

data class Category(
        var categoryType: String,
        var categoryImg: Int

)

object CategoryItem {
    val cat = listOf(
            Category("Friends",R.drawable.ic_friend),
            Category("Family",R.drawable.ic_family),
            Category("Colleagues", R.drawable.ic_colleague),
            Category("Work",R.drawable.ic_work)

    )
}

