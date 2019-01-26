package com.techguys.wiprotestapp.data.remote.models

import com.google.gson.annotations.SerializedName
import com.techguys.wiprotestapp.ui.models.Feed

data class FeedsResponse(

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("rows")
	val rows: List<Feed>? = null
)