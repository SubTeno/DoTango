package com.example.dotango


import com.google.gson.annotations.SerializedName

data class Items(
    @SerializedName("items")
    val items: List<Item> = listOf()
) {
    data class Item(
        @SerializedName("attrib")
        val attrib: List<Attrib> = listOf(),
        @SerializedName("cd")
        val cd: Any = Any(),
        @SerializedName("charges")
        val charges: Any = Any(),
        @SerializedName("components")
        val components: Any = Any(),
        @SerializedName("cost")
        val cost: Int = 0,
        @SerializedName("created")
        val created: Boolean = false,
        @SerializedName("desc")
        val desc: String = "",
        @SerializedName("dname")
        val dname: String = "",
        @SerializedName("hint")
        val hint: List<String> = listOf(),
        @SerializedName("id")
        val id: Int = 0,
        @SerializedName("img")
        val img: String = "",
        @SerializedName("lore")
        val lore: String = "",
        @SerializedName("mc")
        val mc: Any = Any(),
        @SerializedName("notes")
        val notes: String = "",
        @SerializedName("qual")
        val qual: String = "",
        @SerializedName("tier")
        val tier: Int = 0
    ) {
        data class Attrib(
            @SerializedName("footer")
            val footer: String = "",
            @SerializedName("generated")
            val generated: Boolean = false,
            @SerializedName("header")
            val header: String = "",
            @SerializedName("key")
            val key: String = "",
            @SerializedName("value")
            val value: Any = Any()
        )
    }
}